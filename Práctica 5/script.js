const form = document.getElementById('imcForm');
const resultadoDiv = document.getElementById('resultado');
const historialBody = document.getElementById('historialBody');
const btnLimpiar = document.getElementById('btnLimpiar');
const btnDescargar = document.getElementById('btnDescargar'); 

// Cargar historial al iniciar
cargarHistorial();

form.addEventListener('submit', (e) => {
    e.preventDefault();

    const nombre = document.getElementById('nombre').value.trim();
    const peso = parseFloat(document.getElementById('peso').value);
    const altura = parseFloat(document.getElementById('altura').value);

    if (isNaN(peso) || isNaN(altura) || peso <= 0 || altura <= 0) {
        alert('Por favor ingresa valores válidos');
        return;
    }

    const imc = peso / (altura * altura);
    const imcRedondeado = imc.toFixed(2);

    // Clasificación OMS
    let estado = '';
    let clase = '';

    if (imc < 18.5) {
        estado = 'Bajo peso';
        clase = 'bajo';
    } else if (imc < 25) {
        estado = 'Peso normal';
        clase = 'normal';
    } else if (imc < 30) {
        estado = 'Sobrepeso';
        clase = 'sobrepeso';
    } else if (imc < 35) {
        estado = 'Obesidad grado I';
        clase = 'obesidad1';
    } else if (imc < 40) {
        estado = 'Obesidad grado II';
        clase = 'obesidad2';
    } else {
        estado = 'Obesidad grado III';
        clase = 'obesidad3';
    }

    // Mensaje explicativo
    const mensaje = `
        <strong>${nombre}</strong>, tu IMC es: <strong>${imcRedondeado}</strong><br>
        <span class="estado ${clase}">${estado}</span><br><br>
        ${getMensajeExplicativo(estado, imcRedondeado)}
    `;

    resultadoDiv.innerHTML = mensaje;
    resultadoDiv.style.display = 'block';

    // Guardar en historial
    const registro = {
        fecha: new Date().toLocaleString('es-MX'),
        nombre: nombre,
        peso: peso.toFixed(1),
        altura: altura.toFixed(2),
        imc: imcRedondeado,
        estado: estado,
        clase: clase // Guardamos la clase para que el color persista al recargar
    };

    guardarEnHistorial(registro);
    agregarFilaHistorial(registro);
    form.reset(); // Limpia los campos después de calcular
});

// --- FUNCIÓN PARA DESCARGAR EL ARCHIVO TXT ---
btnDescargar.addEventListener('click', () => {
    const historial = JSON.parse(localStorage.getItem('historialIMC')) || [];
    
    if (historial.length === 0) {
        alert("No hay datos en el historial para descargar.");
        return;
    }

    let contenido = "HISTORIAL MÉDICO DE IMC\n";
    contenido += "==========================\n\n";

    historial.forEach((reg, index) => {
        contenido += `Registro #${index + 1}\n`;
        contenido += `Fecha: ${reg.fecha}\n`;
        contenido += `Paciente: ${reg.nombre}\n`;
        contenido += `Peso: ${reg.peso} kg | Altura: ${reg.altura} m\n`;
        contenido += `IMC: ${reg.imc} (${reg.estado})\n`;
        contenido += "--------------------------\n";
    });

    const blob = new Blob([contenido], { type: 'text/plain' });
    const url = URL.createObjectURL(blob);
    const link = document.createElement('a');
    link.href = url;
    link.download = `Historial_IMC_${nombreArchivo()}.txt`;
    link.click();
    URL.revokeObjectURL(url);
});

function nombreArchivo() {
    const d = new Date();
    return `${d.getDate()}-${d.getMonth()+1}-${d.getFullYear()}`;
}

btnLimpiar.addEventListener('click', () => {
    if (confirm('¿Realmente quieres borrar todo el historial?')) {
        localStorage.removeItem('historialIMC');
        historialBody.innerHTML = '';
        resultadoDiv.style.display = 'none';
    }
});

function getMensajeExplicativo(estado, imc) {
    const mensajes = {
        'Bajo peso': `Un IMC de ${imc} indica que estás por debajo del rango saludable. Podrías necesitar aumentar de peso de forma saludable.`,
        'Peso normal': `¡Felicidades! Tu IMC de ${imc} está dentro del rango saludable. Mantén buenos hábitos.`,
        'Sobrepeso': `Tu IMC de ${imc} está en el rango de sobrepeso. Sería recomendable mejorar la dieta y el ejercicio.`,
        'Obesidad grado I': `Un IMC de ${imc} indica obesidad grado I. Es importante consultar a un profesional.`,
        'Obesidad grado II': `Tu IMC de ${imc} corresponde a obesidad grado II. Te recomendamos buscar apoyo médico.`,
        'Obesidad grado III': `Con un IMC de ${imc} estás en obesidad grado III. Es muy importante consultar a un especialista.`
    };
    return mensajes[estado] || 'Estado no clasificado';
}

function guardarEnHistorial(registro) {
    let historial = JSON.parse(localStorage.getItem('historialIMC')) || [];
    historial.push(registro);
    localStorage.setItem('historialIMC', JSON.stringify(historial));
}

function cargarHistorial() {
    const historial = JSON.parse(localStorage.getItem('historialIMC')) || [];
    historialBody.innerHTML = '';
    historial.forEach(registro => agregarFilaHistorial(registro));
}

function agregarFilaHistorial(reg) {
    const fila = document.createElement('tr');
    
    // Aquí mapeamos el estado a la clase correcta que ya tienes en tu CSS
    let claseColor = reg.clase;
    if(!claseColor) { // Por si acaso no se guardó la clase antes
        if (reg.estado.includes('I')) claseColor = 'obesidad1';
        else if (reg.estado.includes('II')) claseColor = 'obesidad2';
        else if (reg.estado.includes('III')) claseColor = 'obesidad3';
        else claseColor = reg.estado.toLowerCase().replace(' ', '');
    }

    fila.innerHTML = `
        <td>${reg.fecha}</td>
        <td>${reg.nombre}</td>
        <td>${reg.peso} kg</td>
        <td>${reg.altura} m</td>
        <td>${reg.imc}</td>
        <td class="${claseColor}">${reg.estado}</td>
    `;
    historialBody.appendChild(fila);
}