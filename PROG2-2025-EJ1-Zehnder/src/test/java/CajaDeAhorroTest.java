import org.Practica.CajaDeAhorro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CajaDeAhorroTest {
    private CajaDeAhorro caja;

    @BeforeEach
    void setUp() {
        caja = new CajaDeAhorro();
    }

    @Test
    void testAgregarSaldoConMontoPositivo() {
        boolean resultado = caja.agregarSaldo(1000.0);
        assertTrue(resultado);
        assertEquals(1000.0, caja.getSaldo());
        assertEquals(1, caja.getOperaciones());
    }

    @Test
    void testAgregarSaldoConMontoNegativo() {
        boolean resultado = caja.agregarSaldo(-200.0);
        assertFalse(resultado);
        assertEquals(0.0, caja.getSaldo());
        assertEquals(0, caja.getOperaciones());
    }

    @Test
    void testQuitarSaldoConMontoValido() {
        caja.agregarSaldo(1000.0);
        boolean resultado = caja.quitarSaldo(500.0);
        assertTrue(resultado);
        assertEquals(500.0, caja.getSaldo());
        assertEquals(2, caja.getOperaciones()); // 1 por agregar, 1 por quitar
    }

    @Test
    void testQuitarSaldoMayorAlDisponible() {
        caja.agregarSaldo(300.0);
        boolean resultado = caja.quitarSaldo(500.0);
        assertFalse(resultado);
        assertEquals(300.0, caja.getSaldo());
        assertEquals(1, caja.getOperaciones()); // solo se cuenta el agregar
    }

    @Test
    void testQuitarSaldoConMontoNegativo() {
        boolean resultado = caja.quitarSaldo(-100.0);
        assertFalse(resultado);
        assertEquals(0.0, caja.getSaldo());
        assertEquals(0, caja.getOperaciones());
    }
}
