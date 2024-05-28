/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogodavelhaf;

/**
 *
 * @author hugog
 */
public class Campo {
    private char simbolo;

    public Campo() {
        this.simbolo = ' ';
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public String toString() {
        return String.valueOf(simbolo);
    }
}

