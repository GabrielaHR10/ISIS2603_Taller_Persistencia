package co.edu.uniandes.dse.TallerPersistencia.entities;



import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity


public class PeliculaEntity extends BaseEntity {

    String titulo; 

    Integer anioLanzamiento;

    @ManyToMany
    List<ActorEntity> actores;

    @ManyToOne
    DirectorEntity director;
}
