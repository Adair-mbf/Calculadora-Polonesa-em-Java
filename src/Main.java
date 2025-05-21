import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o tipo de notação:\n1 - Infixa\n2 - Pós-fixada\n3 - Pré-fixada");
        byte opcao = scanner.nextByte();
        scanner.nextLine();
        System.out.print("Digite a expressão: ");
        String expressao = scanner.nextLine();
        switch (opcao) {
            case 1:
                Infixa.calcular(expressao);
                break;
            case 2:
                Posfixa.calcular(expressao);
                break;
            case 3:
                Prefixa.calcular(expressao);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        scanner.close();
    }
}
