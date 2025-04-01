package com.example.NewRelicPatrones.db.jpa;

import com.example.NewRelicPatrones.db.orm.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaJPA extends JpaRepository<Cuenta, Integer> {
}

