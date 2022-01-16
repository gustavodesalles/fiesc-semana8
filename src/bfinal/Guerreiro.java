package bfinal;

import bfinal.enums.Arma;
import bfinal.enums.Motivacao;

public class Guerreiro extends Jogador {
    public Guerreiro(String nome, String sexo, Motivacao motivacao, Arma arma) throws IllegalArgumentException {
        super(15, 15, nome, sexo, motivacao, arma);
        if (arma != Arma.ESPADA && arma != Arma.MACHADO) throw new IllegalArgumentException();
    }

    @Override
    public void atacar(Personagem personagem) {

    }
}
