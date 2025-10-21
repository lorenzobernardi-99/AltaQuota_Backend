package com.altaquota.gestionale.repository;

import com.altaquota.gestionale.entity.Baita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaitaRepository extends JpaRepository<Baita, Long> {
    // Spring Data JPA crea automaticamente i metodi CRUD
}