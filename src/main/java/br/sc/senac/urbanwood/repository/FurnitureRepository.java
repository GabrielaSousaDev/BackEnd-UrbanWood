package br.sc.senac.urbanwood.repository;

import br.sc.senac.urbanwood.model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Long>{}
