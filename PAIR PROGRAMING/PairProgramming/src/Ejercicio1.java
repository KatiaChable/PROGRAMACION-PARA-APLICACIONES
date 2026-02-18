public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            throw new Exception("Error de prueba!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
