package co.edu.uniandes.dse.TallerPersistencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.TallerPersistencia.entities.PeliculaEntity;
import co.edu.uniandes.dse.TallerPersistencia.repositories.PeliculaRepository;
import lombok.extern.slf4j.Slf4j;


@Slf4j

@Service
public class PeliculaService {

@Autowired
private PeliculaRepository peliculaRepository;

public PeliculaEntity createPelicula(PeliculaEntity pelicula) { 

    if (pelicula.getTitulo().isEmpty()) {
        throw new IllegalArgumentException("El título de la película no puede ser nulo o vacío.");
    }if (peliculaRepository.findByTitulo(pelicula.getTitulo()).size() > 0) {
        throw new IllegalArgumentException("Ya existe una película con el mismo título.");
    }if (pelicula.getAnioLanzamiento()<=1930){
        throw new IllegalArgumentException("El año de lanzamiento debe ser mayor a 1930.");
    }
    return peliculaRepository.save(pelicula);


}


}
