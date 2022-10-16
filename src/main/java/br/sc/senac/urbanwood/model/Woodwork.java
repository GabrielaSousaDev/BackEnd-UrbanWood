package br.sc.senac.urbanwood.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.sc.senac.urbanwood.enumeration.Environment;

@Entity
@Table(name = "woodwork")
public class Woodwork extends User {

	@Column(name = "company_name_woodwork")
	private String companyName;

	@Column(name = "description_woodwork")
	private String description;

	@Column(name = "cnpj_woodwork")
	private String cnpj;

	@OneToMany(mappedBy = "furniture", cascade = CascadeType.ALL)
	private List<Furniture> furniture;

	@OneToMany(mappedBy = "woodwork")
	private List<Order> order = new ArrayList<>();

	public Woodwork() {
	}

	public Woodwork(Long id, Image image, String login, String password, Address address, Contact contact,
			String companyName, String description, String cnpj) {
		super(id, image, login, password, address, contact);
		this.companyName = companyName;
		this.description = description;
		this.cnpj = cnpj;
	}

	public Woodwork(Woodwork id_woodwork) {
		// TODO Auto-generated constructor stub
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

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

}
