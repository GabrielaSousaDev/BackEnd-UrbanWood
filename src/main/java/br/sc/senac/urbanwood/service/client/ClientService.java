package br.sc.senac.urbanwood.service.client;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.client.AllClientDTO;

@Service
public interface ClientService {

    AllClientDTO save(AllClientDTO dto);

    /*void update(ClientDTO clientDTO, Long id);

    void delete(Long id);

    ProfileClientForEditProjection findById(Long id);

    ClientProjection findByCpf(String cpf);

    List<ClientProjection> findByNameClient(String nameClient);

    //Screen

    Page<ClientProjectionW9> findW9ByNameClient(Pageable pageable, Integer page);

    ClientProjectionW10 findW10ById(Long id);

    ClientProjectionC13 findC13ById(Long id);

    ClientProjectionC6 findC6ById(Long id);

    ClientProjectionC7 findC7ById(Long id);*/
}