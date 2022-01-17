package bfinal.jogadores;

import bfinal.Personagem;
import bfinal.enums.Arma;
import bfinal.enums.Motivacao;
import bfinal.jogadores.Jogador;

import java.util.concurrent.ThreadLocalRandom;

public class Mago extends Jogador {
    public Mago(String nome, String sexo, Motivacao motivacao, Arma arma) throws IllegalArgumentException {
        super(19, 11, nome, sexo, motivacao, arma);
        if (arma != Arma.CAJADO && arma != Arma.LIVRO_DE_MAGIAS) throw new IllegalArgumentException();
    }

    @Override
    public void atacar(Personagem personagem) {
        String nomeArma = "";
        if (getArma() == Arma.CAJADO) nomeArma = "com seu cajado, lançando uma bola de fogo";
        if (getArma() == Arma.LIVRO_DE_MAGIAS) nomeArma = "absorvendo energia do livro com uma mão e liberando com a outra";

        int roll = ThreadLocalRandom.current().nextInt(1, 21);
        if (roll == 1) {
            System.out.println("Você errou seu ataque! O inimigo não sofreu dano algum.");
        } else if (roll == 20) {
            int dano = this.getPontosAtk() + this.getArma().getPontosAtaque() + roll;
            personagem.setPontosSaude(personagem.getPontosSaude() - dano);
            System.out.println("Você acertou um ataque crítico "+ nomeArma +" e causou "+ dano +" de dano no inimigo!");
        } else {
            int dano = this.getPontosAtk() + this.getArma().getPontosAtaque() + roll - personagem.getPontosDef();
            personagem.setPontosSaude(personagem.getPontosSaude() - dano);
            System.out.println("Você atacou "+ nomeArma +" e causou "+ dano +" de dano no inimigo!");
        }
    }
}
