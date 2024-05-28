/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogodavelhaf;

import java.util.Scanner;

/**
 *
 * @author hugog
 */
public class Jogo {
      private Tabuleiro tabuleiro = new Tabuleiro();
    private Variaveis v = new Variaveis();
    private Scanner ler = new Scanner(System.in);

    public Jogo() {
        v.jogadorAtual = 1;
        exibirMenu();
    }

    public void jogar() {
        while (true) {
            tabuleiro.exibeTabuleiro();
            System.out.printf("Jogador %d, escolha a linha (0 a 2):\n", v.jogadorAtual);
            v.linha = ler.nextInt();
            System.out.printf("Escolha a coluna (0 a 2):\n");
            v.coluna = ler.nextInt();

            int[] tentativa = { v.linha, v.coluna };
            if (tabuleiro.getPosicao(tentativa) == 0) {
                tabuleiro.setPosicao(tentativa, v.jogadorAtual);
                if (tabuleiro.verificarVencedor(v.jogadorAtual)) {
                    tabuleiro.exibeTabuleiro();
                    System.out.printf("Jogador %d venceu!\n", v.jogadorAtual);
                    break;
                } else if (tabuleiro.verificarEmpate()) {
                    tabuleiro.exibeTabuleiro();
                    System.out.println("O jogo empatou!\n");
                    break;
                }
                v.jogadorAtual = (v.jogadorAtual == 1) ? 2 : 1;
            } else {
                System.out.println("Posição já ocupada. Tente novamente.");
            }
        }
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Nova rodada");
            System.out.println("2. Jogar novamente");
            System.out.println("3. Sair do jogo");
            System.out.println("4. Voltar ao início");
            System.out.print("Escolha uma opção:\n");
            v.opcao = ler.nextInt();

            switch (v.opcao) {
                case 1:
                case 2:
                case 4:
                    iniciarJogo();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void iniciarJogo() {
        tabuleiro.zerarTabuleiro();
        jogar();
    }

}
