package com.peliculas.support.model.dto;

import com.peliculas.support.model.Pelicula;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PeliculaDTO {
    private String titulo;
    private Integer anio;
    private Integer minutosDuracion;
    private String descripcion;

    public PeliculaDTO(Pelicula pelicula) {
        this.titulo=pelicula.getTitulo();
        this.anio=pelicula.getAnio();
        this.minutosDuracion= pelicula.getMinutosDuracion();
        this.descripcion=pelicula.getDescripcion();
    }
}
