
package com.portafolio.MarianaPena.controller;

import com.portafolio.MarianaPena.model.Educacion;
import com.portafolio.MarianaPena.service.IEducacionService;
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
public class EducacionController {

    @Autowired
    private IEducacionService interEducacion;
    
    @GetMapping ("/educaciones/traer")
    public List<Educacion> getEducacion(){
        return interEducacion.getEducaciones();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/educaciones/crear")
    public String crearEducaciones(@RequestBody Educacion edu){
        interEducacion.saveEducacion(edu);
        return "Un nuevo item educación fue creado correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")    
    @DeleteMapping ("/educaciones/borrar/{id}")
    public String deleteEducacion (@PathVariable Long id){
        interEducacion.deleteEducacion(id);
        return "El item de educación seleccionado fue eliminado correctamente";
    }
   
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("educaciones/editar/{id}")
    public Educacion editEducacion (@PathVariable Long id,
                                @RequestParam ("lugar") String nuevoLugar,
                                @RequestParam ("curso") String nuevoCurso,
                                @RequestParam ("imagen") String nuevaImagen,
                                @RequestParam ("fecha") String nuevaFecha,
                                @RequestParam ("descripcion") String nuevaDescripcion){
        Educacion edu = interEducacion.findEducacion(id);
        edu.setLugar(nuevoLugar);
        edu.setCurso(nuevoCurso);
        edu.setImagen(nuevaImagen);
        edu.setFecha(nuevaFecha);
        edu.setDescripcion(nuevaDescripcion);
        interEducacion.saveEducacion(edu);
        return edu;
    }  
}
