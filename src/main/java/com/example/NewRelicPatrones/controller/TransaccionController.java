package com.example.NewRelicPatrones.controller;

import com.example.NewRelicPatrones.controller.dto.TransaccionDTO;
import com.example.NewRelicPatrones.db.orm.Transaccion;
import com.example.NewRelicPatrones.services.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;

    @PostMapping("/transferir")
    public ResponseEntity<String> transferir(@RequestBody TransaccionDTO request) {
        try {
            transaccionService.transferir(
                    request.getOrigen(),
                    request.getDestino(),
                    request.getMonto()
            );
            return ResponseEntity.ok("Transferencia exitosa");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}