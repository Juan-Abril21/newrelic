package com.example.NewRelicPatrones.db.orm;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @Column(name = "id_cuenta")
    private Integer idCuenta;

    @Column(name = "monto")
    private Integer monto;

}
