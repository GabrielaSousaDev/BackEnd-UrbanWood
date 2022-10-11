package br.sc.senac.urbanwood.service.user;

import br.sc.senac.urbanwood.dto.UserDTO;
import br.sc.senac.urbanwood.exception.contact.ContactEmailRegisteredException;
import br.sc.senac.urbanwood.exception.contact.ContactNotFoundException;
import br.sc.senac.urbanwood.mapper.UserMapper;
import br.sc.senac.urbanwood.model.User;
import br.sc.senac.urbanwood.projection.UserProjection;
import br.sc.senac.urbanwood.repository.UserRepository;

public class UserServiceImpl {

	private final UserRepository userRepository;
	private final UserMapper userMapper;

	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	public UserDTO save(UserDTO userDTO) {

		if (userRepository.existsById(userDTO.id()))
			throw new ContactEmailRegisteredException("User id " + userDTO.id() + " is already registered");

		User user = userMapper.toEntity(userDTO);
		User userSaved = userRepository.save(user);
		return userMapper.toDTO(userSaved);
	}
	
	public void update(UserDTO userDTO, Long id) {

		UserProjection user = userRepository.findById(id)
				.orElseThrow(() -> new ContactNotFoundException("User" + id + " was not found"));

		if (userDTO.id().equals(user.getId())) {
			user.setLogin(userDTO.login());
			user.setPassword(userDTO.password());
			return;
		}

		if (contactRepository.existsByEmail(contactDTO.email()))
			throw new ContactEmailRegisteredException("Email " + contactDTO.email() + " is already registered");

		contact.setEmail(contactDTO.email());
		contact.setPhoneNumber(contactDTO.phoneNumber());
		contact.setSocialNetwork(contactDTO.socialNetwork());
		contactRepository.save(contact);
	}
	

}
