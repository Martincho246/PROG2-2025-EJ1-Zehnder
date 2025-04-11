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

        // 1. Crear 10 cuentas aleatorias
        for (int i = 0; i < 10; i++) {
            if (random.nextBoolean()) {
                logica.registrarCuenta(new CajaDeAhorro());
            } else {
                double descubierto = 100 + random.nextInt(901); // entre 100 y 1000
                logica.registrarCuenta(new CuentaCorriente(descubierto));
            }
        }

        // 2. Crear un pool de threads para ejecutar 10.000 operaciones concurrentes
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10000; i++) {
            executor.execute(() -> {
                int cuentaIndex = random.nextInt(10); // cuenta entre 0 y 9
                double monto = 1 + random.nextInt(500); // monto entre 1 y 500
                boolean operacion = random.nextBoolean(); // true: agregar, false: quitar

                if (operacion) {
                    logica.agregarSaldo(cuentaIndex, monto);
                } else {
                    logica.quitarSaldo(cuentaIndex, monto);
                }
            });
        }

        // 3. Cerrar el executor y esperar que termine
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Error esperando la finalización.");
        }

        // 4. Mostrar resultados
        System.out.println("\n=== Resultados Finales ===");
        for (int i = 0; i < 10; i++) {
            double saldo = logica.consultarSaldo(i);
            int ops = logica.consultarOperaciones(i);
            System.out.printf("Cuenta %d → Saldo: $%.2f | Operaciones: %d\n", i, saldo, ops);
        }
    }
}