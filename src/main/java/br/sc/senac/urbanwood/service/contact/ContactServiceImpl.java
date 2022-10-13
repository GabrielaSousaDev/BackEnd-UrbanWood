package br.sc.senac.urbanwood.service.contact;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.contact.ContactDTO;
import br.sc.senac.urbanwood.exception.contact.ContactEmailRegisteredException;
import br.sc.senac.urbanwood.exception.contact.ContactNotFoundException;
import br.sc.senac.urbanwood.mapper.ContactMapper;
import br.sc.senac.urbanwood.model.Contact;
import br.sc.senac.urbanwood.projection.ContactProjection;
import br.sc.senac.urbanwood.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	private final ContactRepository contactRepository;
	private final ContactMapper contactMapper;

	public ContactServiceImpl(ContactRepository contactRepository, ContactMapper contactMapper) {
		this.contactRepository = contactRepository;
		this.contactMapper = contactMapper;
	}

	public ContactDTO save(ContactDTO contactDTO) {

		if (contactRepository.existsByEmail(contactDTO.email()))
			throw new ContactEmailRegisteredException("Email " + contactDTO.email() + " is already registered");

		Contact contact = new Contact(contactDTO.id(), contactDTO.email(), contactDTO.phoneNumber(), contactDTO.network());
		Contact contactSaved = contactRepository.save(contact);
		return new ContactDTO(contactSaved.getId(), contactSaved.getEmail(), contactSaved.getPhoneNumber(), contactSaved.getNetWork());
	}

	public void update(ContactDTO contactDTO, Long id) {

		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ContactNotFoundException("Contact " + id + " was not found"));

		if (contactDTO.email().equals(contact.getEmail())) {
			contact.setEmail(contactDTO.email());
			contact.setPhoneNumber(contactDTO.phoneNumber());
			return;
		}

		if (contactRepository.existsByEmail(contactDTO.email()))
			throw new ContactEmailRegisteredException("Email " + contactDTO.email() + " is already registered");

		contact.setEmail(contactDTO.email());
		contact.setPhoneNumber(contactDTO.phoneNumber());
		contactRepository.save(contact);
	}

	public void delete(Long id) {
		if (!contactRepository.existsById(id))
			throw new ContactNotFoundException("Contact " + id + " was not found");
		contactRepository.deleteById(id);
	}

	public ContactProjection findById(Long id) {
		
		ContactProjection contact = contactRepository.findContactById(id).orElseThrow(() -> new ContactNotFoundException("Contact " + id + " was not found")); 
		
		return contact;
	}

		/*public ProfileWoodworkForEditProjection findByWoodworkPhoneNumber(String phoneNumberWoodwork) {
		return contactRepository.findByWoodworkPhoneNumber(phoneNumberWoodwork)
				.orElseThrow(() -> new ContactNotFoundException("Contact " + phoneNumber + " was not found"));
	}*/
}