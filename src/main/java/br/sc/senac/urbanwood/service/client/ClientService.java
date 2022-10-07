package br.sc.senac.urbanwood.service.client;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.ClientDTO;

@Service
public interface ClientService {

    ClientDTO save(ClientDTO clientDTO);

    void update(ClientDTO clientDTO, Long id);

    void delete(Long id);

    ClientProjection findById(Long id);

    ClientProjection findByCpf(String cpf);

    List<ClientProjection> findByNameClient(String nameClient);

    //Screen

    Page<ClientProjectionW9> findW9ByNameClient(Pageable pageable, Integer page);

    ClientProjectionW10 findW10ById(Long id);

    ClientProjectionC13 findC13ById(Long id);

    ClientProjectionC6 findC6ById(Long id);

    ClientProjectionC7 findC7ById(Long id);
}