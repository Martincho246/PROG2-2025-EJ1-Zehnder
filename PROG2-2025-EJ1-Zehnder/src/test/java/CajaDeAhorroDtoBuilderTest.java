import DTO.CajaDeAhorroDto;
import DTO.CajaDeAhorroDtoBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CajaDeAhorroDtoBuilderTest {
    @Test
    void testBuildConTodosLosValores() {
        double saldoEsperado = 500.75;
        int operacionesEsperadas = 12;
        CajaDeAhorroDtoBuilder builder = new CajaDeAhorroDtoBuilder()
                .withSaldo(saldoEsperado)
                .withOperaciones(operacionesEsperadas);
        CajaDeAhorroDto dto = builder.build();
        assertEquals(saldoEsperado, dto.getSaldo());
        assertEquals(operacionesEsperadas, dto.getOperaciones());
    }
}
