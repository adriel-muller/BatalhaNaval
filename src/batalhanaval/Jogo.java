/*

A ideia é construir um pequeno jogo de batalha naval, nele temos o seguinte
tabuleiro de 10x10
1 barco de 4 espaços
2 barcos de 3 espaços
3 barcos de 2 espaços
4 barcos de 1 espaço

O programa deve permitir dois jogadores, primeiramente deve solicitar as posições desejadas para os barcos
Para cada barco:
 - Perguntar se horizontal (barco em uma linha) ou vertical (barco em uma coluna), e a posição inicial do barco linha e coluna.
 - Depois deve validar se o barco cabe naquela posição (até a borda do tabuleiro) e se já não existe um barco ou parte dele nas posições que o novo barco irá ocupar.
 - Se a posição for inválida por algum dos motivos acima, pedir uma nova posição inicial e explicar o motivo
Depois de alocados os barcos para o primeiro jogador repita os processos para o segundo...

Posicionados os barcos inicie a partida, para cada jogada um dos jogadores escolhe uma posição de linha e coluna para atirar. 
Verifique no tabuleiro do adversário o que ele acertou, se água informe "Água" e passe a vez, se foi uma parte de um barco informe que "acertou" e permita mais uma jogada.
A partida termina quando um dos jogadores afundar todos os barcos do oponente. Ele será o vencedor.
Informar qual jogador foi campeão.
Mostrar os mapas dos dois jogadores na tela.

 */
package batalhanaval;

import static batalhanaval.Metodos.limparTela;
import java.util.Scanner;

/*
 * Classe Principal Usada na Batalha Naval!
 * @author Matheus Dias e Adriel Muller
 */
public class Jogo {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        //Variaveis para players     
        char[][] tabuleiroPlayer1 = new char[10][10];
        char[][] tabuleiroPlayer2 = new char[10][10];
        //Variaveis para Menu Principal
        int menu = 0;
        int encerrar = 0;

        //Variáveis para Rodadas
        int sair = 0;
        int mensagem = 0;
        int posicaoX = 0;
        int posicaoY = 0;
        int contagem1 = 0;
        int contagem2 = 0;
        //Quem chegar na contagem 20 primeiro, vence

