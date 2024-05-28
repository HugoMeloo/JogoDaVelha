/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogodavelhaf;

/**
 *
 * @author hugog
 */
public class Tabuleiro {
      private int[][] tabuleiro = new int[3][3];

    public Tabuleiro() {
        zerarTabuleiro();
    }

    public void zerarTabuleiro() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                tabuleiro[linha][coluna] = 0;
            }
        }
    }

    public void exibeTabuleiro() {
        System.out.println();
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (tabuleiro[linha][coluna] == -1) {
                    System.out.print(" X ");
                } else if (tabuleiro[linha][coluna] == 1) {
                    System.out.print(" O ");
                } else {
                    System.out.print("   ");
                }
                if (coluna < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (linha < 2) {
                System.out.println("-----------");
            }
        }
    }

    public int getPosicao(int[] tentativa) {
        return tabuleiro[tentativa[0]][tentativa[1]];
    }

    public void setPosicao(int[] tentativa, int jogador) {
        tabuleiro[tentativa[0]][tentativa[1]] = (jogador == 1) ? -1 : 1;
    }

    public boolean verificarVencedor(int jogador) {
        int simbolo = (jogador == 1) ? -1 : 1;

        // Verifica linhas
        for (int linha = 0; linha < 3; linha++) {
            if (tabuleiro[linha][0] == simbolo && tabuleiro[linha][1] == simbolo && tabuleiro[linha][2] == simbolo) {
                return true;
            }
        }

        // Verifica colunas
        for (int coluna = 0; coluna < 3; coluna++) {
            if (tabuleiro[0][coluna] == simbolo && tabuleiro[1][coluna] == simbolo && tabuleiro[2][coluna] == simbolo) {
                return true;
            }
        }

        // Verifica diagonais
        if (tabuleiro[0][0] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][2] == simbolo) {
            return true;
        }

        if (tabuleiro[0][2] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][0] == simbolo) {
            return true;
        }

        return false;
    }

    public boolean verificarEmpate() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (tabuleiro[linha][coluna] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
