package bfinal;

import bfinal.enums.Arma;
import bfinal.enums.Motivacao;

public class Arqueiro extends Jogador {
    public Arqueiro(String nome, String sexo, Motivacao motivacao, Arma arma) throws IllegalArgumentException {
        super(18, 13, nome, sexo, motivacao, arma);
        if (arma != Arma.ARCO && arma != Arma.BESTA) throw new IllegalArgumentException();
    }

    @Override
    public void atacar(Personagem personagem) {

    }
}
