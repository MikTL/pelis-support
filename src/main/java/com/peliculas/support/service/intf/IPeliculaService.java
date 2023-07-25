package com.peliculas.support.service.intf;

import com.peliculas.support.model.Pelicula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPeliculaService {
    Page<Pelicula> listarPeliculas(Pageable pageable);
    public Pelicula registrarPelicula( Pelicula pelicula);
    Pelicula buscarPeliculaPorId(Long id);
    Pelicula actualizarPelicula(Pelicula peliculaActualizada);
    public boolean eliminarPelicula(Long id);
}
