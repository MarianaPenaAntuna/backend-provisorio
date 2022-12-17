
package com.portafolio.MarianaPena.service;

import com.portafolio.MarianaPena.model.Skill;
import com.portafolio.MarianaPena.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillService implements ISkillService{
    @Autowired
    private SkillRepository skRepository;
    
    @Override
    public List<Skill> getSkills(){
        List<Skill> listaSkills = skRepository.findAll();
        return listaSkills;
    }
    
    @Override
    public void saveSkill(Skill sk){
        skRepository.save(sk);
    }
    
    @Override
    public void deleteSkill(Long id){
        skRepository.deleteById(id);
    }
    
    @Override
    public Skill findSkill(Long id){
        Skill sk = skRepository.findById(id).orElse(null);
        return sk;
    }
     
}

    
