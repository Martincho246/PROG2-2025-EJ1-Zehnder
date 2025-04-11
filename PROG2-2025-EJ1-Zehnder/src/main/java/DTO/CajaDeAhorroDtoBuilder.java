package DTO;

public class CajaDeAhorroDtoBuilder {
    private double saldo;
    private int operaciones;

    public CajaDeAhorroDtoBuilder withSaldo(double saldo) {
        this.saldo = saldo;
        return this;
    }

    public CajaDeAhorroDtoBuilder withOperaciones(int operaciones) {
        this.operaciones = operaciones;
        return this;
    }

    public CajaDeAhorroDto build() {
        CajaDeAhorroDto dto = new CajaDeAhorroDto();
        dto.setSaldo(saldo);
        dto.setOperaciones(operaciones);
        return dto;
    }
}
