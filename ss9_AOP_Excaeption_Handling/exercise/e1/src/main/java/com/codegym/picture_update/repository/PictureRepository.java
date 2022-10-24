package com.codegym.picture_update.repository;

import com.codegym.picture_update.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface PictureRepository extends JpaRepository<Picture, Integer> {
    Optional<Picture> find(LocalDate toLocalDate);
}
