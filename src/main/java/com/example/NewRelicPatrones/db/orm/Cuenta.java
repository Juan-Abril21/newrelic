package com.example.NewRelicPatrones.db.orm;

@Entity
public class Cuenta {
    @Id
    private String idCuenta;

    private BigDecimal monto;

    // Getters y setters
}
