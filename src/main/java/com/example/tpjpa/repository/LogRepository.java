package com.example.tpjpa.repository;

import com.example.tpjpa.model.Logs;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<Logs, Integer> {
}
