package main.java.br.com.game.personagens;


import lombok.Getter;
import main.java.br.com.game.exception.DanoInvalidoException;
import main.java.br.com.game.util.DadoUtil;
@Getter
public abstract class Personagem {

    private int pontosDeVida;
    private int pontosDeDefesa;
    private int pontosDeForca;
    private int pontosDeAtaque;
    private int pontosDeAgilidade;
    private String classe;

    public Personagem(int pontosDeVida, int pontosDeForca, int pontosDeAtaque, int pontosDeDefesa,
                      int pontosDeAgilidade,String classe) {
        this.pontosDeVida = pontosDeVida;
        this.pontosDeForca = pontosDeForca;
        this.pontosDeAtaque = pontosDeAtaque;
        this.pontosDeAgilidade = pontosDeAgilidade;
        this.pontosDeDefesa = pontosDeDefesa;
        this.classe = classe;

    }


    public abstract int calcularFatorDeDano();

    public int calcularIniciativa(){
        DadoUtil dadoUtil = new DadoUtil();
        return dadoUtil.rollD10() + pontosDeAgilidade;

    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Personagem{");
        sb.append("pontosDeVida=").append(pontosDeVida);
        sb.append(", classe='").append(classe).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int calcularFatorDeAtaque() {
        DadoUtil dadoUtil = new DadoUtil();
        return dadoUtil.rollD10() + pontosDeAgilidade + pontosDeForca;
    }

    public int calcularFatorDeDefesa() {
        DadoUtil dadoUtil = new DadoUtil();
        return dadoUtil.rollD10() + pontosDeAgilidade + pontosDeDefesa;
    }
    public void sofrerDano(int dano) {
        if(dano <= 0){

            throw  new DanoInvalidoException("Dano Nao pode ser menor q zero");
        }
        this.pontosDeVida -= dano;

    }
}
