package br.sc.senac.urbanwood.model;

import br.sc.senac.urbanwood.enumeration.Environment;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "woodwork")
public class Woodwork extends User {

	@Column(name = "company_name_woodwork")
	private String companyName;

	@Column(name = "description_woodwork")
	private String description;


	@Column(name = "cnpj_woodwork")
	private String cnpj;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Furniture> furniture;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Order> order;


	@Enumerated(EnumType.ORDINAL)
	@Column(name="environment_furniture")
	private Environment environment;

	public Woodwork(Long idUser, String login, String password,
					Address address, Contact contact, byte[] image,
					String companyName, String description, String cnpj,
					List<Furniture> furniture, List<Order> order,
					Environment environment) {
		super(idUser, login, password, address, contact, image);
		this.companyName = companyName;
		this.description = description;
		this.cnpj = cnpj;
		this.furniture = furniture;
		this.order = order;
		this.environment = environment;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Furniture> getFurniture() {
		return furniture;
	}

	public void setFurniture(List<Furniture> furniture) {
		this.furniture = furniture;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
}
