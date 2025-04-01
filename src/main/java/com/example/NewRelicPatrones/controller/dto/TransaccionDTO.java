package com.example.NewRelicPatrones.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransaccionDTO {
    private int origen;
    private int destino;
    private int monto;
}