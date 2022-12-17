
package com.portafolio.MarianaPena.service;

import com.portafolio.MarianaPena.model.Proyecto;
import java.util.List;

public interface IProyectoService {
    
    public List<Proyecto> getProyectos();
    public void saveProyecto (Proyecto proy);
    public void deleteProyecto (Long id);
    public Proyecto findProyecto (Long id);
    
}