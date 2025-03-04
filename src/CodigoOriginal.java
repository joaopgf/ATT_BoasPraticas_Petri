import java.util.Arrays;
import java.util.Scanner;

public class CodigoOriginal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tamanho1 = 0, tamanho2 =0, tamanho3 = 0, tamanho4 = 0, val = - 1, dif = 0, ind1 = 0, ind2 = 0;
        int [] convazio = new int [0];// conjunto vazio que vai ser usado como referência de conjunto nulo
        //val será um índice anterior a ser usado para verificar o índice atual
        //dif marca quantos números diferentes existem entre os conjuntos
        //tamanho1 = tamanho do conjunto1 e assim respectivamente
        System.out.println("Digite o tamanho do primeiro conjunto: ");
        tamanho1 = scanner.nextInt();
        if (tamanho1 <= 0) {
            while (tamanho1 <= 0){ // garantir que o usuário digite um valor inteiro, positivo e maior que zero
                System.out.println("O tamanho do conjunto deve ser inteiro e maior que zero !");
                System.out.println("Tente de novo: ");
                tamanho1 = scanner.nextInt();
            }
        }
        int [] con1 = new int [tamanho1]; // (con1 = conjunto 1) tamanho do conjunto 1 definido
        System.out.println("Agora digite os valores do conjunto 1: ");
        for (int i = 0; i < tamanho1; i++) {
            System.out.println("Digite o " + (i + 1) + "º valor: ");
            con1[i] = scanner.nextInt(); // usuário define os valores do conjunto 1
            val ++;
            if (i >= 1){ // a partir do 2º elemento esse loop irá começar para comparar o novo valor com todos os anteriores
                for (int j = 0; j < val; j++) {// val precisa começar com -1 para ser 0 quando o i for 1
                    if (con1[i] == con1[j]) {// o loop passa por todos os valores digitados até o momento e compara eles
                        while (con1[i] == con1[j]) {// garantir que não tenha elementos iguais
                            System.out.println("O conjunto não pode ter valores iguais !");
                            System.out.println("Tente de novo: ");
                            con1[i] = scanner.nextInt();
                        }
                    }
                }
            }

        }

        val = -1; // restaurar o valor original para poder reusar
        System.out.println("Agora digite o tamanho do segundo conjunto");
        tamanho2 = scanner.nextInt();
        if (tamanho2 <= 0) {
            while (tamanho2 <= 0){ // garantir que o usuário digite um valor inteiro, positivo e maior que zero
                System.out.println("O tamanho do conjunto deve ser inteiro e maior que zero !");
                System.out.println("Tente de novo: ");
                tamanho2 = scanner.nextInt();
            }
        }
        int [] con2 = new int [tamanho2]; // (con2 = conjunto 2) tamanho do conjunto 2 definido
        System.out.println("Agora digite os valores do conjunto 2: ");
        for (int i = 0; i < tamanho2; i++) {
            System.out.println("Digite o " + (i + 1) + "º valor: ");
            con2[i] = scanner.nextInt(); // usuário define os valores do conjunto 2
            val ++;
            if(i >= 1){
                for (int j = 0; j < val; j++) {
                    if(con2[i] == con2[j]) {
                        while (con2[i] == con2[j]) {
                            System.out.println("O conjunto não pode ter valores iguais !");
                            System.out.println("Tente de novo: ");
                            con2[i] = scanner.nextInt();
                        }
                    }
                }
            }
        }
        System.out.println("Os conjuntos digitados foram: ");
        System.out.print("Conjunto 1: [");
        for (int i = 0; i < tamanho1; i++) {
            if (i == tamanho1 - 1){
                System.out.println(con1[i] + "]");
                break;
            }
            System.out.print(con1[i] + ", ");
        }
        System.out.print("Conjunto 2: [");
        for (int i = 0; i < tamanho2; i++) {
            if (i == tamanho2 - 1){
                System.out.println(con2[i] + "]");
                break;
            }
            System.out.print(con2[i] + ", ");
        }
        for (int i = 0; i <tamanho1 ; i++) {// ver se os conjuntos possuem números iguais
            for (int j = 0; j < tamanho2; j++) {
                if (con1[i] == con2[j]) {
                    dif++;
                }
            }
        }
        //con3 = conjunto de união, con4 = conjunto de intersecção

        tamanho3 = (tamanho1 + tamanho2) - dif;
        ind2 = tamanho1;
        int [] con3 = new int [tamanho3];// conjunto da união criado
        for (int i = 0; i < tamanho1; i++) {
            con3[i] = con1[i];
        }
        for (int i = 0; i < tamanho3; i++) {
            if(ind2 == tamanho3){//garantir que o con3 não exceda
                break;
            }
            for (int j = 0; j < tamanho2; j++) {
                if (con3[i] != con2[j]) {//compara todos os elementos do con2 com o con3, se houver elementos diferentes o com3 ganha eles
                    con3[ind2] = con2[i];
                    ind2++;
                    break;
                }
            }
        }

        tamanho4 = dif;//tamanho do conjunto de intersecção
        int [] con4 = new int [tamanho4];//con4 criado
        for (int i = 0; i < tamanho1; i++) {
            if (ind1 == tamanho4){ //garantir que o con4 não excede o seu tamanho
                break;
            }
            for (int j = 0; j < tamanho2; j++) {//verificar cada elemento dos 2 con
                if (con1[i] == con2[j]) {
                    con4[ind1] = con2[j];
                    ind1++;
                }
            }
        }

        System.out.print("A união desses conjuntos foi: [");
        for (int i = 0; i < tamanho3; i++) {
            if (i == tamanho3 - 1){
                System.out.println(con3[i] + "]");
                break;
            }
            System.out.print(con3[i] + ", ");
        }

        if (!Arrays.equals(con4, convazio)){// verificar se o con4 não está vazio
            System.out.print("A intersecção desses dois conjuntos foi: [");
            for (int i = 0; i < tamanho4; i++) {
                if (i == tamanho4 - 1){
                    System.out.println(con4[i] + "]");
                    break;
                }
                System.out.print(con4[i] + ", ");
            }
        }else{
            System.out.println("Não houve intersecção entre os conjuntos !");
        }

    }
}
