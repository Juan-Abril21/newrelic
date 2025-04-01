package com.example.NewRelicPatrones.db.jpa;

import com.example.NewRelicPatrones.db.orm.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionJPA extends JpaRepository<Transaccion, Integer> {
}

