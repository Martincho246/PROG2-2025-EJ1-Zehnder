import DTO.CuentaCorrienteDto;
import DTO.CuentaCorrienteDtoBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuentaCorrienteDtoBuilderTest {
    @Test
    void testBuildConTodosLosValores() {
        double saldoEsperado = 2300.50;
        int operacionesEsperadas = 35;
        double giroEsperado = 750.20;
        CuentaCorrienteDtoBuilder builder = new CuentaCorrienteDtoBuilder()
                .withSaldo(saldoEsperado)
                .withOperaciones(operacionesEsperadas)
                .withGiroDescubierto(giroEsperado);
        CuentaCorrienteDto dto = builder.build();
        assertEquals(saldoEsperado, dto.getSaldo());
        assertEquals(operacionesEsperadas, dto.getOperaciones());
        assertEquals(giroEsperado, dto.getGiroDescubierto());
    }
}
