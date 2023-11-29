package com.example.Data;

import com.example.Dominio.Individuo;
import org.springframework.data.repository.CrudRepository;

public interface IndividuoDAO extends CrudRepository<Individuo, Long> {
}