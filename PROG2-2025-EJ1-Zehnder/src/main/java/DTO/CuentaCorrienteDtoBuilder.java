package DTO;

public class CuentaCorrienteDtoBuilder {
    private double saldo;
    private int operaciones;
    private double giroDescubierto;

    public CuentaCorrienteDtoBuilder withSaldo(double saldo) {
        this.saldo = saldo;
        return this;
    }

    public CuentaCorrienteDtoBuilder withOperaciones(int operaciones) {
        this.operaciones = operaciones;
        return this;
    }

    public CuentaCorrienteDtoBuilder withGiroDescubierto(double giro) {
        this.giroDescubierto = giro;
        return this;
    }

    public CuentaCorrienteDto build() {
        CuentaCorrienteDto dto = new CuentaCorrienteDto();
        dto.setSaldo(saldo);
        dto.setOperaciones(operaciones);
        dto.setGiroDescubierto(giroDescubierto);
        return dto;
    }
}
