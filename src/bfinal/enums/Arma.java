package bfinal.enums;

public enum Arma {
    SEM_ARMA(0),
    ESPADA,
    MACHADO,
    MARTELO,
    CLAVA,
    ARCO,
    BESTA,
    CAJADO,
    LIVRO_DE_MAGIAS,
    ARMADILHA(2),
    MACHADO_DUPLO(7);

    private final int pontosAtaque;

    Arma(int i) {
        this.pontosAtaque = i;
    }

    Arma() {
        this.pontosAtaque = 5;
    }

    public int getPontosAtaque() {
        return this.pontosAtaque;
    }
}
