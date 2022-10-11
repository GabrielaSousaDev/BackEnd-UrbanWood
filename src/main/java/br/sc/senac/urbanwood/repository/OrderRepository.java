package br.sc.senac.urbanwood.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends JpaRepository<Long, Id>{

	

	   /* @Query(value = """
	            select o.id as id, o.initialDate as initialDate, o.priceOrder as priceOrder, o.status as status
	            from Order o
	            """)
	    Page<OrderProjectionW12> findOrderW12OrderByInitialDate(Pageable pageable);*/

}
