
package com.portafolio.MarianaPena.service;

import com.portafolio.MarianaPena.model.Proyecto;
import com.portafolio.MarianaPena.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProyectoService implements IProyectoService {
    @Autowired
    private ProyectoRepository proyRepository;
    
    @Override
    public List<Proyecto> getProyectos(){
        List<Proyecto> listaProyectos = proyRepository.findAll();
        return listaProyectos;
    }
    
    @Override
    public void saveProyecto(Proyecto proy){
        proyRepository.save(proy);
    }
    
    @Override
    public void deleteProyecto(Long id){
        proyRepository.deleteById(id);
    }
    
    @Override
    public Proyecto findProyecto(Long id){
        Proyecto proy = proyRepository.findById(id).orElse(null);
        return proy;
    }
     
}
