package br.sc.senac.urbanwood.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WoodworkRepository extends JpaRepository<Long, Id>{
	 boolean existsByCnpj(String cnpj);

	    boolean existsByLogin(String login);

	    Optional<WoodworkProjection> findWoodworkById(Long id);

	    List<WoodworkProjection> findWoodworkByCompanyName(String companyName);

	    Optional<WoodworkProjection> findWoodworkByCnpj(String cnpj);

	    //Screen

	    Optional<WoodworkProjectionC8> findWoodworkC8ById(Long id);

	    List<WoodworkProjectionC9> findWoodworkC9ByCompanyName(String companyName);

	    Optional<WoodworkProjectionW6> findWoodworkW6ById(Long id);
	    Optional<WoodworkProjectionW7> findWoodworkW7ById(Long id);
}
