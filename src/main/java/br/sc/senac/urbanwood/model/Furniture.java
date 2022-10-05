package br.sc.senac.urbanwood.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="furniture")
public class Furniture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_furniture")
	private Long id;
	
	@Column(name="name_furniture")
	private String name;
	
	@Column(name="price_furniture")
	private Double price;
	
	@Column(name="description_furniture")
	private String description;
	
	@Column(name="furniture_size_furniture")
	private Double furnitureSize;
	
	@OneToOne(mappedBy = "image")
	private Image imagem;
	
	@OneToMany(mappedBy = "color")
	private List<Color> color;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
