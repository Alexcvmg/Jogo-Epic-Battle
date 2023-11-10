package main.java.br.com.game.util;

import java.util.Random;

public class DadoUtil {
    private int rollDice(int quantidadeDeFaces){
        Random random = new Random();
        return random.nextInt(quantidadeDeFaces) + 1;
    }

    public int rollD20(){
        return rollDice(20);
    }
    public int rollD4() {
        return rollDice(4);
    }

    public int rollD6() {
        return rollDice(6);
    }

    public int rollD8() {
        return rollDice(8);
    }

    public int rollD2() {
        return rollDice(2);
    }

    public int rollD10() {
        return rollDice(10);
    }
}
