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
	private static Scanner ler = new Scanner(System.in);
	private Jogador[] jogadores = { new Jogador('X'), new Jogador('O') };

	public Jogo() {
		v.jogadorAtual = 0; // Começa com o jogador 0 ('X')
		exibirMenu();
	}

	public void jogar() {
	    while (true) {
	        tabuleiro.exibeTabuleiro();
	        boolean entradaValida = false;

	        while (!entradaValida) {
	            try {
	                System.out.printf("Jogador %c, escolha a linha (0 a 2): ", jogadores[v.jogadorAtual].getSimbolo());
	                v.linha = ler.nextInt();

	                System.out.printf("Escolha a coluna (0 a 2): ");
	                v.coluna = ler.nextInt();

	                // Verifica se a entrada está dentro do intervalo válido
	                if (v.linha >= 0 && v.linha <= 2 && v.coluna >= 0 && v.coluna <= 2) {
	                    entradaValida = true;
	                } else {
	                    System.out.println("Entrada inválida. Linhas e colunas devem estar entre 0 e 2.");
	                }
	            } catch (Exception e) {
	                System.out.println("Entrada inválida. Por favor, insira números inteiros.");
	                ler.nextLine(); // Consumir a entrada inválida para evitar loop infinito
	            }
	        }

	        int[] tentativa = { v.linha, v.coluna };
	        if (tabuleiro.getPosicao(tentativa) == ' ') {
	            tabuleiro.setPosicao(tentativa, jogadores[v.jogadorAtual].getSimbolo());
	            if (tabuleiro.verificarVencedor(jogadores[v.jogadorAtual].getSimbolo())) {
	                tabuleiro.exibeTabuleiro();
	                System.out.printf("Jogador %c venceu!\n", jogadores[v.jogadorAtual].getSimbolo());
	                break;
	            } else if (tabuleiro.verificarEmpate()) {
	                tabuleiro.exibeTabuleiro();
	                System.out.println("O jogo empatou!");
	                break;
	            }
	            v.jogadorAtual = (v.jogadorAtual + 1) % 2;
	        } else {
	            System.out.println("Posição já ocupada. Tente novamente.");
	        }
	    }
	}

	

	public void exibirMenu() {
		while (true) {

			boolean opcaoValida = false;
			do {
				try {
					System.out.println("\nMenu:");
					System.out.println("1. Nova rodada");
					System.out.println("2. Jogar novamente");
					System.out.println("3. Sair do jogo");
					System.out.println("4. Voltar ao início");
					System.out.print("Escolha uma opção: ");
					v.opcao = ler.nextInt();
					ler.nextLine();

					if (v.opcao >= 1 && v.opcao <= 4) {
						opcaoValida = true;
					} else {
						System.out.println("Opção inválida. Tente novamente.");
					}
				} catch (Exception e) {
					System.out.println("Entrada inválida. Tente novamente.");
					ler.nextLine(); 
				}
			} while (!opcaoValida);

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
				break;
			}
		}
	}

	private void iniciarJogo() {
		tabuleiro.zerarTabuleiro();
		jogar();
	}
}
