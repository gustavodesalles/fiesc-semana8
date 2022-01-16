package bfinal.inimigos;

import bfinal.Atacante;
import bfinal.Personagem;
import bfinal.enums.Arma;

public abstract class Inimigo extends Personagem implements Atacante {
    private Arma arma;

    public Inimigo(int pontosSaude, int pontosAtk, int pontosDef, Arma arma) {
        super(pontosSaude, pontosAtk, pontosDef);
        this.arma = arma;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }
}
