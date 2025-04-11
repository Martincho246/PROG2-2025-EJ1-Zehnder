package DTO;

public class CajaDeAhorroDto {
    private double saldo;
    private int operaciones;

    public CajaDeAhorroDto() {}

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(int operaciones) {
        this.operaciones = operaciones;
    }
}
