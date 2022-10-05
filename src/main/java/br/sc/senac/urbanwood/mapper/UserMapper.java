package br.sc.senac.urbanwood.mapper;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.model.User;

@Service
public class UserMapper {

	public UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getImagem(), user.getLogin(), user.getPassword(), user.getAddress(), user.getContact());
    }

    public User toEntity(UserDTO dto) {
        return new User(dto.id(), dto.image(), dto.login(), dto.password(), dto.address(), dto.contact());
    }

}
