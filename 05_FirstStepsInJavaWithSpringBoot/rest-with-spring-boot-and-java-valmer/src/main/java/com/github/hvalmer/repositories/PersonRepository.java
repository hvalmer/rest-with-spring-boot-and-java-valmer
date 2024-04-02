package com.github.hvalmer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.hvalmer.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {}
