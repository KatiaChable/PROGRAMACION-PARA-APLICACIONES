import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Random;

public class Generador {
    public static void main(String[] args) {
        String[] rangos = {"asistente", "asociado", "titular"};
        Random random = new Random();

        try (PrintWriter writer = new PrintWriter(new File("salarios.txt"))) {
            for (int i = 1; i <= 1000; i++) {
                // Seleccionar rango aleatorio
                int indiceRango = random.nextInt(rangos.length);
                String rango = rangos[indiceRango];
                
                double salario = 0;

                // Generar salario según el rango
                switch (rango) {
                    case "asistente":
                        salario = 50000 + (random.nextDouble() * (80000 - 50000));
                        break;
                    case "asociado":
                        salario = 60000 + (random.nextDouble() * (110000 - 60000));
                        break;
                    case "titular":
                        salario = 75000 + (random.nextDouble() * (130000 - 75000));
                        break;
                }

                // Escribir en el archivo con formato (2 decimales)
                writer.printf("Nombre%d Apellido%d %s %.2f%n", i, i, rango, salario);
            }
            System.out.println("Archivo 'salarios.txt' generado");
            
        } catch (FileNotFoundException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }
}