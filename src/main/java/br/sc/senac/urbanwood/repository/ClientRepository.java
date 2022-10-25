package br.sc.senac.urbanwood.repository;

import br.sc.senac.urbanwood.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ClientRepository  extends JpaRepository<Client, Long> {
}