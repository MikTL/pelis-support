package com.peliculas.support.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OPINION")
@Data
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDOPINION")
    private Long idOpinion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPELICULA")
    private Pelicula pelicula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDUSUARIO")
    private Usuario usuario;

    @Column(name = "OPINION")
    private String opinion;

    @Column(name = "PUNTUACION")
    private Integer puntuacion;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA")
    private Date fecha;
}