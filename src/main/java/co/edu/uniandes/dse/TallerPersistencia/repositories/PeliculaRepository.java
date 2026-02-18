package co.edu.uniandes.dse.TallerPersistencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

import co.edu.uniandes.dse.TallerPersistencia.entities.PeliculaEntity;
import java.util.List;


public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Long>{

public List<PeliculaEntity> findByTitulo(String titulo);

}
