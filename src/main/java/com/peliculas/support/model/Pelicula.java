package com.peliculas.support.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PELICULA")
@Data
public class Pelicula {

    @Id
    @Column(name = "IDPELICULA")
    private Long idPelicula;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "AÑO")
    private Integer anio;

    @Column(name = "MINUTOSDURACION")
    private Integer minutosDuracion;

    @Column(name = "DESCRIPCION")
    private String descripcion;
}
