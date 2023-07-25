package com.peliculas.support.service.intf;

import com.peliculas.support.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PeliculaRepository extends JpaRepository<Pelicula,Long> {
}
