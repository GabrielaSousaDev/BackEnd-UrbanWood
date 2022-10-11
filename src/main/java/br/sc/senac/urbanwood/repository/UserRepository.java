package br.sc.senac.urbanwood.repository;

import java.util.Optional;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.senac.urbanwood.model.User;
import br.sc.senac.urbanwood.projection.UserProjection;

public interface UserRepository extends JpaRepository<Long, Id> {
	
	boolean existsById(Long id);

	boolean existsByLogin(String login);

	User save(UserProjection user);

	Optional <UserProjection> findById(Long id);
}
