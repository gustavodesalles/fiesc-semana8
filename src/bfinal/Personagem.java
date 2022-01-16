package bfinal;

public abstract class Personagem {
    private int pontosSaude;
    private int pontosAtk;
    private int pontosDef;

    public Personagem(int pontosSaude, int pontosAtk, int pontosDef) {
        this.pontosSaude = pontosSaude;
        this.pontosAtk = pontosAtk;
        this.pontosDef = pontosDef;
    }

    public int getPontosSaude() {
        return pontosSaude;
    }

    public void setPontosSaude(int pontosSaude) {
        this.pontosSaude = pontosSaude;
    }

    public int getPontosAtk() {
        return pontosAtk;
    }

    public void setPontosAtk(int pontosAtk) {
        this.pontosAtk = pontosAtk;
    }

    public int getPontosDef() {
        return pontosDef;
    }

    public void setPontosDef(int pontosDef) {
        this.pontosDef = pontosDef;
    }
}
