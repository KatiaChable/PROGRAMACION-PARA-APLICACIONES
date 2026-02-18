public class Ejercicio2 {
    public static void main(String[] args) throws Exception {
        try {
            throw new Exception("Error de prueba!");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            System.out.println("Programa finalizado.");
        }
    }
}
