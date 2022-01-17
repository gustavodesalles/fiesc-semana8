package bfinal.jogadores;

import bfinal.Personagem;
import bfinal.enums.Arma;
import bfinal.enums.Motivacao;

import java.util.concurrent.ThreadLocalRandom;

public class Arqueiro extends Jogador {
    public Arqueiro(String nome, String sexo, Motivacao motivacao, Arma arma) throws IllegalArgumentException {
        super(18, 13, nome, sexo, motivacao, arma);
        if (arma != Arma.ARCO && arma != Arma.BESTA) throw new IllegalArgumentException();
    }

    @Override
    public void atacar(Personagem personagem) {
        String nomeArma = "";
        if (getArma() == Arma.ARCO) nomeArma = "com seu arco, a flecha atingiu";
        if (getArma() == Arma.BESTA) nomeArma = "com sua besta, o virote atingiu";

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
