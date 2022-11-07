package com.codegym.furama.repository;

import com.codegym.furama.model.ServiceFurama;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ServiceRepository extends JpaRepository<Integer, ServiceFurama> {

}
