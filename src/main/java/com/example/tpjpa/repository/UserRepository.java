package com.example.tpjpa.repository;

import com.example.tpjpa.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Integer> {
}
