
package com.portafolio.MarianaPena.controller;

import com.portafolio.MarianaPena.model.Proyecto;
import com.portafolio.MarianaPena.service.IProyectoService;
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
public class ProyectoController {
    
    @Autowired
    private IProyectoService interProyecto;
    
    @GetMapping ("/proyectos/traer")
    public List<Proyecto> getProyecto(){
        return interProyecto.getProyectos();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/proyectos/crear")
    public String crearProyectos(@RequestBody Proyecto proy){
        interProyecto.saveProyecto(proy);
        return "El item proyecto fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/proyectos/borrar/{id}")
    public String deleteProyecto (@PathVariable Long id){
        interProyecto.deleteProyecto(id);
        return "El item proyecto fue eliminado correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("proyectos/editar/{id}")
    public Proyecto editProyecto (@PathVariable Long id,
                                @RequestParam ("nombre") String nuevoNombre,
                                @RequestParam ("fecha") String nuevoFecha,
                                @RequestParam ("link") String nuevoLink,
                                @RequestParam ("descripcion") String nuevaDescripcion){
        Proyecto proy = interProyecto.findProyecto(id);
        proy.setNombre(nuevoNombre);
        proy.setFecha(nuevoFecha);
        proy.setLink(nuevoLink);
        proy.setDescripcion(nuevaDescripcion);
    
        interProyecto.saveProyecto(proy);
        return proy;
    }  
}