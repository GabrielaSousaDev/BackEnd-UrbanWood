package br.sc.senac.urbanwood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.sc.senac.urbanwood.model.Client;
import br.sc.senac.urbanwood.projection.client.ClientProjection;
@Repository
public interface  ClientRepository  extends JpaRepository<Client, Long>{
	/*
	boolean existsByCpf(String cpf);

    boolean existsByLogin(String login);

   
  /*  @Query(value = """
            select c.id as id, c.image as image, c.nameClient as nameClient, c.lastName as lastName,
            a.neighborhood as neighborhood, a.city as city,
            co.phoneNumber as phoneNumber
            from Client c
            inner join Address a on c.id = a.id
            inner join Contact co on c.id = co.id
            """)*/
    
    //Page<ClientProjectionW9> findClientW9ByNameClient(Pageable pageable);

	@Query(value = "SELECT c.cpf AS cpf, c.firstName AS firstName, c.lastName AS lastName FROM Client c")
	List<ClientProjection> findClients();
}
