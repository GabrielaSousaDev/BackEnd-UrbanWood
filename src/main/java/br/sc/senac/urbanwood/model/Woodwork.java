package br.sc.senac.urbanwood.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "woodwork")
public class Woodwork extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_woodwork")
	private Long id;

	@Column(name = "company_name_woodwork")
	private String companyName;

	@Column(name = "description_woodwork")
	private String description;

	@OneToMany(mappedBy = "order")
	private List<Order> order;

	@OneToMany
	private List<Environment> environment;
}
