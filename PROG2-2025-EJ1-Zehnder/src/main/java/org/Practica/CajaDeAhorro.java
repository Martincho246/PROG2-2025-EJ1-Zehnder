package org.Practica;

public class CajaDeAhorro extends Cuenta {

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
            if (saldo >= monto) {
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
