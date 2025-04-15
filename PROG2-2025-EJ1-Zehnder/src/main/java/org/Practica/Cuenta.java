package org.Practica;

public abstract class Cuenta implements IGestionSaldo {
    protected double saldo;
    protected int operaciones;

    public Cuenta() {
        this.saldo = 0.0;
        this.operaciones = 0;
    }

    @Override
    public synchronized double getSaldo() {
        synchronized (this) {
            return saldo;
        }
    }

    @Override
    public synchronized int getOperaciones() {
        synchronized (this) {
            return operaciones;
        }
    }
}
