package Service;

import org.Practica.CajaDeAhorro;
import org.Practica.CuentaCorriente;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ServiceCuenta logica = ServiceCuenta.getInstancia();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            if (random.nextBoolean()) {
                logica.registrarCuenta(new CajaDeAhorro());
            } else {
                double descubierto = 100 + random.nextInt(901);
                logica.registrarCuenta(new CuentaCorriente(descubierto));
            }
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10000; i++) {
            executor.execute(() -> {
                int cuentaIndex = random.nextInt(10);
                double monto = 1 + random.nextInt(500);
                boolean operacion = random.nextBoolean();

                if (operacion) {
                    logica.agregarSaldo(cuentaIndex, monto);
                } else {
                    logica.quitarSaldo(cuentaIndex, monto);
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Error esperando la finalización.");
        }

        System.out.println("\n=== Resultados ===");
        for (int i = 0; i < 10; i++) {
            double saldo = logica.consultarSaldo(i);
            int ops = logica.consultarOperaciones(i);
            System.out.printf("Cuenta " + i + " → Saldo: $" + String.format("%.2f", saldo) + " | Operaciones: " + ops);
        }
    }
}