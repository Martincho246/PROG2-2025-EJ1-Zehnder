import org.Practica.CuentaCorriente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CuentaCorrienteTest {
    private CuentaCorriente cuentaCorriente;

    @BeforeEach
    void setUp() {
        cuentaCorriente = new CuentaCorriente(500.0);  // Giro descubierto de 500
    }

    @Test
    void testAgregarSaldo_conMontoPositivo() {
        boolean resultado = cuentaCorriente.agregarSaldo(1000.0);

        assertTrue(resultado);
        assertEquals(1000.0, cuentaCorriente.getSaldo());
        assertEquals(1, cuentaCorriente.getOperaciones());
    }

    @Test
    void testAgregarSaldo_conMontoNegativo() {
        boolean resultado = cuentaCorriente.agregarSaldo(-500.0);

        assertFalse(resultado);
        assertEquals(0.0, cuentaCorriente.getSaldo());
        assertEquals(0, cuentaCorriente.getOperaciones());
    }

    @Test
    void testQuitarSaldo_conMontoMenorAlSaldo() {
        cuentaCorriente.agregarSaldo(800.0);
        boolean resultado = cuentaCorriente.quitarSaldo(300.0);

        assertTrue(resultado);
        assertEquals(500.0, cuentaCorriente.getSaldo());
        assertEquals(2, cuentaCorriente.getOperaciones()); // 1 por agregar, 1 por quitar
    }

    @Test
    void testQuitarSaldo_conMontoIgualAlSaldo() {
        cuentaCorriente.agregarSaldo(500.0);
        boolean resultado = cuentaCorriente.quitarSaldo(500.0);

        assertTrue(resultado);
        assertEquals(0.0, cuentaCorriente.getSaldo());
        assertEquals(2, cuentaCorriente.getOperaciones());
    }

    @Test
    void testQuitarSaldo_conMontoMayorAlSaldoPeroDentroDelGiroDescubierto() {
        cuentaCorriente.agregarSaldo(200.0);
        boolean resultado = cuentaCorriente.quitarSaldo(600.0);  // Dentro del giro descubierto

        assertTrue(resultado);
        assertEquals(-400.0, cuentaCorriente.getSaldo());  // 200 - 600 = -400
        assertEquals(2, cuentaCorriente.getOperaciones()); // 1 por agregar, 1 por quitar
    }

    @Test
    void testQuitarSaldo_conMontoMayorAlSaldoFueraDelGiroDescubierto() {
        cuentaCorriente.agregarSaldo(200.0);
        boolean resultado = cuentaCorriente.quitarSaldo(800.0);  // Fuera del giro descubierto

        assertFalse(resultado);
        assertEquals(200.0, cuentaCorriente.getSaldo());  // No se debería haber descontado
        assertEquals(1, cuentaCorriente.getOperaciones()); // Solo la operación de agregar
    }

    @Test
    void testQuitarSaldo_conMontoNegativo() {
        boolean resultado = cuentaCorriente.quitarSaldo(-200.0);

        assertFalse(resultado);
        assertEquals(0.0, cuentaCorriente.getSaldo());
        assertEquals(0, cuentaCorriente.getOperaciones());
    }
}
