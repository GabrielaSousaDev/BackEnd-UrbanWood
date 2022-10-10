package br.sc.senac.urbanwood.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WoodworkRepository extends JpaRepository<Long, Id>{
	 boolean existsByCnpj(String cnpj);

	    boolean existsByLogin(String login);

	  
}
