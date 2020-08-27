package com.expedientes.expedientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expedientes.expedientes.entity.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
