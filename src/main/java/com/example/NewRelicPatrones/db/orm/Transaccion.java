package com.example.NewRelicPatrones.db.orm;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "transaccion", schema = "parcial")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private Integer idTransaccion;

    @ManyToOne
    @JoinColumn(name = "origen", referencedColumnName = "id_cuenta")
    private Cuenta origen;

    @ManyToOne
    @JoinColumn(name = "destino", referencedColumnName = "id_cuenta")
    private Cuenta destino;

    private Integer monto;
    private LocalDateTime fecha;

}