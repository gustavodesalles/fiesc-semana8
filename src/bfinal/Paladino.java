package bfinal;

import bfinal.enums.Arma;
import bfinal.enums.Motivacao;

public class Paladino extends Jogador {
    public Paladino(String nome, String sexo, Motivacao motivacao, Arma arma) throws IllegalArgumentException {
        super(13, 18, nome, sexo, motivacao, arma);
        if (arma != Arma.MARTELO && arma != Arma.CLAVA) throw new IllegalArgumentException();
    }

    @Override
    public void atacar(Personagem personagem) {

    }
}
