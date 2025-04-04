package com.example.NewRelicPatrones.services;

import com.example.NewRelicPatrones.db.jpa.CuentaJPA;
import com.example.NewRelicPatrones.db.jpa.TransaccionJPA;
import com.example.NewRelicPatrones.db.orm.Cuenta;
import com.example.NewRelicPatrones.db.orm.Transaccion;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class TransaccionService {

    @Autowired
    private CuentaJPA cuentaJPA;

    @Autowired
    private TransaccionJPA transaccionJPA;

    @Transactional
    public void transferir(int origen, int destino, int monto) throws Exception {
        Cuenta origenn = cuentaJPA.findByIdForUpdate(origen).orElseThrow(() ->
                new Exception("Cuenta origen no encontrada"));
        Cuenta destinoo = cuentaJPA.findByIdForUpdate(destino).orElseThrow(() ->
                new Exception("Cuenta destino no encontrada"));

        if (origenn.getMonto() < monto) {
            throw new Exception("No hay suficiente dinero");
        }

        origenn.setMonto(origenn.getMonto() - monto);
        destinoo.setMonto(destinoo.getMonto() + monto);

        cuentaJPA.save(origenn);
        cuentaJPA.save(destinoo);

        Transaccion transaccion = new Transaccion();
        transaccion.setOrigen(origenn);
        transaccion.setDestino(destinoo);
        transaccion.setMonto(monto);
        transaccion.setFecha(LocalDateTime.now());

        transaccionJPA.save(transaccion);
    }
}

