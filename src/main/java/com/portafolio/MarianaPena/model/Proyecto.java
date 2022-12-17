
package com.portafolio.MarianaPena.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class Proyecto  {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String fecha;
    private String link;
    private String descripcion;

    public Proyecto() {
    }

    public Proyecto(Long id, String nombre, String fecha, String link, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.link = link;
        this.descripcion = descripcion;
    }
   
}