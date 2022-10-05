package br.sc.senac.urbanwood.repository;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface Order extends JpaRepository<Long, Id>{

	 Optional<OrderProjection> findOrderById(Long id);

	    List<OrderProjection> findOrderByInitialDate(LocalDate initialDate);

	    //Screen

	    @Query(value = """
	            select o.id as id, o.initialDate as initialDate, o.priceOrder as priceOrder, o.status as status
	            from Order o
	            """)
	    Page<OrderProjectionW12> findOrderW12OrderByInitialDate(Pageable pageable);

	    Optional<OrderProjectionW13> findOrderW13ById(Long id);
}
