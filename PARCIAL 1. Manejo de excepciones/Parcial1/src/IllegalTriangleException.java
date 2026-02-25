public class IllegalTriangleException extends Exception {
    public IllegalTriangleException() {
        super("Los lados no forman un triángulo válido.");
    }
    public IllegalTriangleException(String message) {
        super(message);
    }
}

