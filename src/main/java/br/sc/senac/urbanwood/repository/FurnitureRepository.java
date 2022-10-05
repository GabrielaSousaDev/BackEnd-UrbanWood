package br.sc.senac.urbanwood.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface FurnitureRepository extends JpaRepository<Long, Id>{
	 
	boolean existsByNameFurniture(String nameFurniture);

	    Optional<FurnitureProjection> findFurnitureById(Long id);

	    List<FurnitureProjection> findFurnitureByNameFurniture(String nameFurniture);

	    List<FurnitureProjection> findFurnitureByPriceFurniture(Double priceFurniture);

	    //Screen

	    Optional<FurnitureProjectionC14> findFurnitureC14ById(Long id);

	    @Query(value = """
	            select f.nameFurniture as nameFurniture, f.priceFurniture as priceFurniture, f.image as image
	            from Furniture f
	            order by f.nameFurniture asc
	            """)
	    List<FurnitureProjectionC15> findAllOrderByNameFurniture();
}
