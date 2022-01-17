package bfinal.jogadores;

import bfinal.Personagem;
import bfinal.enums.Arma;
import bfinal.enums.Motivacao;
import bfinal.jogadores.Jogador;

import java.util.concurrent.ThreadLocalRandom;

public class Guerreiro extends Jogador {
    public Guerreiro(String nome, String sexo, Motivacao motivacao, Arma arma) throws IllegalArgumentException {
        super(15, 15, nome, sexo, motivacao, arma);
        if (arma != Arma.ESPADA && arma != Arma.MACHADO) throw new IllegalArgumentException();
    }

    @Override
    public void atacar(Personagem personagem) {
        String nomeArma = "";
        if (getArma() == Arma.ESPADA) nomeArma = "com sua espada";
        if (getArma() == Arma.MACHADO) nomeArma = "com seu machado";

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
