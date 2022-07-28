import java.io.IOException; // 
import java.util.Scanner;

public class projetofinal {
    // ATRIBUIÇÃO DE COR
    enum Color {
        RESET("\033[0m"), // A cor das letras do terminal volta a ser branca
        GREEN("\033[0;32m"), // A cor das letras do terminal ficam verdes
        RED("\033[0;31m"), // A cor das letras do terminal ficam vermelhas
        YELLOW("\033[0;33m"); // A cor das letras do terminal fica amarelas

        private final String code;

        Color(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code;
        }
    }

    // FUNÇÃO PARA IMPRIMIR POLTRONAS
    public static void numeropoltrona(int poltronas1[][], int poltronas2[][]) {
        int poltrona = 1;

        // Método para guardar o número da poltrona dentro da matriz.
        for (int c = 0; c < 12; c++) {
            for (int l = 0; l < 4; l++) {
                poltronas1[l][c] = poltrona; // Matriz para poltronas da primeira linha de ônibus
                poltronas2[l][c] = poltrona; // Matriz para poltronas da segunda linha se ônibus
                poltrona++;
            }
        }
    }

    // FUNÇÃO PARA IMPRIMIR O MENU DE ESCOLHA DA POLTRONA DA PRIMEIRA LINHA DE
    // ÔNIBUS
    public static void poltronas1(int poltronas1[][], int ocupado1[]) {
        System.out.println("__________________________________________________________________________");
        System.out.println("|                           ESCOLHA A POLTRONA                           |");
        System.out.println("|________________________________________________________________________|");
        System.out.println();
        System.out.println("|------------------------------------------------------------------------|");
        // Comando para imprimir as poltronas na tela
        for (int l = 0; l < 4; l++) {
            if (l == 2)
                System.out.println("|                                                                        |");
            System.out.print("|");
            for (int c = 0; c < 12; c++) {
                int x = 0;

                // Comando codicional para poltronas ocupadas
                if (ocupado1[poltronas1[l][c]] == poltronas1[l][c]) {
                    System.out.print(Color.RED); // A cor das letras impressas no terminal ficam vermelhas
                    System.out.printf(" [%02d] ", poltronas1[l][c]); // O número da poltrona ocupada fica vermelha
                    System.out.print(Color.RESET); // As cores das letras impressas no terminal ficam brancas
                }

                // Comando condicional para poltronas desocupadas
                if (x == 0 && ocupado1[poltronas1[l][c]] != poltronas1[l][c]) {
                    System.out.printf(" [%02d] ", poltronas1[l][c]);
                    x = 1;
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("|------------------------------------------------------------------------|");
        System.out.print(Color.RED);
        System.out.println("[xx] = POLTRONA INDISPONÍVEL");
        System.out.print(Color.RESET);
        System.out.println("[xx] = POLTRONA DISPONÍVEL");
    }

    // FUNÇÃO PARA IMPRIMIR O MENU DE ESCOLHA DA POLTRONA DA SEGUNDA LINHA DE ÔNIBUS
    public static void poltronas2(int poltronas2[][], int ocupado2[]) {
        System.out.println("__________________________________________________________________________");
        System.out.println("|                           ESCOLHA A POLTRONA                           |");
        System.out.println("|________________________________________________________________________|");
        System.out.println();
        System.out.println("|------------------------------------------------------------------------|");

        // Comando para imprimir as poltronas na tela
        for (int l = 0; l < 4; l++) {
            if (l == 2)
                System.out.println("|                                                                        |");
            System.out.print("|");
            for (int c = 0; c < 12; c++) {
                int x = 0;

                // Comando codicional para poltronas ocupadas
                if (ocupado2[poltronas2[l][c]] == poltronas2[l][c]) {
                    System.out.print(Color.RED);
                    System.out.printf(" [%02d] ", poltronas2[l][c]);
                    System.out.print(Color.RESET);
                    x = 1;
                }

                // Comando condicional para poltronas desocupadas
                if (x == 0 && ocupado2[poltronas2[l][c]] != poltronas2[l][c]) {
                    System.out.printf(" [%02d] ", poltronas2[l][c]);
                    x = 1;
                }
            }
            System.out.print("|");
            System.out.println();

        }
        System.out.println("|------------------------------------------------------------------------|");
        System.out.print(Color.RED);
        System.out.println("[xx] = POLTRONA INDISPONÍVEL");
        System.out.print(Color.RESET);
        System.out.println("[xx] = POLTRONA DISPONÍVEL");
    }

    // FUNÇÃO PARA IMPRIMIR MENU PRINCIPAL
    public static void menu() {
        System.out.println("________________________________________________");
        System.out.println("|       COMPRE SUA PASSAGEM DE ÔNIBUS AQUI     |");
        System.out.println("|----------------------------------------------|");
        System.out.println("|   DIGITE APENAS O NÚMERO DA OPÇÃO ESCOLHIDA  |");
        System.out.println("|                                              |");
        System.out.println("| 1 - Comprar Passagem                         |");
        System.out.println("| 2 - Reservar Passagem                        |");
        System.out.println("| 3 - Cancelar Passagem                        |");
        System.out.println("| 4 - Relatório de Vendas                      |");
        System.out.println("| 0 - Fechar Janela                            |");
        System.out.println("|______________________________________________|");
    }

    // FUNÇÃO PARA IMPRIMIR AS OPÇÕES DE LINHA DE ÔNIBUS DISPONÍVEIS
    public static void linha() {
        System.out.println("________________________________________________");
        System.out.println("|               ESCOLHA A LINHA                |");
        System.out.println("|----------------------------------------------|");
        System.out.println("|   DIGITE APENAS O NÚMERO DA OPÇÃO ESCOLHIDA  |");
        System.out.println("|                                              |");
        System.out.println("| 1 - Toledo para Cascavel                     |");
        System.out.println("| 2 - Cascavel para Toledo                     |");
        System.out.println("|______________________________________________|");
    }

    // FUNÇÃO PARA IMPRIMIR AS OPÇÕES DE PAGAMENTO
    public static void pagamento() {
        // Esta opção somente será impressa na tela se a opção escolhida no menu
        // principal for 'Comprar Passagem'

        System.out.println("________________________________________________");
        System.out.println("|        O valor da passagem é R$ 20,00        |");
        System.out.println("|______________________________________________|");
        System.out.println("|         ESCOLHA A FORMA DE PAGAMENTO         |");
        System.out.println("|----------------------------------------------|");
        System.out.println("|   DIGITE APENAS O NÚMERO DA OPÇÃO ESCOLHIDA  |");
        System.out.println("|                                              |");
        System.out.println("| 1 - Dinheiro                                 |");
        System.out.println("| 2 - Cartão de crédito                        |");
        System.out.println("| 3 - PIX                                      |");
        System.out.println("|______________________________________________|");
    }

    // FUNÇÃO PARA IMPRIMIR O RELATÓRIO

    /*
     * Método para imprimir os relatórios de venda, reserva e cancelamentos.
     * É possível acessar esses dados somente com senha, assim somente os
     * funcionários tem acesso.
     * A senha é 4321.
     */

    public static void relatorio(int ocupado1[], int ocupado2[], int poltronas1[][], int poltronas2[][], int cancelado1,
            int cancelado2) {
        double porcent1 = 0;
        double porcent2 = 0;

        for (int l = 0; l < 4; l++) {
            for (int c = 0; c < 12; c++) {
                if (ocupado1[poltronas1[l][c]] == poltronas1[l][c]) {
                    porcent1++; // Contador para determinar a quantidade de poltronas reservadas da linha 1
                }
                if (ocupado2[poltronas2[l][c]] == poltronas2[l][c]) {
                    porcent2++; // Contador para determinar a quantidade de poltronas reservadas da linha 2
                }
            }
        }

        // Cálculos para o relatório
        porcent1 = porcent1 / 48;
        porcent1 = porcent1 * 100;
        porcent2 = porcent2 / 48;
        porcent2 = porcent2 * 100;

        // Imprime as informações do relatório na tela
        System.out.println("Linha 1: Toledo para Cascavel");
        System.out.println(porcent1 + "% das poltronas estão ocupadas");
        System.out.println("Houve um total de " + cancelado1 + " cancelamentos de passagens e reservas");
        System.out.println();
        System.out.println("Linha 2: Cascavel para Toledo");
        System.out.println(porcent2 + "% das poltronas estão ocupadas");
        System.out.println("Houve um total de " + cancelado2 + " cancelamentos de passagens e reservas");
    }

    // FUNÇÃO PARA LIMPAR O TERMINAL
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // FUNÇÃO MENSAGEM DE ERRO
    public static void erro() {
        System.out.print(Color.RED);
        System.out.println("*****ERRO*****ERRO*****");
        System.out.println("DIGITE UMA OPÇÃO VÁLIDA");
        System.out.print(Color.RESET);
    }

    // FUNÇÃO PARA CANCELAR RESERVA
    public static void cancelar(int poltrona, int ocupado1[], int poltronas1[][], int linha, int ocupado2[],
            int poltronas2[][], int cancelado1, int cancelado2) {

        // Condicional caso a linha escolhida for "Toledo - Cascavel"
        if (linha == 1) {

            // Condicional para caso a poltrona escolhida não ter sido reservada
            // anteriormente
            if (poltrona != ocupado1[poltrona]) {
                System.out.print(Color.YELLOW); // As cores do terminal ficam amarelas
                System.out.println("POLTRONA NÃO RESERVADA");
                System.out.print(Color.RESET);
            }

            // Condicional para caso a poltrona escolhida tiver sido reservada
            if (poltrona == ocupado1[poltrona]) {
                ocupado1[poltrona] = 0; // esvazia a posição da array, cancelando a reserva

            }

        }
        // Condicional caso a linha escolhida for "Cascavel - Toledo"
        if (linha == 2) {
            if (poltrona != ocupado2[poltrona]) {
                System.out.print(Color.YELLOW);
                System.out.println("POLTRONA NÃO RESERVADA");
                System.out.print(Color.RESET);
            }

            if (poltrona == ocupado2[poltrona]) {
                ocupado2[poltrona] = 0;

            }
        }
    }

    // FUNÇÃO PARA MENSAGEM FINAL
    public static void voltesempre() {
        System.out.print(Color.GREEN); // As cores do terminal ficam verdes
        System.out.println("PROCESSO REALIZADO COM SUCESSO");
        System.out.print(Color.RESET);
    }

    public static void main(String[] args) throws IOException {
        // DECLARAÇÃO DE VARIÁVEIS, MATRIZES E VETORES
        int poltronas1[][] = new int[4][12];
        int poltronas2[][] = new int[4][12];
        int ocupado1[] = new int[49];
        int ocupado2[] = new int[49];
        int cancelado1 = 0;
        int cancelado2 = 0;

        // INÍCIO DO SISTEMA
        numeropoltrona(poltronas1, poltronas2);
        int comando = 1;
        Scanner scan = new Scanner(System.in); // abre o scanner
        while (comando != 0) {
            int flag = 0;
            // Imprime menu principal
            menu();

            // Lê o comando escolhido pelo usuário
            comando = scan.nextInt();

            if (comando == 1 || comando == 2) {
                // Imprime as linhas de ônibus disponíveis
                linha();

                // Lê a linha escolhida pelo usuário
                int linha = scan.nextInt();

                // Comando condicional caso for a linha escolhida for "Toledo para Cascavel"
                if (linha == 1) {
                    poltronas1(poltronas1, ocupado1); // Imprime poltronas na tela
                    int poltrona = scan.nextInt(); // Lê a poltrona escolhida pelo usuário

                    // Condicional caso a poltrona escolhida já estiver reservada
                    if (ocupado1[poltrona] == poltrona) {
                        // Imprime a mensagem de erro
                        erro();
                        flag = 1; // impede que o menu de pagamento e a mensagem final sejam impressas
                    } else
                        ocupado1[poltrona] = poltrona; // reserva poltrona
                }

                // Comando condicional caso for a linha escolhida for "Cascavel para Toledo"
                if (linha == 2) {
                    poltronas2(poltronas2, ocupado2);
                    int poltrona = scan.nextInt();
                    if (ocupado2[poltrona] == poltrona) {
                        erro();
                        flag = 1; 
                    } else
                        ocupado2[poltrona] = poltrona;
                }

                // Comando condicional a opção escolhida não estiver disponível
                if (linha != 1 && linha != 2) {
                    erro();
                    flag = 1;
                }

            }

            // Comando para caso as opções "Comprar Passagem" e "Reservar Passagem" forem
            // preenchidas corretamente
            if (comando == 1 && flag != 1 || comando == 2 && flag != 1) {
                // Imprime opções de pagamento
                pagamento();
                int pagamento = scan.nextInt(); // Lê a opção de pagamento escolhida
            }

            // Comando condicional caso a opção escolhida for "Cancelar Passagem"
            if (comando == 3) {
                linha();
                int linha = scan.nextInt();

                if (linha == 1) {
                    poltronas1(poltronas1, ocupado1);
                    int poltrona = scan.nextInt();
                    cancelar(poltrona, ocupado1, poltronas1, linha, ocupado2, poltronas2, cancelado1, cancelado2);
                    cancelado1++; // Quantidade de vezes que a poltrona foi cancelada
                }

                if (linha == 2) {
                    poltronas2(poltronas2, ocupado2);
                    int poltrona = scan.nextInt();
                    cancelar(poltrona, ocupado1, poltronas1, linha, ocupado2, poltronas2, cancelado1, cancelado2);
                    cancelado2++;
                }
            }

            // Comando condicional caso a opção escolhida for "Relatórios de Vendas"
            if (comando == 4) {
                System.out.println("Digite a senha de administrador");
                int senha = scan.nextInt();

                // Comando condicional de verificação da senha
                if (senha == 4321)

                    // Imprime relatórios
                    relatorio(ocupado1, ocupado2, poltronas1, poltronas2, cancelado1, cancelado2);
                else
                    erro(); // Caso a senha digitada não for a correta, irá imprimir uma mensagem de erro
            }

            // Comando condicional caso a opção escolhida no menu principal não estiver
            // disponível
            if (comando > 4) {
                erro();
                flag = 1;
            }

            // Permite que a mensagem final seja impressa
            if (flag == 0)
                voltesempre(); // imprime mensagem final
        }
        scan.close(); // fecha o scanner
    }
}