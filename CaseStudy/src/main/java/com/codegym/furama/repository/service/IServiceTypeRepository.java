package com.codegym.furama.repository.service;

import com.codegym.furama.model.service.RentType;
import com.codegym.furama.model.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}
