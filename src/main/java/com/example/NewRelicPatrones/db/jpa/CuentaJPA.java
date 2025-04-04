package com.example.NewRelicPatrones.db.jpa;

import com.example.NewRelicPatrones.db.orm.Cuenta;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaJPA extends JpaRepository<Cuenta, Integer> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT c FROM Cuenta c WHERE c.idCuenta = :id")
    Optional<Cuenta> findByIdForUpdate(@Param("id") int id);
}

