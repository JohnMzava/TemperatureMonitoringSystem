package org.example.temperaturemonitoringsystem.controller;

import org.example.temperaturemonitoringsystem.service.ArrayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/arrays")
public class ArrayController {

    @Autowired
    private ArrayService arrayService;

    // 1D Array endpoint
    @PostMapping("/temperature")
    public ResponseEntity<?> analyzeTemperatures(@RequestBody double[] temperatures) {
        try {
            return ResponseEntity.ok(arrayService.analyzeTemperatures(temperatures));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 2D Array endpoint
    @PostMapping("/transpose")

    public int[][] transposeMatrix(@RequestBody int[][] matrix) {

        return arrayService.transposeMatrix(matrix);
    }
    }
