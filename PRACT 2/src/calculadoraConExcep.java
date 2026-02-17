import java.util.Scanner;

public class calculadoraConExcep {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Operando 1: ");
        String op1Str = sc.nextLine();

        System.out.print("Operador (+, -, *, /): ");
        String operador = sc.nextLine();

        System.out.print("Operando 2: ");
        String op2Str = sc.nextLine();

        int op1, op2;

        try {
            op1 = Integer.parseInt(op1Str);
        } catch (NumberFormatException e) {
            System.out.println("Entrada incorrecta: " + op1Str + " (operando 1 no es numérico)");
            return;
        }

        try {
            op2 = Integer.parseInt(op2Str);
        } catch (NumberFormatException e) {
            System.out.println("Entrada incorrecta: " + op2Str + " (operando 2 no es numérico)");
            return;
        }

        int result = 0;

        switch (operador.charAt(0)) {
            case '+': result = op1 + op2; break;
            case '-': result = op1 - op2; break;
            case '*': result = op1 * op2; break;
            case '/': result = op1 / op2; break;
            default:
                System.out.println("Operador inválido");
                return;
        }

        System.out.println(op1 + " " + operador + " " + op2 + " = " + result);
        sc.close();
    }
}
