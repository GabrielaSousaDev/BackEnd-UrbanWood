package br.sc.senac.urbanwood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.urbanwood.model.Image;
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
	
	
}
