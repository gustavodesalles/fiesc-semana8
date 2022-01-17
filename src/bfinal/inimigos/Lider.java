package bfinal.inimigos;

import bfinal.Personagem;
import bfinal.enums.Arma;
import bfinal.inimigos.Inimigo;

import java.util.concurrent.ThreadLocalRandom;

public class Lider extends Inimigo {
    private static int saudeMaxima = 200;

    public Lider() {
        super(saudeMaxima, 15, 15, Arma.MACHADO_DUPLO);
    }

    @Override
    public void atacar(Personagem personagem) {
        int roll = ThreadLocalRandom.current().nextInt(1, 21);
        if (roll == 1) {
            System.out.println("O inimigo errou o ataque! Você não sofreu dano.");
        } else if (roll == 20) {
            int dano = this.getPontosAtk() + this.getArma().getPontosAtaque() + roll;
            if (dano > personagem.getPontosSaude()) {
                personagem.setPontosSaude(0);
            } else {
                personagem.setPontosSaude(personagem.getPontosSaude() - dano);
            }
            System.out.println("O inimigo acertou um ataque crítico! Você sofreu "+ dano +" de dano e agora possui "+ personagem.getPontosSaude() +" pontos de vida.");
        } else {
            int dano = this.getPontosAtk() + this.getArma().getPontosAtaque() + roll - personagem.getPontosDef();
            if (dano > personagem.getPontosSaude()) {
                personagem.setPontosSaude(0);
            } else {
                personagem.setPontosSaude(personagem.getPontosSaude() - dano);
            }
            System.out.println("O inimigo atacou! Você sofreu "+ dano +" de dano e agora possui "+ personagem.getPontosSaude() +" pontos de vida.");
        }
    }
}
