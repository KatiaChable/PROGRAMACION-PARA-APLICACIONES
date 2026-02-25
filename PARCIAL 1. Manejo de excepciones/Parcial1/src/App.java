import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("====== P R O G R A M A  D E  P R U E B A ======");
        System.out.println("Introduce los valores de los 3 lados del triángulo: ");
        System.out.println("Lado 1: ");
        int side1 = scanner.nextInt();
        System.out.println("Lado 2: ");
        int side2 = scanner.nextInt();
        System.out.println("Lado 3: ");
        int side3 = scanner.nextInt();
        
        System.out.println("Introduce el color del triángulo: ");
        String color = scanner.next();

        System.out.println("Relleno (true/false): ");
        boolean filled = scanner.nextBoolean();

        try {
            Triangle triangle = new Triangle(side1, side2, side3);
            triangle.setColor(color);
            triangle.setFilled(filled);
            System.out.println(triangle.toString());
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado :3.");
        }

        scanner.close();
    }

}
