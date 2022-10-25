package br.sc.senac.urbanwood.service.contact;

import br.sc.senac.urbanwood.dto.adress.AddressDTO;
import br.sc.senac.urbanwood.dto.contact.ContactDTO;
import br.sc.senac.urbanwood.exception.address.AddressNotFoundException;
import br.sc.senac.urbanwood.exception.contact.ContactEmailRegisteredException;
import br.sc.senac.urbanwood.exception.contact.ContactNotFoundException;
import br.sc.senac.urbanwood.mapper.ContactMapper;
import br.sc.senac.urbanwood.model.Address;
import br.sc.senac.urbanwood.model.Contact;
import br.sc.senac.urbanwood.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactServiceImpl(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    public ContactDTO save(ContactDTO contactDTO) {
        Contact contactSaved = contactRepository.save(contactMapper.toEntity(contactDTO));
        return contactMapper.toDTO(contactSaved);
    }

    public void update(ContactDTO contactDTO, Long id) {

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact " + id + " was not found"));

        if (contactDTO.email().equals(contact.getEmail())) {
            contact.setEmail(contactDTO.email());
            contact.setPhoneNumber(contactDTO.phoneNumber());
            return;
        }

        contact.setEmail(contactDTO.email());
        contact.setPhoneNumber(contactDTO.phoneNumber());
        contactRepository.save(contact);
    }

    public void delete(Long id) {
        if (!contactRepository.existsById(id))
            throw new ContactNotFoundException("Contact " + id + " was not found");
        contactRepository.deleteById(id);
    }


    public ContactDTO findContactById(Long id) {
        ContactDTO dto = (ContactDTO) contactRepository.findContactById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contato " + id + " was not found"));
        return dto;
    }
}