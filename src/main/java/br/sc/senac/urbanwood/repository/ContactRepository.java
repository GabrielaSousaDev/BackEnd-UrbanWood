package br.sc.senac.urbanwood.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.urbanwood.dto.ContactDTO;
import br.sc.senac.urbanwood.model.Contact;
import br.sc.senac.urbanwood.projection.ClientBasicForSearchProjection.UserProjection.ContactProjection;

@Repository
public interface ContactRepository extends JpaRepository<Long, Id> {

	boolean existsById(Long id);

	boolean existsByEmail(String email);

	ContactProjection findByWoodworkPhoneNumber(String phoneNumberWoodwork);

	ContactProjection findById(Long id);

	ContactDTO save(ContactDTO contactDTO);

}
