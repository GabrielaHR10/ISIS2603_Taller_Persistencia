package co.edu.uniandes.dse.TallerPersistencia.entities;


import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity

public class ActorEntity extends BaseEntity {

    private String nombre;

    private String nacionalidad;

    @ManyToMany
    List<PeliculaEntity> peliculas;

}
