package br.sc.senac.urbanwood.repository;

import java.util.Optional;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ImageRepository extends JpaRepository<Long, Id> {
	
	 Optional<ImageModel> findImageById(Long id);

	    Optional<ImageModel> findImageByName(String name);
}
