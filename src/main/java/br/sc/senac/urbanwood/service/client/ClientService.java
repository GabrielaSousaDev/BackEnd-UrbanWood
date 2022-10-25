package br.sc.senac.urbanwood.service.client;

import br.sc.senac.urbanwood.dto.client.ClientDTO;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {

    void update(ClientDTO dto, Long id);

    void delete(Long id);

    ClientDTO findById(Long id);
}