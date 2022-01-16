package bfinal;

import bfinal.enums.Arma;
import bfinal.enums.Motivacao;

public class Mago extends Jogador {
    public Mago(String nome, String sexo, Motivacao motivacao, Arma arma) throws IllegalArgumentException {
        super(19, 11, nome, sexo, motivacao, arma);
        if (arma != Arma.CAJADO && arma != Arma.LIVRO_DE_MAGIAS) throw new IllegalArgumentException();
    }

    @Override
    public void atacar(Personagem personagem) {

    }
}
