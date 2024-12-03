package model;

public enum Comision {
    BAJA(1.0), MEDIA(2.5), ALTA(4.0);

    private final double valor;

    Comision(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
