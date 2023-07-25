package com.peliculas.support.service.intf;

import com.peliculas.support.model.Opinion;
import com.peliculas.support.model.Pelicula;
import com.peliculas.support.model.Usuario;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

public interface IOpinionService {
    Page<Opinion> listarOpiniones(Pageable pageable);

    Opinion buscarOpinionPorId(Long id);

    Opinion registrarOpinion(Opinion opinion);

    Opinion actualizarOpinion(Opinion opinionActualizada);

    boolean eliminarOpinion(Long id);

    List<Opinion> buscarOpinionesPorPelicula(Pelicula pelicula);

    List<Opinion> buscarOpinionesPorUsuario(Usuario usuario);

    List<Opinion> buscarOpinionesPorPuntuacion(Integer puntuacion);

    List<Opinion> buscarOpinionesPorFecha(Date fecha);
}
