
package com.portafolio.MarianaPena.controller;

import com.portafolio.MarianaPena.model.Skill;
import com.portafolio.MarianaPena.service.ISkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SkillController{

    @Autowired
    private ISkillService interSkill;
    
    @GetMapping ("/skills/traer")
    public List<Skill> getSkill(){
        return interSkill.getSkills();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/skills/crear")
    public String crearSkills(@RequestBody Skill sk){
        interSkill.saveSkill(sk);
        return "La skill fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/skills/borrar/{id}")
    public String deleteSkill (@PathVariable Long id){
        interSkill.deleteSkill(id);
        return "La skill fue eliminada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("skills/editar/{id}")
    public Skill editSkill (@PathVariable Long id,
                                @RequestParam ("nombre") String nuevoNombre,
                                @RequestParam ("porcentaje") int nuevoPorcentaje){
        Skill sk = interSkill.findSkill(id);
        sk.setNombre(nuevoNombre);
        sk.setPorcentaje(nuevoPorcentaje);
    
        interSkill.saveSkill(sk);
        return sk;
    }  
}