public class Circle extends GeometricObject {
    private double radius;

    public Circle() {
        radius = 1.0;
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    public double getDiameter() {
        return 2 * radius;
    }
    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated() +
                " and the radius is " + radius);
    }

    @Override
    public String toString() {
        return "===== Círculo =====" + 
        "\nRadio = " + radius + 
        "\nArea = " + getArea() + 
        "\nPerímetro = " + getPerimeter() +
        "\nDiámetro = " + getDiameter() +
        "\nColor = " + getColor() +
        "\nRelleno = " + isFilled();
    }
}
