package com.wirtz.t05ej54.service;

import com.wirtz.t05ej54.model.Pais;
import java.util.List;

public interface PaisService {
    void cargarPaisesDesdeFichero();
    List<Pais> getPaises();
    Pais getPais(String nombre);
}

