package br.sc.senac.urbanwood.service.contact;
import br.sc.senac.urbanwood.dto.contact.ContactDTO;
import org.springframework.stereotype.Service;

@Service
public interface ContactService {

	void update(ContactDTO contactDTO, Long id);

	void delete(Long id);


}