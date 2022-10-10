package br.sc.senac.urbanwood.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ContactRepository extends JpaRepository<Long, Id>{
	
	
	    boolean existsByEmail(String email);

	    boolean existsByPhoneNumber(String phoneNumber);
}
