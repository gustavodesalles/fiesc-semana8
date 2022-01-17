package bfinal.inimigos;

import bfinal.Atacante;
import bfinal.Personagem;
import bfinal.enums.Arma;

import java.util.concurrent.ThreadLocalRandom;

public class Armadilha implements Atacante {
    private int pontosDeAtaque;
    private Arma arma;

    public Armadilha() {
        this.pontosDeAtaque = 5;
        this.arma = Arma.ARMADILHA;
    }

    @Override
    public void atacar(Personagem personagem) {
        int roll = ThreadLocalRandom.current().nextInt(1, 11);
        if (roll == 1) {
            System.out.println("O ataque da armadilha pegou de raspão e você não sofreu dano.");
        } else {
            int dano = pontosDeAtaque + arma.getPontosAtaque() + roll - personagem.getPontosDef();
            personagem.setPontosSaude(personagem.getPontosSaude() - dano);
            System.out.println("Você sofreu "+ dano +" de dano e agora possui "+ personagem.getPontosSaude() +" pontos de vida.");
        }
    }
}
