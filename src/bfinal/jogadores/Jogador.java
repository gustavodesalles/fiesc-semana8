package bfinal.jogadores;

import bfinal.Atacante;
import bfinal.Personagem;
import bfinal.enums.Arma;
import bfinal.enums.Motivacao;

public abstract class Jogador extends Personagem implements Atacante {
    private String nome;
    private String sexo;
    private Motivacao motivacao;
    private Arma arma;
    private static final int saudeMaxima = 200;

    public Jogador(int pontosAtk, int pontosDef, String nome, String sexo, Motivacao motivacao, Arma arma) throws IllegalArgumentException {
        super(saudeMaxima, pontosAtk, pontosDef);
        if (!nome.isBlank() || !nome.isEmpty()) {
            this.nome = nome;
        } else throw new IllegalArgumentException();
        if (sexo.equals("m") || sexo.equals("f")) {
            this.sexo = sexo;
        } else throw new IllegalArgumentException();
        this.motivacao = motivacao;
        this.arma = arma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Motivacao getMotivacao() {
        return motivacao;
    }

    public void setMotivacao(Motivacao motivacao) {
        this.motivacao = motivacao;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public int getSaudeMaxima() {
        return saudeMaxima;
    }
}
