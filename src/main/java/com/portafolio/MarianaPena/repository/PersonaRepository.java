
package com.portafolio.MarianaPena.repository;

import com.portafolio.MarianaPena.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona,Long>{
    
}
