package Service;

import org.Practica.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class ServiceCuenta {
    private static ServiceCuenta instancia;
    private List<Cuenta> cuentas;

    private ServiceCuenta() {
        cuentas = new ArrayList<>();
    }

    // Singleton con metodo sincronizado
    public static synchronized ServiceCuenta getInstancia() {
        if (instancia == null) {
            instancia = new ServiceCuenta();
        }
        return instancia;
    }

    public void registrarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public boolean agregarSaldo(int cuenta, double monto) {
        if (cuenta < 0 || cuenta >= cuentas.size()) return false;
        return cuentas.get(cuenta).agregarSaldo(monto);
    }

    public boolean quitarSaldo(int cuenta, double monto) {
        if (cuenta < 0 || cuenta >= cuentas.size()) return false;
        return cuentas.get(cuenta).quitarSaldo(monto);
    }

    public double consultarSaldo(int cuenta) {
        if (cuenta < 0 || cuenta >= cuentas.size()) {
            System.out.println("Cuenta no válida");
        }
        return cuentas.get(cuenta).getSaldo();
    }

    public int consultarOperaciones(int cuenta) {
        if (cuenta < 0 || cuenta >= cuentas.size()) {
            System.out.println("Cuenta no válida");
        }
        return (int) cuentas.get(cuenta).getOperaciones();
    }
}
