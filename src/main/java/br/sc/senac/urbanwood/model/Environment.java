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
@Table(name="environment")
public class Environment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_environment")
	private Long id;
	
	@Column(name="name_environment")
	private String name;

	@OneToOne(mappedBy = "image")
	private Image image;
	
	@OneToMany(mappedBy = "furniture")
	private List<Furniture> furniture;
	
}
