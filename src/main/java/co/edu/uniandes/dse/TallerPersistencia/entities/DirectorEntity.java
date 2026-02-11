package co.edu.uniandes.dse.TallerPersistencia.entities;


import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity

public class DirectorEntity extends BaseEntity {

    private String nombre;

    private String biografia;

    @OneToMany(mappedBy = "director" )
    
    List<PeliculaEntity> peliculas;
}
