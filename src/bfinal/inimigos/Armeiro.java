package bfinal.inimigos;

import bfinal.Personagem;
import bfinal.enums.Arma;

public class Armeiro extends Inimigo {
    private static int saudeMaxima = 100;

    public Armeiro() {
        super(saudeMaxima, 10, 15, Arma.ESPADA);
    }

    @Override
    public void atacar(Personagem personagem) {

    }
}
