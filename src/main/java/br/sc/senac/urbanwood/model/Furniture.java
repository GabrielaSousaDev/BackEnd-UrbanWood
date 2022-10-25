package br.sc.senac.urbanwood.model;

import br.sc.senac.urbanwood.enumeration.Color;
import br.sc.senac.urbanwood.enumeration.Environment;
import br.sc.senac.urbanwood.enumeration.SizeFurniture;


import javax.persistence.*;


@Entity
@Table(name="furniture")
public class Furniture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFurniture;
	
	@Column(name="name_furniture")
	private String name;
	
	@Column(name="price_furniture")
	private Double price;

	@Column(name="description_furniture")
	private String description;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="furniture_size_furniture")
	private SizeFurniture furnitureSize;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="environment_furniture")
	private Environment environment;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="color_furniture")
	private Color color;

	@JoinColumn(name = "furniture")
	@ManyToOne(cascade = CascadeType.ALL)
	private Woodwork woodwork;

	public Furniture(Long idFurniture, String name, Double price, String description,
					 SizeFurniture furnitureSize, Environment environment, Color color,
					  Woodwork woodwork) {
		this.idFurniture = idFurniture;
		this.name = name;
		this.price = price;
		this.description = description;
		this.furnitureSize = furnitureSize;
		this.environment = environment;
		this.color = color;
		this.woodwork = woodwork;
	}

	public Furniture() {

	}




	public Long getId() {
		return idFurniture;
	}

	public void setId(Long id) {
		this.idFurniture = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SizeFurniture getFurnitureSize() {
		return furnitureSize;
	}

	public void setFurnitureSize(SizeFurniture furnitureSize) {
		this.furnitureSize = furnitureSize;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}


	public Woodwork getWoodwork() {
		return woodwork;
	}

	public void setWoodwork(Woodwork woodwork) {
		this.woodwork = woodwork;
	}
}
