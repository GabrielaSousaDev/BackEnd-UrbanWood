package br.sc.senac.urbanwood.mapper;

import br.sc.senac.urbanwood.dto.contact.ContactDTO;
import br.sc.senac.urbanwood.model.Contact;
import org.springframework.stereotype.Service;

@Service
public class ContactMapper {

	public ContactDTO toDTO(Contact contact) {
        return new ContactDTO(contact.getId(), contact.getEmail(), contact.getPhoneNumber(), contact.getNetWork());
    }
    public Contact toEntity(ContactDTO dto) {
        return new Contact(dto.id(), dto.email(), dto.phoneNumber(), dto.network());
    }

}

