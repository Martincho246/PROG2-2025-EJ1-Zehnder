package org.Practica;

public class CuentaCorriente extends Cuenta{
    private double giroDescubierto;

    public CuentaCorriente(double giroDescubierto) {
        this.giroDescubierto = giroDescubierto;
    }

    @Override
    public synchronized boolean agregarSaldo(double monto) {
        if (monto > 0) {
            saldo += monto;
            operaciones++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
        if (monto > 0) {
            if ((saldo - monto) >= -giroDescubierto) {
                saldo -= monto;
                operaciones++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
