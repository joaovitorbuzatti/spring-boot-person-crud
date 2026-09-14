package com.github.joaovitorbuzatti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.joaovitorbuzatti.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{}