        //Menu
        do {
            System.out.println("  -- BATALHA NAVAL --  \n");
            System.out.println(" 1 --> Começar Partida\n");
            System.out.println(" 2 --> Instruções\n");
            System.out.println(" 3 --> Sair\n");

            menu = ler.nextInt();

            switch (menu) {

                case 1:
                    Metodos.limparTela();
                    System.out.println(" -- Começando Partida --\n");

                    System.out.println(" -- PREPARAÇÃO DO CAMPO DO PLAYER 1 --\n");
                    
                    //Gera as Tabelas preenchidas com Água (x)
                    tabuleiroPlayer1 = Metodos.gerarTabela(tabuleiroPlayer1);
                    tabuleiroPlayer2 = Metodos.gerarTabela(tabuleiroPlayer2);

                    //Chama a inserção de Barcos e Printa a tela a cada inserção
                    Metodos.inserirBarco(tabuleiroPlayer1, 4);
                    Metodos.printarTela(tabuleiroPlayer1);

                    Metodos.inserirBarco(tabuleiroPlayer1, 3);
                    Metodos.printarTela(tabuleiroPlayer1);
                    Metodos.inserirBarco(tabuleiroPlayer1, 3);
                    Metodos.printarTela(tabuleiroPlayer1);

                    Metodos.inserirBarco(tabuleiroPlayer1, 2);
                    Metodos.printarTela(tabuleiroPlayer1);
                    Metodos.inserirBarco(tabuleiroPlayer1, 2);
                    Metodos.printarTela(tabuleiroPlayer1);
                    Metodos.inserirBarco(tabuleiroPlayer1, 2);
                    Metodos.printarTela(tabuleiroPlayer1);

                    Metodos.inserirBarco(tabuleiroPlayer1, 1);
                    Metodos.printarTela(tabuleiroPlayer1);
                    Metodos.inserirBarco(tabuleiroPlayer1, 1);
                    Metodos.printarTela(tabuleiroPlayer1);
                    Metodos.inserirBarco(tabuleiroPlayer1, 1);
                    Metodos.printarTela(tabuleiroPlayer1);
                    Metodos.inserirBarco(tabuleiroPlayer1, 1);
                    Metodos.printarTela(tabuleiroPlayer1);

                    Metodos.limparTela();

                    System.out.println(" -- PREPARAÇÃO DO CAMPO DO PLAYER 2 --\n");

                    //Chama a inserção de Barcos e Printa a tela a cada inserção
                    Metodos.inserirBarco(tabuleiroPlayer2, 4);
                    Metodos.printarTela(tabuleiroPlayer2);

                    Metodos.inserirBarco(tabuleiroPlayer2, 3);
                    Metodos.printarTela(tabuleiroPlayer2);
                    Metodos.inserirBarco(tabuleiroPlayer2, 3);
                    Metodos.printarTela(tabuleiroPlayer2);

                    Metodos.inserirBarco(tabuleiroPlayer2, 2);
                    Metodos.printarTela(tabuleiroPlayer2);
                    Metodos.inserirBarco(tabuleiroPlayer2, 2);
                    Metodos.printarTela(tabuleiroPlayer2);
                    Metodos.inserirBarco(tabuleiroPlayer2, 2);
                    Metodos.printarTela(tabuleiroPlayer2);

                    Metodos.inserirBarco(tabuleiroPlayer2, 1);
                    Metodos.printarTela(tabuleiroPlayer2);
                    Metodos.inserirBarco(tabuleiroPlayer2, 1);
                    Metodos.printarTela(tabuleiroPlayer2);
                    Metodos.inserirBarco(tabuleiroPlayer2, 1);
                    Metodos.printarTela(tabuleiroPlayer2);
                    Metodos.inserirBarco(tabuleiroPlayer2, 1);
                    Metodos.printarTela(tabuleiroPlayer2);

                    System.out.println(" --- A PARTIDA VAI COMEÇAR --- ");
                    Metodos.esperarEnter();

                    do {

                        do {

                            if (mensagem == 0) {
                                System.out.println(" Rodada do Jogador 1! ");
                            } else if (mensagem == 1) {
                                System.out.println("Jogador 1 acertou e joga novamente! ");
                            } else if (mensagem == 2) {
                                System.out.println("Jogador 1  joga novamente pois usou o mesmo alvo! ");
                            }

                            System.out.print(" Qual linha você deseja atirar (1 a 10)? ");
                            posicaoX = ler.nextInt();
                            posicaoX--;
                            System.out.print(" Qual coluna você deseja atirar? ");
                            posicaoY = ler.nextInt();
                            posicaoY--;

                            sair = 0;
                            mensagem = 0;

                            if (tabuleiroPlayer2[posicaoY][posicaoX] == 'x') {
                                System.out.println(" --> Tiro na água! ");
                                sair = 1;
                                tabuleiroPlayer2[posicaoY][posicaoX] = 'o';
                            } else if (tabuleiroPlayer2[posicaoY][posicaoX] == 'B') {
                                System.out.println(" --> Na mosca! Acertou um navio!");
                                tabuleiroPlayer2[posicaoY][posicaoX] = 'F';
                                
                                //Conta pontuação para o Jogador
                                contagem1++;
                                
                                //Altera a mensagem printada no inicio da rodada
                                mensagem = 1;
                            } else if (tabuleiroPlayer2[posicaoY][posicaoX] == 'F' || tabuleiroPlayer2[posicaoY][posicaoX] == 'o') {
                                System.out.println(" --> Parece que você já atirou aí, tente novamente. ");
                                mensagem = 2;
                            } else {
                                System.out.println(" ERRO NO JOGO! ");
                            }

                        } while (sair == 0);

                        limparTela();

                        do {

                            if (mensagem == 0) {
                                System.out.println(" Rodada do Jogador 2! ");
                            } else if (mensagem == 1) {
                                System.out.print("Jogador 2 acertou e joga novamente! ");
                            } else if (mensagem == 2) {
                                System.out.println("Jogador 2  joga novamente pois usou o mesmo alvo! ");
                            }

                            System.out.print(" Qual linha você deseja atirar (1 a 10)? ");
                            posicaoX = ler.nextInt();
                            posicaoX--;
                            System.out.println(" Qual coluna você deseja atirar? ");
                            posicaoY = ler.nextInt();
                            posicaoY--;

                            sair = 0;
                            mensagem = 0;

                            if (tabuleiroPlayer1[posicaoY][posicaoX] == 'x') {
                                System.out.println(" --> Tiro na água! ");
                                sair = 1;
                                tabuleiroPlayer1[posicaoY][posicaoX] = 'o';
                            } else if (tabuleiroPlayer1[posicaoY][posicaoX] == 'B') {
                                System.out.println(" --> Na mosca! Acertou um navio!");
                                tabuleiroPlayer1[posicaoY][posicaoX] = 'F';
                                
                                //Conta pontuação para o Jogador
                                contagem2++;
                                
                                //Altera a mensagem printada no inicio da rodada
                                mensagem = 1;
                            } else if (tabuleiroPlayer1[posicaoY][posicaoX] == 'F' || tabuleiroPlayer1[posicaoY][posicaoX] == 'o') {
                                System.out.println(" --> Parece que você já atirou aí, tente novamente. ");
                                mensagem = 2;
                            } else {
                                System.out.println(" ERRO NO JOGO! ");
                            }

                            if (contagem1 < 20 && contagem2 < 20){
                                sair = 2;
                            }
                            
                        } while (sair == 0);

                    } while (contagem1 < 20 && contagem2 < 20);

                    if (contagem1 == 20) {
                        System.out.println("---------------------");
                        System.out.println("  JOGAR 1 VENCEU!");
                        System.out.println("---------------------");
                    }
                    if (contagem2 == 20) {
                        System.out.println("---------------------");
                        System.out.println("  JOGAR 2 VENCEU!");
                        System.out.println("---------------------");
                    }
                    
                    System.out.println(" ---x  TABELA DO JOGADOR 1 x--- ");
                    Metodos.printarTela(tabuleiroPlayer1);
                    
                    
                    System.out.println(" ---x  TABELA DO JOGADOR 2 x--- ");
                    Metodos.printarTela(tabuleiroPlayer2);
                    
                    
                    System.out.println(" -- FIM DA PARTIDA! OBRIGADO POR TER JOGADO! --");
                    
                    break;


                case 2:
                    Metodos.limparTela();
                    System.out.println(" -- INSTRUÇÕES -- \n");
                    System.out.println(" A partida começará após ambos os jogadores \n"
                            + "colocarem em posições seus barcos, então a \n"
                            + "cada rodada o jogador tentará afundar o barco \n"
                            + "adversário, em caso de acerto o mesmo poderá jogar \n"
                            + "novamente. A partida termina assim que todos os barcos\n"
                            + "de um dos jogadores tiver sido afundados (Pontuação de 20).\n");
                    System.out.println(" -- SIMBOLOS -- ");
                    System.out.println(" x ---> Água ");
                    System.out.println(" B ---> Barco ");
                    System.out.println(" F ---> Barco já acertado");
                    System.out.println(" o ---> Tiro na água \n");

                    Metodos.esperarEnter();

                    break;
                case 3:
                    Metodos.limparTela();
                    encerrar = 1;
                    System.out.println(" Volte Sempre! :D \n");
                    break;
                default:
                    Metodos.limparTela();
                    System.out.println(" Opção Inválida, favor repita! \n");
                    Metodos.esperarEnter();

            }

        } while (encerrar
                != 1);

    }

}
