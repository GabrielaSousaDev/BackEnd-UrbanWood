package br.sc.senac.urbanwood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.urbanwood.dto.ContactDTO;
import br.sc.senac.urbanwood.model.Contact;
import br.sc.senac.urbanwood.projection.ClientBasicForSearchProjection.UserProjection.ContactProjection;

@Repository
public interface ContactRepository extends JpaRepository<Contact ,Long> {
/*
	boolean existsById(Long id);

	boolean existsByEmail(String email);

	ContactProjection findByWoodworkPhoneNumber(String phoneNumberWoodwork);

	ContactDTO save(ContactDTO contactDTO);
*/
}
