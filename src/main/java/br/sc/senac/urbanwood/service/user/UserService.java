package br.sc.senac.urbanwood.service.user;

import java.util.Optional;

import br.sc.senac.urbanwood.dto.UserDTO;
import br.sc.senac.urbanwood.projection.UserProjection;

public interface UserService {

	UserDTO save(UserDTO userDTO);

	void update(UserDTO userDTO, Long id);

	void delete(Long id);

	boolean existsById(Long id);

	boolean existsByLogin(String login);

	Optional<UserProjection> findById(Long id);
}
