package main.java.br.com.epicBattle;

import main.java.br.com.game.exception.DanoInvalidoException;
import main.java.br.com.game.personagens.Personagem;
import main.java.br.com.game.util.PersonagemUtil;

import java.util.Scanner;

import static main.java.br.com.game.util.GraphicsUtil.getBoasVindas;
import static main.java.br.com.game.util.GraphicsUtil.getMenu;


public class Main {
    public static void main(String[] args) {
        getBoasVindas();
        Scanner scanner = new Scanner(System.in);
        String nickname = scanner.next();
        getMenu();
        int escolhaHeroi = scanner.nextInt();
        PersonagemUtil personagemUtil = new PersonagemUtil();

        Personagem heroi = personagemUtil.getHeroi(escolhaHeroi);
        Personagem monstro = personagemUtil.getMonstro();
        int quantidadeDeRodadas = 0;
        while (batalhaAtiva(heroi, monstro)) {
            quantidadeDeRodadas++;
            int iniciativaHeroi;
            int iniciativaMonstro;

            do{
                iniciativaHeroi = heroi.calcularIniciativa();
                iniciativaMonstro = monstro.calcularIniciativa();
            }while (iniciativaHeroi == iniciativaMonstro);
            Personagem atacante,defensor;

            if(iniciativaHeroi > iniciativaMonstro){
                atacante = heroi;
                defensor = monstro;
            }else {
                atacante = monstro;
                defensor = heroi;
            }

            if(conseguiuAtacar(atacante, defensor)){
                System.out.printf("%s ATACOU \n", atacante.getClasse());
                int dano = atacante.calcularFatorDeDano();
                try{
                    defensor.sofrerDano(dano);
                }catch (DanoInvalidoException ex){
                    defensor.sofrerDano(1);
                }

            }else {
                System.out.println("Atacante não teve sucesso!");
            }
        }
        if(monstro.getPontosDeVida() <= 0){
            System.out.printf("%s Venceu em: %d rodadas \n", heroi.getClasse(), quantidadeDeRodadas);
            //Heroi venceu
        }else {
            System.out.printf("%s Venceu em: %d rodadas \n", heroi.getClasse(), quantidadeDeRodadas);
        }

    }

    private static boolean batalhaAtiva(Personagem heroi, Personagem monstro) {
        return heroi.getPontosDeVida() > 0 || monstro.getPontosDeVida() > 0;
    }

    private static boolean conseguiuAtacar(Personagem atacante, Personagem defensor) {
        return atacante.calcularFatorDeAtaque() > defensor.calcularFatorDeDefesa();
    }




}