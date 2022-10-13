package br.sc.senac.urbanwood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.senac.urbanwood.model.User;
import br.sc.senac.urbanwood.projection.UserProjection;

public interface UserRepository extends JpaRepository<User, Long> {
	/*
	boolean existsById(Long id);

	boolean existsByLogin(String login);

	User save(UserProjection user);*/
}
