package br.sc.senac.urbanwood.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FurnitureRepository extends JpaRepository<Long, Id>{
	 
	boolean existsByNameFurniture(String nameFurniture);

	   
	   /* @Query(value = """
	            select f.nameFurniture as nameFurniture, f.priceFurniture as priceFurniture, f.image as image
	            from Furniture f
	            order by f.nameFurniture asc
	            """)
	    List<FurnitureProjectionC15> findAllOrderByNameFurniture();*/
}
