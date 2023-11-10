package main.java.br.com.game.personagens;

import main.java.br.com.game.util.DadoUtil;

public class Kobold extends Personagem {
    public Kobold() {
        super(20,4,2,2,4, "Kobold");
    }
    @Override
    public int calcularFatorDeDano() {
        DadoUtil dadoUtil = new DadoUtil();
        return (dadoUtil.rollD2() + dadoUtil.rollD2()+ dadoUtil.rollD2() ) + getPontosDeForca() ;
    }
}
