package com.fortunadev.enity_crud.repository;

import com.fortunadev.enity_crud.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findByNomeContainingIgnoreCase(String nome);
}
