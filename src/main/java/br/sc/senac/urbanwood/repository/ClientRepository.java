package br.sc.senac.urbanwood.repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface  ClientRepository  extends JpaRepository<Long, Id>{
	
	boolean existsByCpf(String cpf);

    boolean existsByLogin(String login);

    Optional<ClientProjection> findClientById(Long id);

    Optional<ClientProjection> findClientByCpf(String cpf);

    List<ClientProjection> findClientByNameClient(String nameClient);

    //Screen

    @Query(value = """
            select c.id as id, c.image as image, c.nameClient as nameClient, c.lastName as lastName,
            a.neighborhood as neighborhood, a.city as city,
            co.phoneNumber as phoneNumber
            from Client c
            inner join Address a on c.id = a.id
            inner join Contact co on c.id = co.id
            """)
    Page<ClientProjectionW9> findClientW9ByNameClient(Pageable pageable);

    Optional<ClientProjectionW10> findClientW10ById(Long id);

    Optional<ClientProjectionC13> findClientC13ById(Long id);

    Optional<ClientProjectionC6> findClientC6ById(Long id);

    Optional<ClientProjectionC7> findClientC7ById(Long id);
}
