
package com.portafolio.MarianaPena.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String lugar;
    private String puesto;
    private String imagen;
    private String fecha;
    private String descripcion;

    public Experiencia() {
    }

    public Experiencia(Long id, String lugar, String puesto, String imagen, String fecha, String descripcion) {
        this.id = id;
        this.lugar = lugar;
        this.puesto = puesto;
        this.imagen = imagen;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

   
    
    
}
