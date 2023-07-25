package com.peliculas.support.service.impl;

import com.peliculas.support.model.Pelicula;
import com.peliculas.support.model.dto.PeliculaDTO;
import com.peliculas.support.service.intf.IPeliculaService;
import com.peliculas.support.service.intf.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class PeliculaService implements IPeliculaService{
    @Autowired
    private PeliculaRepository peliRepo;
    @Override
    public Page<Pelicula> listarPeliculas(Pageable pageable){
        return peliRepo.findAll(pageable) ;
    }
    @Override
    public Pelicula registrarPelicula( Pelicula pelicula) {
        Pelicula nuevaPelicula = peliRepo.save(pelicula);
        return nuevaPelicula;
    }
    @Override
    public Pelicula buscarPeliculaPorId(Long id) {
         Optional<Pelicula>pelicula = peliRepo.findById(id);
         if(pelicula.isPresent()){
            return pelicula.get();
         }else{
             return null;
         }
    }
    @Override
    public Pelicula actualizarPelicula(Pelicula peliculaActualizada) {
        Pelicula peliculaExistente = buscarPeliculaPorId(peliculaActualizada.getIdPelicula());
        if (peliculaExistente!=null) {

            Pelicula peliculaActual = peliculaExistente;
            peliculaActual.setTitulo(peliculaActualizada.getTitulo());
            peliculaActual.setDescripcion(peliculaActualizada.getDescripcion());
            peliculaActual.setAnio(peliculaActualizada.getAnio());
            peliculaActual.setMinutosDuracion(peliculaActualizada.getMinutosDuracion());
            Pelicula peliculaActualizadaGuardada = peliRepo.save(peliculaActual);

            return peliculaActualizadaGuardada;

        } else {
            return null;
        }
    }
    @Override
    public boolean eliminarPelicula(Long id) {
        Pelicula peliculaAEliminar = buscarPeliculaPorId(id);
        if (peliculaAEliminar!=null) {
            peliRepo.delete(peliculaAEliminar);
            return true;
        } else {
            return false;
        }
    }
}
