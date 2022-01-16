package bfinal.inimigos;

import bfinal.Personagem;
import bfinal.enums.Arma;

public class Alquimista extends Inimigo {
    private static int saudeMaxima = 100;

    public Alquimista() {
        super(saudeMaxima, 15, 10, Arma.CAJADO);
    }

    @Override
    public void atacar(Personagem personagem) {

    }
}
