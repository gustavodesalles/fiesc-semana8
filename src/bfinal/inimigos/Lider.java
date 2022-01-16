package bfinal.inimigos;

import bfinal.Personagem;
import bfinal.enums.Arma;
import bfinal.inimigos.Inimigo;

public class Lider extends Inimigo {
    private static int saudeMaxima = 200;

    public Lider(int pontosSaude, int pontosAtk, int pontosDef, Arma arma) {
        super(saudeMaxima, 15, 15, Arma.MACHADO_DUPLO);
    }

    @Override
    public void atacar(Personagem personagem) {

    }
}
