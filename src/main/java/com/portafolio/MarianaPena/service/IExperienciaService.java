
package com.portafolio.MarianaPena.service;

import com.portafolio.MarianaPena.model.Experiencia;
import java.util.List;

public interface IExperienciaService {
    public List<Experiencia> getExperiencias();
    public void saveExperiencia (Experiencia exp);
    public void deleteExperiencia (Long id);
    public Experiencia findExperiencia (Long id);
   
}
