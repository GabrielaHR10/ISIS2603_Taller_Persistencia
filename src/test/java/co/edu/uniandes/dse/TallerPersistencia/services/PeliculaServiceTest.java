package co.edu.uniandes.dse.TallerPersistencia.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.TallerPersistencia.entities.PeliculaEntity;
import co.edu.uniandes.dse.TallerPersistencia.services.PeliculaService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(PeliculaService.class)
@Transactional

public class PeliculaServiceTest {

    @Autowired 
    PeliculaService peliculaService;

    @Autowired
    EntityManager entityManager;

    private PodamFactory factory = new PodamFactoryImpl();

    private List <PeliculaEntity> listaPeliculas = new ArrayList<>(); 


     @Test
    void testCreatePeliculaOK(){

        PeliculaEntity peliculaEntity = factory.manufacturePojo(PeliculaEntity.class);
        PeliculaEntity result = peliculaService.createPelicula(peliculaEntity);
        assertNotNull(result);
        assertEquals(   peliculaEntity.getTitulo(), result.getTitulo());
        assert !peliculaEntity.getTitulo().isEmpty();
        assertEquals(   peliculaEntity.getAnioLanzamiento(), result.getAnioLanzamiento());
        assert peliculaEntity.getAnioLanzamiento() > 1930;
        assert listaPeliculas.stream().filter(p -> p.getTitulo().equals(peliculaEntity.getTitulo())).count() == 0;

    }

    @Test

    void testCreatePeliculaAnoMal(){

        PeliculaEntity peliculaEntity = factory.manufacturePojo(PeliculaEntity.class);
        peliculaEntity.setAnioLanzamiento(1900);
        try {
            peliculaService.createPelicula(peliculaEntity);
        } catch (IllegalArgumentException e) {
            assert e.getMessage().contains("El año de lanzamiento debe ser mayor a 1930.");
        }
    }
}