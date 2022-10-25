package br.sc.senac.urbanwood.mapper;

import br.sc.senac.urbanwood.dto.client.ClientDTO;
import br.sc.senac.urbanwood.model.*;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper {
    public ClientDTO toDTO(Client client) {

        return new ClientDTO(client.getIdUser(), client.getLogin(), client.getPassword(),
                client.getAddress(), client.getContact(), client.getCpf(),
                client.getCpf(), client.getLastName(), client.getOrder(), client.getImage());
    }
    public Client toEntity(ClientDTO dto) {
        Client clientEntity = new Client(dto.idUser(), dto.login(), dto.password(),
                dto.address(),dto.contact(),dto.imageProfile(), dto.cpf(), dto.firstName(), dto.lastName(),
                dto.order());
        return clientEntity;
    }
}