
package com.portafolio.MarianaPena.service;

import com.portafolio.MarianaPena.model.Educacion;
import com.portafolio.MarianaPena.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EducacionService implements IEducacionService{
    @Autowired
    private EducacionRepository eduRepository;
    
    @Override
    public List<Educacion> getEducaciones(){
        List<Educacion> listaEducaciones = eduRepository.findAll();
        return listaEducaciones;
    }
    
    @Override
    public void saveEducacion(Educacion edu){
        eduRepository.save(edu);
    }
    
    @Override
    public void deleteEducacion(Long id){
        eduRepository.deleteById(id);
    }
    
    @Override
    public Educacion findEducacion(Long id){
        Educacion edu = eduRepository.findById(id).orElse(null);
        return edu;
    }
     
}
