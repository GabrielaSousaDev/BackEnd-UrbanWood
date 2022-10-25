package br.sc.senac.urbanwood.repository;

import br.sc.senac.urbanwood.dto.adress.AddressDTO;
import br.sc.senac.urbanwood.dto.contact.ContactDTO;
import br.sc.senac.urbanwood.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface ContactRepository extends JpaRepository<Contact ,Long> {
    Optional<Object> findContactById(Long id);

    //Optional<ContactDTO> findContactById(Long id);


}
