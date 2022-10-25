package br.sc.senac.urbanwood.service.user;

public class UserServiceImpl {
/*
	private final UserRepository userRepository;
	private final UserMapper userMapper;

	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	public UserDTO save(UserDTO userDTO) {

		if (userRepository.existsById(userDTO.id()))
			throw new UserInvalidException("User id " + userDTO.id() + " is already registered");

		User user = userMapper.toEntity(userDTO);
		User userSaved = userRepository.save(user);
		return userMapper.toDTO(userSaved);
	}
	
	public void update(UserDTO userDTO, Long id) {

		UserProjection user = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User" + id + " was not found"));

		if (userDTO.id().equals(user.getId())) {
			user.setLogin(userDTO.login());
			user.setPassword(userDTO.password());
			return;
		}

		if (userRepository.existsById(userDTO.id()))
			throw new ContactEmailRegisteredException("Email " + userDTO.id() + " is already registered");

		user.setLogin(userDTO.login());
		user.setPassword(userDTO.password());
		userRepository.save(user);
	}
	
	public void delete(Long id) {
		if (!userRepository.existsById(id))
			throw new ContactNotFoundException("User id " + id + " was not found");
		userRepository.delete(id);
	}
	
*/
}
