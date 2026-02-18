public class Ejercicio5 {
    public void metodoExcepcion() throws Ejercicio3 {
        throw new Ejercicio3("¡¡Error!!");
    }
    public static void main(String[] args) throws Exception {
        Ejercicio4 prueba = null;
        try {
            prueba.metodoExcepcion();
        } catch (Ejercicio3 e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}
