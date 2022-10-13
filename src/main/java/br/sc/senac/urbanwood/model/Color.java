package br.sc.senac.urbanwood.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="color")
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_color")
	private Long id;
	
	@Column(name="name_color", length = 45, nullable = false)
	private String name;
	
	@Column(name="brand_color", length = 45, nullable = false)
	private String brand;
	
	@ManyToMany(mappedBy = "colors")
	private List<Furniture> furnitures;
}
