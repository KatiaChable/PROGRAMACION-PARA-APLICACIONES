public class Ejercicio6 {
    
    public void a() throws Ejercicio3 {
        throw new Ejercicio3("Error desde método a()");
    }
    
    public void b() throws Exception { 
        try {
            a();
        } catch (Ejercicio3 e) {
            System.out.println("catch en b(): " + e.getMessage());
            throw new Exception("Nueva excepción lanzada desde b()", e);
        }
    }
    
    public static void main(String[] args) {
        Ejercicio6 prueba = new Ejercicio6();   
        
        try {
            prueba.b();
        } catch (Exception e) {
            System.out.println("Excepción final en main: " + e.getMessage());
            e.printStackTrace(); 
        }
    }
}