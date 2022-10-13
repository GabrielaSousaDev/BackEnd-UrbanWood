package br.sc.senac.urbanwood.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.urbanwood.dto.contact.ContactDTO;
import br.sc.senac.urbanwood.model.Contact;
import br.sc.senac.urbanwood.projection.ContactProjection;

@Repository
public interface ContactRepository extends JpaRepository<Contact ,Long> {

	Optional<ContactProjection> findContactById(Long id);
	
	boolean existsById(Long id);

	boolean existsByEmail(String email);

	//ContactProjection findByWoodworkPhoneNumber(String phoneNumberWoodwork);

	ContactDTO save(ContactDTO contactDTO);

}
