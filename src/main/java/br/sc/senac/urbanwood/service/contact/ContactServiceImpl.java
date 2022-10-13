package br.sc.senac.urbanwood.service.contact;

import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
/*
	private final ContactRepository contactRepository;
	private final ContactMapper contactMapper;

	public ContactServiceImpl(ContactRepository contactRepository, ContactMapper contactMapper) {
		this.contactRepository = contactRepository;
		this.contactMapper = contactMapper;
	}

	public ContactDTO save(ContactDTO contactDTO) {

		if (contactRepository.existsByEmail(contactDTO.email()))
			throw new ContactEmailRegisteredException("Email " + contactDTO.email() + " is already registered");

		Contact contact = contactMapper.toEntity(contactDTO);
		Contact contactSaved = contactRepository.save(contact);
		return contactMapper.toDTO(contactSaved);
	}

	public void update(ContactDTO contactDTO, Long id) {

		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ContactNotFoundException("Contact " + id + " was not found"));

		if (contactDTO.email().equals(contact.getEmail())) {
			contact.setEmail(contactDTO.email());
			contact.setPhoneNumber(contactDTO.phoneNumber());
			contact.setSocialNetwork(contactDTO.socialNetwork());
			return;
		}

		if (contactRepository.existsByEmail(contactDTO.email()))
			throw new ContactEmailRegisteredException("Email " + contactDTO.email() + " is already registered");

		contact.setEmail(contactDTO.email());
		contact.setPhoneNumber(contactDTO.phoneNumber());
		contact.setSocialNetwork(contactDTO.socialNetwork());
		contactRepository.save(contact);
	}

	public void delete(Long id) {
		if (!contactRepository.existsById(id))
			throw new ContactNotFoundException("Contact " + id + " was not found");
		contactRepository.delete(id);
	}

	public ContactProjection findById(Long id) {
		return contactRepository.findById(id)
				.orElseThrow(() -> new ContactNotFoundException("Contact " + id + " was not found"));
	}

		public ProfileWoodworkForEditProjection findByWoodworkPhoneNumber(String phoneNumberWoodwork) {
		return contactRepository.findByWoodworkPhoneNumber(phoneNumberWoodwork)
				.orElseThrow(() -> new ContactNotFoundException("Contact " + phoneNumber + " was not found"));
	}*/
}