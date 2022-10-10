package br.sc.senac.urbanwood.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface  ClientRepository  extends JpaRepository<Long, Id>{
	
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

    
}
