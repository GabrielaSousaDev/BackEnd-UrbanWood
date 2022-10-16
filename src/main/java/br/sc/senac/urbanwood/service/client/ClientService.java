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

}