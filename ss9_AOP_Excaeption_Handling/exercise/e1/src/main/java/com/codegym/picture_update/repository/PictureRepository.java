package com.codegym.picture_update.repository;

import com.codegym.picture_update.model.Picture;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Transactional
public interface PictureRepository extends JpaRepository<Picture, Integer> {
    Optional<Picture> find(LocalDate toLocalDate);
}
