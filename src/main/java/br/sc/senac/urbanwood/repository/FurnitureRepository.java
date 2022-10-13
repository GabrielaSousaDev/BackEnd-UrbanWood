package br.sc.senac.urbanwood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.urbanwood.model.Furniture;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Long>{
	   
	   /* @Query(value = """
	            select f.nameFurniture as nameFurniture, f.priceFurniture as priceFurniture, f.image as image
	            from Furniture f
	            order by f.nameFurniture asc
	            """)
	    List<FurnitureProjectionC15> findAllOrderByNameFurniture();*/
}
