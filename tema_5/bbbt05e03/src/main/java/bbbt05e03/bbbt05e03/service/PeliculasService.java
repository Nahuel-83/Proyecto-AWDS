package bbbt05e03.bbbt05e03.service;

import org.springframework.stereotype.Service;

import bbbt05e03.bbbt05e03.FormInfo;

@Service
public interface PeliculasService {
    boolean yaHaVotado (String email);
    boolean votarPelicula (String email, int idPelicula);
    FormInfo obtenerInfoVotos();

    
}
