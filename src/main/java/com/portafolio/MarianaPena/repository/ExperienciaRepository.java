
package com.portafolio.MarianaPena.repository;

import com.portafolio.MarianaPena.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia,Long>{
    
}

