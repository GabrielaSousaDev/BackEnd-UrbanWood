package br.sc.senac.urbanwood.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.sc.senac.urbanwood.enumeration.Color;
import br.sc.senac.urbanwood.enumeration.Environment;
import br.sc.senac.urbanwood.enumeration.SizeFurniture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="furniture")
public class Furniture {

	public Furniture(Long idFurniture, String name2, Double price2, String description2) {
		// TODO Auto-generated constructor stub
	}

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
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="furniture_size_furniture")
	private SizeFurniture furnitureSize;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="environment_furniture")
	private Environment environment;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="color_furniture")
	private Color color;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_image", nullable = false)
	private Image image;
		
	@ManyToOne
	@JoinColumn(name = "id_woodwork", nullable = false)
	private Woodwork woodwork;
}
