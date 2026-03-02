import java.util.Scanner;

public class TestTriangle {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Ingrese lado 1: ");
            double side1 = input.nextDouble();

            System.out.print("Ingrese lado 2: ");
            double side2 = input.nextDouble();

            System.out.print("Ingrese lado 3: ");
            double side3 = input.nextDouble();

            System.out.print("Ingrese color: ");
            String color = input.next();

            System.out.print("¿Está relleno? (true/false): ");
            boolean filled = input.nextBoolean();

            Triangle triangle = new Triangle(side1, side2, side3);
            triangle.setColor(color);
            triangle.setFilled(filled);

            System.out.println("\n--- Información del Triángulo ---");
            System.out.println(triangle.toString());
            System.out.println("Área: " + triangle.getArea());
            System.out.println("Perímetro: " + triangle.getPerimeter());
            System.out.println("Color: " + triangle.getColor());
            System.out.println("Relleno: " + triangle.isFilled());

        } catch (IllegalTriangleException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error de entrada: " + e.getMessage());
        }

        input.close();
    }
}