package com.peliculas.support.service.intf;

import com.peliculas.support.model.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpinionRepository extends JpaRepository<Opinion,Long> {
}
