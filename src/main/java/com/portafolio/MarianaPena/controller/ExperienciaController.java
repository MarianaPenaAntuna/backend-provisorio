 
package com.portafolio.MarianaPena.controller;

import com.portafolio.MarianaPena.model.Experiencia;
import com.portafolio.MarianaPena.service.IExperienciaService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/experiencias")
public class ExperienciaController {

    @Autowired
    private IExperienciaService interExperiencia;
    
    @GetMapping ("/traer")
    public List<Experiencia> getExperiencia(){
        return interExperiencia.getExperiencias();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String crearExperiencias(@RequestBody Experiencia exp){
        interExperiencia.saveExperiencia(exp);
        return "Un nuevo item de experiencia laboral fue creado correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/borrar/{id}")
    public String deleteExperiencia (@PathVariable Long id){
        interExperiencia.deleteExperiencia(id);
        return "El item de experiencia laboral seleccionado fue eliminado correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping ("/{id}")
    public Experiencia getExperiencia(@PathVariable Long id){
        return interExperiencia.findExperiencia(id);
    }
   
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/editar/{id}")
    public Experiencia editExperiencia (@PathVariable Long id,
                                @RequestParam ("lugar") String nuevoLugar,
                                @RequestParam ("puesto") String nuevoPuesto,
                                @RequestParam ("imagen") String nuevaImagen,
                                @RequestParam ("fecha") String nuevaFecha,
                                @RequestParam ("descripcion") String nuevaDescripcion){
        Experiencia experiencia = interExperiencia.findExperiencia(id);
        experiencia.setLugar(nuevoLugar);
        experiencia.setPuesto(nuevoPuesto);
        experiencia.setImagen(nuevaImagen);
        experiencia.setFecha(nuevaFecha);
        experiencia.setDescripcion(nuevaDescripcion);
        interExperiencia.saveExperiencia(experiencia);
        return experiencia;
    }  
}