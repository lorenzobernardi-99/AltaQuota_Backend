package com.altaquota.gestionale.controller;

import com.altaquota.gestionale.entity.Baita;
import com.altaquota.gestionale.repository.BaitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/baite")
public class BaitaController {

    @Autowired
    private BaitaRepository baitaRepository;

    @GetMapping
    public List<Baita> getAllBaite() {
        // Questo endpoint sarà usato dal Frontend
        return baitaRepository.findAll();
    }
}