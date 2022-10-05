package br.sc.senac.urbanwood.repository;

import java.util.Optional;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ContactRepository extends JpaRepository<Long, Id>{
	
	 Optional<ContactProjection> findContactById(Long id);

	    Optional<ContactProjection> findContactByEmail(String email);

	    Optional<ContactProjection> findContactByPhoneNumber(String phoneNumber);

	    boolean existsByEmail(String email);

	    boolean existsByPhoneNumber(String phoneNumber);
}
