package org.example;

public interface IGestionSaldo {

    Cuenta cuenta = new Cuenta();
    public default boolean agregarSaldo(double monto) {

        return false;
    }
    boolean quitarSaldo(double monto);
    double getSaldo();
    double getOperaciones();

}
