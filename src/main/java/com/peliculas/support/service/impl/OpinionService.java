package com.peliculas.support.service.impl;

import com.peliculas.support.model.Opinion;
import com.peliculas.support.model.Pelicula;
import com.peliculas.support.model.Usuario;
import com.peliculas.support.service.intf.IOpinionService;
import com.peliculas.support.service.intf.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

@Service
public class OpinionService implements IOpinionService {
    @Autowired
    private OpinionRepository opinionRepo;
    @Override
    public Page<Opinion> listarOpiniones(Pageable pageable) {
        return null;
    }

    @Override
    public Opinion buscarOpinionPorId(Long id) {
        return null;
    }

    @Override
    public Opinion registrarOpinion(Opinion opinion) {
        return null;
    }

    @Override
    public Opinion actualizarOpinion(Opinion opinionActualizada) {
        return null;
    }

    @Override
    public boolean eliminarOpinion(Long id) {
        return false;
    }

    @Override
    public List<Opinion> buscarOpinionesPorPelicula(Pelicula pelicula) {
        return null;
    }

    @Override
    public List<Opinion> buscarOpinionesPorUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public List<Opinion> buscarOpinionesPorPuntuacion(Integer puntuacion) {
        return null;
    }

    @Override
    public List<Opinion> buscarOpinionesPorFecha(Date fecha) {
        return null;
    }
}
