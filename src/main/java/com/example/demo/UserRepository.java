package com.example.demo;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserEntity,String> {
}
