package com.wirtz.t05ej54.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.wirtz.t05ej54.model.Pais;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaisServiceImpl implements PaisService, CommandLineRunner {

    private List<Pais> paises = new ArrayList<>();

    @Override

public void cargarPaisesDesdeFichero() {
    try {
        List<String> lineas = Files.readAllLines(Paths.get("paises.csv"), StandardCharsets.ISO_8859_1);
        for (String linea : lineas) {
            String[] data = linea.split(";");
            String nombre = data[0].trim();
            String capital = data[1].trim();
            int poblacion = Integer.parseInt(data[2].trim());
            paises.add(new Pais(nombre, capital, poblacion));
        }
        System.out.println("Datos de países cargados correctamente.");
    } catch (Exception e) {
        System.err.println("Error al cargar los datos de países: " + e.getMessage());
    }
}

    @Override
    public List<Pais> getPaises() {
        return paises;
    }

    @Override
    public Pais getPais(String nombre) {
        return paises.stream()
                .filter(pais -> pais.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void run(String... args) throws Exception {
        cargarPaisesDesdeFichero();
    }
}
