
package com.portafolio.MarianaPena.service;

import com.portafolio.MarianaPena.model.Experiencia;
import com.portafolio.MarianaPena.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExperienciaService implements IExperienciaService{
    @Autowired
    private ExperienciaRepository expRepository;
    
    @Override
    public List<Experiencia> getExperiencias(){
        List<Experiencia> listaExperiencias = expRepository.findAll();
        return listaExperiencias;
    }
    
    @Override
    public void saveExperiencia(Experiencia exp){
        expRepository.save(exp);
    }
    
    @Override
    public void deleteExperiencia(Long id){
        expRepository.deleteById(id);
    }
    
    @Override
    public Experiencia findExperiencia(Long id){
        Experiencia exp = expRepository.findById(id).orElse(null);
        return exp;
    }

    
     
}
