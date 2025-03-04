import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NovoCodigo {
    public static int VerificarTamanho(int tamanho){ //Método que verifica se o tamanho digitado pelo usuário é válido
        Scanner scanner = new Scanner(System.in);
        tamanho = scanner.nextInt();
        if (tamanho <= 0) {
            while (tamanho <= 0){ // garantir que o usuário digite um valor inteiro, positivo e maior que zero
                System.out.println("O tamanho do conjunto deve ser inteiro e maior que zero !");
                System.out.println("Tente de novo: ");
                tamanho = scanner.nextInt();
            }
        }
        return tamanho;
    }

    public static int [] PreencherConjunto(int [] conjunto){ //método para preencher o conjunto
        int val = -1; //val será um índice anterior a ser usado para verificar o índice atual
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < conjunto.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º valor: ");
            conjunto[i] = scanner.nextInt(); // usuário define os valores do conjunto 1
            val ++;
            if (i >= 1 && !VerificarValores(val, conjunto, conjunto[i])){ // a partir do 2º elemento esse loop irá começar para comparar o novo valor com todos os anteriores
                while (!VerificarValores(val, conjunto, conjunto[i])){
                    System.out.println("O conjunto não pode ter valores iguais !");
                    System.out.println("Tente de novo: ");
                    conjunto[i] = scanner.nextInt();
                }
            }
        }
        return conjunto;
    }

    public static boolean VerificarValores(int indice, int [] conjunto, int valor){ //Método que verifica se o conjunto possuí valores iguais
        for (int i = 0; i < indice; i++) {
            if (conjunto[i] == valor) {
                while (conjunto[i] == valor) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void MostrarConjunto(int [] conjunto){
        for (int i = 0; i < conjunto.length; i++) {
            System.out.print(conjunto[i] + (i == conjunto.length - 1 ? "]\n" : ", "));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tamanho1 = 0, tamanho2 = 0, dif = 0;
        int [] convazio = new int [0];// conjunto vazio que vai ser usado como referência de conjunto nulo
        //dif marca quantos números diferentes existem entre os conjuntos
        //tamanho1 = tamanho do conjunto1 e assim respectivamente
        System.out.println("Digite o tamanho do primeiro conjunto: ");

        tamanho1 = VerificarTamanho(tamanho1);

        int [] con1 = new int [tamanho1]; // (con1 = conjunto 1) tamanho do conjunto 1 definido

        System.out.println("Agora digite os valores do conjunto 1: ");

        PreencherConjunto(con1);

        System.out.println("Agora digite o tamanho do segundo conjunto");
        tamanho2 = VerificarTamanho(tamanho2);

        int [] con2 = new int [tamanho2]; // (con2 = conjunto 2) tamanho do conjunto 2 definido
        System.out.println("Agora digite os valores do conjunto 2: ");

        PreencherConjunto(con2);

        System.out.println("Os conjuntos digitados foram: ");
        System.out.print("Conjunto 1: [");
        MostrarConjunto(con1);

        System.out.print("Conjunto 2: [");
        MostrarConjunto(con2);

        for (int i = 0; i <tamanho1 ; i++) {// ver se os conjuntos possuem números iguais
            for (int j = 0; j < tamanho2; j++) {
                if (con1[i] == con2[j]) {
                    dif++;
                }
            }
        }

        //con3 = conjunto de união, con4 = conjunto de intersecção

        Set<Integer> uniao = new HashSet<>();
        for (int num : con1) {
            uniao.add(num);
        }
        for (int num : con2) {
            uniao.add(num);
        }
        // Criar o array final da união
        Integer[] con3 = uniao.toArray(new Integer[0]);


        //tamanho do conjunto de intersecção é dif
        int [] con4 = new int [dif];//con4 criado
        for (int i = 0; i < tamanho1; i++) {
            for (int j = 0; j < tamanho2; j++) {//verificar cada elemento dos 2 con
                if (con1[i] == con2[j]) {
                    con4[i] = con2[j];
                }
            }
        }

        System.out.print("A união desses conjuntos foi: [");
        for (int i = 0; i < con3.length; i++) {
            System.out.print(con3[i] + (i == con3.length - 1 ? "]\n" : ", "));
        }

        if (!Arrays.equals(con4, convazio)){// verificar se o con4 não está vazio
            System.out.print("A intersecção desses dois conjuntos foi: [");
            MostrarConjunto(con4);
        }else{
            System.out.println("Não houve intersecção entre os conjuntos !");
        }
    }
}
