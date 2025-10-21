package com.altaquota.gestionale.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "baite")
@Data // (di Lombok)
public class Baita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Lob // Tipo di dato per grandi testi
    @Column(columnDefinition = "TEXT")
    private String descrizione;

    @Column(name = "capienza_max")
    private Integer capienzaMax;

    @Column(name = "prezzo_base", precision = 8, scale = 2)
    private BigDecimal prezzoBase;
}