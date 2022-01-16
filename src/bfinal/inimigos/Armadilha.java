package bfinal.inimigos;

import bfinal.enums.Arma;

public class Armadilha {
    private int pontosDeAtaque;
    private Arma arma;

    public Armadilha() {
        this.pontosDeAtaque = 5;
        this.arma = Arma.ARMADILHA;
    }
}
