package main.java.br.com.game.util;

import main.java.br.com.game.personagens.*;

import java.util.*;

public class PersonagemUtil {
    public Personagem getHeroi(int escolhaHeroi) {
        try{
            List<Personagem> personagens = new ArrayList<Personagem>();
            personagens.add(new Guerreiro());
            personagens.add(new Barbaro());
            personagens.add(new Paladino());
            return personagens.get(escolhaHeroi - 1);
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Escolha inválida Guerreiro escolhido por padrão");
            return new Guerreiro();
        }
    }
    public Personagem getHeroiComIf(int escolhaHeroi) {
        Personagem heroi;
        if(escolhaHeroi == 1){
            heroi = new Guerreiro();
        }else if(escolhaHeroi == 2){
            heroi = new Barbaro();
        }else if(escolhaHeroi == 3){
            heroi = new Paladino();
        }else {
            System.out.println("Escolha inválida Guerreiro escolhido por padrão");
            heroi = new Guerreiro();
        }
        return heroi;
    }
    public Personagem getHeroiComSwitchAntesJava14(int escolhaHeroi) {
        Personagem heroi;
        switch (escolhaHeroi){
            case 1: heroi = new Guerreiro(); break;
            case 2: heroi = new Barbaro(); break;
            case 3: heroi = new Paladino(); break;
            default: heroi = new Guerreiro(); break;
        }
        return heroi;
    }
    public Personagem getHeroiComSwitchPosJava14(int escolhaHeroi) {
        if(escolhaHeroi == 2){
            return new Barbaro();
        } else if (escolhaHeroi == 3) {
            return new Paladino();
        }else{
            return new Guerreiro();
        }

    }


    public Personagem getMonstro() {
        List<Personagem> monstros = new ArrayList<Personagem>();
        monstros.add(new Orc());
        monstros.add(new Kobold());
        monstros.add(new MortoVivo());
        Random random = new Random();
        int escolhaMonstro = random.nextInt(2);
        return monstros.get(escolhaMonstro);
    }
}
