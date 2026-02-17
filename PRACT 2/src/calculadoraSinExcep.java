import java.util.Scanner;

public class calculadoraSinExcep {

    public static boolean esEntero(String s) {
        if (s == null || s.isEmpty()) return false;

        int i = 0;
        if (s.charAt(0) == '-') {
            if (s.length() == 1) return false;
            i = 1;
        }

        for (; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Operando 1: ");
        String op1Str = sc.nextLine();

        System.out.print("Operador (+, -, *, /): ");
        String operador = sc.nextLine();

        System.out.print("Operando 2: ");
        String op2Str = sc.nextLine();

        int op1, op2;

        if (!esEntero(op1Str)) {
            System.out.println("Entrada incorrecta: " + op1Str + " (operando 1 no es numérico)");
            sc.close();
            return;
        }

        if (!esEntero(op2Str)) {
            System.out.println("Entrada incorrecta: " + op2Str + " (operando 2 no es numérico)");
            sc.close();
            return;
        }

        op1 = Integer.parseInt(op1Str);
        op2 = Integer.parseInt(op2Str);

        int result = 0;

        switch (operador.charAt(0)) {
            case '+': result = op1 + op2; break;
            case '-': result = op1 - op2; break;
            case '*': result = op1 * op2; break;
            case '/': result = op1 / op2; break;
            default:
                System.out.println("Operador inválido");
                sc.close();
                return;
        }

        System.out.println(op1 + " " + operador + " " + op2 + " = " + result);
        sc.close();
    }
}
