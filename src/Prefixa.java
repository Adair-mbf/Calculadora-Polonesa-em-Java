import java.util.Stack;

public class Prefixa {

    public static void calcular(String expressao) {
        Stack<Double> pilha = new Stack();
        String[] vetor = expressao.split(" ");
        for(int i = vetor.length - 1; i >= 0; --i) {
            String digito = vetor[i];
            if (verificadorNumero(digito)) {
                pilha.push(Double.parseDouble(digito));
            }
            else {
                if (pilha.size() < 2) {
                    System.out.println("Erro: expressão inválida.");
                    return;
                }

                double a = pilha.pop();
                double b = pilha.pop();
                double resultado = operar(a, b, digito);
                pilha.push(resultado);
            }
        }
        if (pilha.size() == 1) {
            System.out.println("Resultado: " + pilha.pop());
        } else {
            System.out.println("Erro: expressão incompleta.");
        }

    }
    public static boolean verificadorNumero(String s) {
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c < '0' && c > '9') && c != '.') {
                return false;
            }
        }
        return true;
    }
    public static double operar(double a, double b, String op) {
        if (op.equals("+")) {
            return a + b;
        }
        if (op.equals("-")) {
            return a - b;
        }
        if (op.equals("*")) {
            return a * b;
        }
        if (op.equals("/")) {
            if (b == 0) {
                System.out.println("Erro: divisão por zero.");
                return 0;
            }
            return a / b;
        }
        System.out.println("Operador inválido.");
        return 0;
    }
}