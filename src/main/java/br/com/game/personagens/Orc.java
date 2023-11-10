package main.java.br.com.game.personagens;

import main.java.br.com.game.util.DadoUtil;

public class Orc extends Personagem {
    public Orc() {
        super(20,6,2,2,2, "Orc");
    }

    @Override
    public int calcularFatorDeDano() {
        DadoUtil dadoUtil = new DadoUtil();
        return dadoUtil.rollD8() + getPontosDeForca();
    }
}
