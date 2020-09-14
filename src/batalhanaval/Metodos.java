/*
 * Métodos Usados na Batalha Naval
 */
package batalhanaval;

import java.util.Scanner;


/*
 * Métodos Usados na Batalha Naval
 * @author Matheus Dias e Adriel Muller
 */
public class Metodos {

    public static char[][] gerarTabela(char vetor[][]) {
        //Preenche Tabuleiro 10 x 10 
        int i, j = 0;
        for (i = 0; i < vetor.length; i++) {
            for (j = 0; j < vetor.length; j++) {
                vetor[i][j] = 'x';
            }
        }

        return vetor;
    }

    public static void printarTela(char vetor[][]) {

        //Printa Tabuleiro 10 x 10 dos Barcos 
        int i, j = 0;
        int numero = 1;
        int numeroDiagonal = 0;
        System.out.printf(" ");
        for (i = 0; i < 11; i++) {
            System.out.printf("%02d ", numeroDiagonal++);
        }
        for (i = 0; i < vetor.length; i++) {
            System.out.printf(" \n ");
            System.out.printf("%02d  ", numero++);
            for (j = 0; j < vetor.length; j++) {
                System.out.printf(vetor[i][j] + "  ");
            }
        }

        System.out.println(" \n ");
        esperarEnter();

    }

    public static void inserirBarco(char vetor[][], int tamanhoBarco) {
        Scanner ler = new Scanner(System.in);
        int sair = 1;
        int sairPosicao = 0;

        int posicaoX = 0;
        int posicaoY = 0;

        do {
            sair = 1;
            System.out.println("Em que sentido você deseja colocar o barco de " + tamanhoBarco + " espaço(s)? \n");
            System.out.println("Horizontal ---> 1");
            System.out.println("Vertical ---> 2");
            int sentido = ler.nextInt();
            
                // CASO HORIZONTAL
            if (sentido == 1) {
                do {
                    System.out.println("\nQual a posição inicial do Barco?");
                    System.out.print("Horizontal (1 a 10): ");
                    posicaoX = ler.nextInt();
                    posicaoX--;

                    if (posicaoX > 10) {
                        System.out.println("Posição Inexistente! Favor Repita!");
                    } else if (posicaoX + tamanhoBarco > 10) {
                        System.out.println("O Barco não cabe aqui! Favor Repita!");
                    } else {
                        sairPosicao = 1;
                    }

                } while (sairPosicao == 0);

                sairPosicao = 0;

                do {
                    System.out.print("Vertical (1 a 10): ");
                    posicaoY = ler.nextInt();
                    posicaoY--;

                    if (posicaoY > 10) {
                        System.out.println("Posição Inexistente! Favor Repita!");
                    } else {
                        sairPosicao = 1;
                    }

                } while (sairPosicao == 0);

                //Confere se não está ocupado por outro Barco
                for (int i = 0; i < tamanhoBarco; i++) {

                    if (vetor[posicaoY][posicaoX + i] == 'B') {
                        sair = 0;
                    }
                }
                //Insere o Barco
                if (sair == 1) {
                    for (int i = 0; i < tamanhoBarco; i++) {

                        vetor[posicaoY][posicaoX + i] = 'B';
                    }
                } else {
                    //Avisa que a posição está ocupada por outro barco e repete.
                    System.out.println("OPS! Posição já ocupada por um Barco, favor Repita!");
                }

                //SENTIDO VERTICAL
            } else if (sentido == 2) {

                do {
                    System.out.println("\nQual a posição inicial do Barco?");
                    System.out.print("Horizontal (1 a 10): ");
                    posicaoX = ler.nextInt();
                    posicaoX--;

                    if (posicaoX > 10) {
                        System.out.println("Posição Inexistente! Favor Repita!");
                    } else {
                        sairPosicao = 1;
                    }

                } while (sairPosicao == 0);

                sairPosicao = 0;

                do {
                    System.out.print("Vertical (1 a 10): ");
                    posicaoY = ler.nextInt();
                    posicaoY--;

                    if (posicaoY > 10) {
                        System.out.println("Posição Inexistente! Favor Repita!");

                    } else if (posicaoY + tamanhoBarco > 10) {
                        System.out.println("O Barco não cabe aqui! Favor Repita!");
                    } else {
                        sairPosicao = 1;
                    }

                } while (sairPosicao == 0);

                //Confere se não está ocupado por outro Barco
                for (int i = 0; i < tamanhoBarco; i++) {

                    if (vetor[posicaoY + i][posicaoX] == 'B') {
                        sair = 0;
                    }
                }
                //Insere o Barco
                if (sair == 1) {
                    for (int i = 0; i < tamanhoBarco; i++) {

                        vetor[posicaoY + i][posicaoX] = 'B';
                    }
                } else {
                    //Avisa que a posição está ocupada por outro barco e repete.
                    System.out.println("OPS! Posição já ocupada por um Barco, favor Repita!");
                }

            } else {
                //SENTIDO DIFERENTE DE 1 ou 2
                System.out.println("Sentido Inválido! Favor Repita! \n");
            }

        } while (sair == 0);

        limparTela();

    }

    public static void limparTela() {
            //Limpa a Tela
        System.out.println("\n\n\n");
    }

    public static void esperarEnter() {
        //Espera confirmação do usuario e chama o metodo limpar tela 
        Scanner ler = new Scanner(System.in);
        System.out.println("Pressione qualquer tecla para sair: ");
        ler.nextLine();
        limparTela();
    }

}
