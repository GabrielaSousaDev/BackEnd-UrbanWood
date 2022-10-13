package br.sc.senac.urbanwood.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_address")
	private Long id;

	@Column(name="street_name_address", length = 45, nullable = false)
	private String streetName;
	
	@Column(name="number_address", nullable = false)
	private int number;
	
	@Column(name="neighborhood_address", length = 45, nullable = false)
	private String neighborhood;
	
	@Column(name="complement_address", length = 45, nullable = false)
	private String complement;
	
	@Column(name="city_address", length = 45, nullable = false)
	private String city;
	
	@Column(name="cep_address", nullable = false)
	private String cep;
}
