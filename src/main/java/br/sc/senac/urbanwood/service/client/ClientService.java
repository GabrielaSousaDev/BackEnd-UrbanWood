package br.sc.senac.urbanwood.service.client;

import java.util.List;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.client.AllClientDTO;
import br.sc.senac.urbanwood.projection.client.ClientProjection;

@Service
public interface ClientService {

    AllClientDTO save(AllClientDTO dto);

    void update(AllClientDTO dto, Long id);

    void delete(Long id);

    AllClientDTO findById(Long id);
    
    List<ClientProjection> findAll();
/*
    ClientProjection findByCpf(String cpf);

    List<ClientProjection> findByNameClient(String nameClient);

    //Screen

    Page<ClientProjectionW9> findW9ByNameClient(Pageable pageable, Integer page);

    ClientProjectionW10 findW10ById(Long id);

    ClientProjectionC13 findC13ById(Long id);

    ClientProjectionC6 findC6ById(Long id);

    ClientProjectionC7 findC7ById(Long id);*/
}