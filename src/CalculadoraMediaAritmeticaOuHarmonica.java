import java.util.Scanner;

public class CalculadoraMediaAritmeticaOuHarmonica {

    private static int getInteger() {

        Scanner sc = new Scanner(System.in);

        try {
            String input = sc.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("O valor precisa ser um número inteiro positivo!");
            return getInteger();
        } catch (Exception e) {
            System.out.println("Valor inválido.");
            return getInteger();
        }

    }

    private static double getDouble() {

        Scanner sc = new Scanner(System.in);

        try {
            String input = sc.nextLine();
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("O valor precisa ser um número inteiro ou decimal (exemplo: 56.8)");
            return getDouble();
        } catch (Exception e) {
            System.out.println("Valor inválido.");
            return getDouble();
        }

    }

    private static String getTipoDeMedia() {

        Scanner sc = new Scanner(System.in);

        String tipoDeMedia =  sc.nextLine();
        if (tipoDeMedia.equalsIgnoreCase("aritmetica")) {
            return tipoDeMedia;
        } if (tipoDeMedia.equalsIgnoreCase("harmonica")) {
            return tipoDeMedia;
        } else {
            System.out.println("O valor digitado não é o esperado (aritmetica ou harmonica). Tente novamente.");
            return getTipoDeMedia();
        }
    }

    private static void exibirLista (double[] lista) {
        for ( double numero : lista ) {
            System.out.print(numero + ", ");
        }
        System.out.println("");
    }

    private static double calcularMediaAritmetica (double[] lista) {
        double mediaAritmetica;
        double soma = 0;
        for (int i = 0; i < lista.length; i++) {
            soma += lista[i];
        }
        mediaAritmetica = soma / lista.length;
        return mediaAritmetica;
    }

    private static double calcularMediaHarmonica (double[] lista) {
        double mediaHarmonica;
        double soma = 0;
        for (int i = 0; i < lista.length; i++) {
            lista[i] =  1.0 / lista[i];
            soma += lista[i];
        }
        while (soma == 0) {
            System.out.println("A soma dos inversos dos números providos é igual a zero, de modo que não é possível fazer a média harmônica");
            System.out.println("Tente novamente com outros números");
            //return main(args); não tô conseguindo fazer isso...
        }
        mediaHarmonica = lista.length / soma;
        return mediaHarmonica;
    }



    public static void main(String[] args) {

        System.out.println("Você quer calcular a média de quantos números?");
        int quantidadeDeNumeros = getInteger();
        if (quantidadeDeNumeros <= 0) {
            System.out.println("A quantidade de valores precisa ser um número inteiro positivo! Tente novamente: ");
            quantidadeDeNumeros = getInteger();
        }

        double[] lista = new double[quantidadeDeNumeros];
        for (int i = 0; i < lista.length; i++) {
            System.out.println("Digite o " + (i + 1) + "° número para o cálculo da média:");
            lista[i] = getDouble();
        }

        System.out.println("Você quer calcular média harmônica ou aritmética? (Digite 'ARITMETICA' OU 'HARMONICA')");
        String tipoDeMedia = getTipoDeMedia();

        if (tipoDeMedia.equalsIgnoreCase("aritmetica")) {
            System.out.println("Números digitados: ");
            exibirLista(lista);
            System.out.println("Média escolhida: aritmética");
            System.out.println("A média aritmética é " + calcularMediaAritmetica(lista));
        } else if (tipoDeMedia.equalsIgnoreCase("harmonica")) {
            System.out.println("Números digitados: ");
            exibirLista(lista);
            System.out.println("Média escolhida: harmônica");
            System.out.println("A média harmonica é " + calcularMediaHarmonica(lista));
        } else {
            System.out.println("Ops.. Algo estranho aconteceu :/ ");
        }
    }
}
