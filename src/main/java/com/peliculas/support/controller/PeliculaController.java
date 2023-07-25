package com.peliculas.support.controller;

import com.peliculas.support.model.Pelicula;
import com.peliculas.support.model.dto.PeliculaDTO;
import com.peliculas.support.service.intf.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    private IPeliculaService peliService;

    @GetMapping
    public ResponseEntity<Page<PeliculaDTO>> listarPeliculas(@PageableDefault(size = 3)Pageable pageable){
        return ResponseEntity.ok(peliService.listarPeliculas(pageable).map(PeliculaDTO::new)) ;
    }
    @GetMapping ("/{id}")
    public ResponseEntity<PeliculaDTO> peliculaPorId(@PathVariable Long id){
        Pelicula pelicula= peliService.buscarPeliculaPorId(id);
        return pelicula != null ? ResponseEntity.ok(new PeliculaDTO(pelicula)) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Pelicula> registrarPelicula(
            @RequestBody Pelicula pelicula,
            UriComponentsBuilder uriComponentsBuilder)
    {
        Pelicula nuevaPelicula = peliService.registrarPelicula(pelicula);
        URI uri = uriComponentsBuilder.path("/peliculas/{id}").buildAndExpand(nuevaPelicula.getIdPelicula()).toUri();
        return ResponseEntity.created(uri).body(nuevaPelicula);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<Pelicula> actualizarPelicula(@RequestBody Pelicula peliculaActualizada) {
        Pelicula pelicula= peliService.actualizarPelicula(peliculaActualizada);
        if(pelicula!=null){
            return ResponseEntity.ok(pelicula);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity borrarPelicula(@PathVariable Long id){
        boolean peliBorrada= peliService.eliminarPelicula(id);
        if(peliBorrada) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
