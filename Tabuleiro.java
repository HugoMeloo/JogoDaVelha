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
    private Campo[][] tabuleiro = new Campo[3][3];

    public Tabuleiro() {
        zerarTabuleiro();
    }

    public void zerarTabuleiro() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                tabuleiro[linha][coluna] = new Campo();
            }
        }
    }

    public void exibeTabuleiro() {
        System.out.println();
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.print(tabuleiro[linha][coluna]);
                if (coluna < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (linha < 2) {
                System.out.println("-----");
            }
        }
    }

    public char getPosicao(int[] tentativa) {
        return tabuleiro[tentativa[0]][tentativa[1]].getSimbolo();
    }

    public void setPosicao(int[] tentativa, char simbolo) {
        tabuleiro[tentativa[0]][tentativa[1]].setSimbolo(simbolo);
    }

    public boolean verificarVencedor(char simbolo) {
        // Verifica linhas
        for (int linha = 0; linha < 3; linha++) {
            if (tabuleiro[linha][0].getSimbolo() == simbolo && tabuleiro[linha][1].getSimbolo() == simbolo && tabuleiro[linha][2].getSimbolo() == simbolo) {
                return true;
            }
        }

        // Verifica colunas
        for (int coluna = 0; coluna < 3; coluna++) {
            if (tabuleiro[0][coluna].getSimbolo() == simbolo && tabuleiro[1][coluna].getSimbolo() == simbolo && tabuleiro[2][coluna].getSimbolo() == simbolo) {
                return true;
            }
        }

        // Verifica diagonais
        if (tabuleiro[0][0].getSimbolo() == simbolo && tabuleiro[1][1].getSimbolo() == simbolo && tabuleiro[2][2].getSimbolo() == simbolo) {
            return true;
        }

        if (tabuleiro[0][2].getSimbolo() == simbolo && tabuleiro[1][1].getSimbolo() == simbolo && tabuleiro[2][0].getSimbolo() == simbolo) {
            return true;
        }

        return false;
    }

    public boolean verificarEmpate() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (tabuleiro[linha][coluna].getSimbolo() == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
