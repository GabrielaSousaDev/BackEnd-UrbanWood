package br.sc.senac.urbanwood.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

public interface User extends JpaRepository<Long, Id> {}
