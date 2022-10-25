package br.sc.senac.urbanwood.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="client")
public class Client extends User{


	@Column(name="cpf_client")
	@JoinColumn(name="cpf_client")
	private String cpf;
	
	@Column(name="first_name_client")
	private String firstName;
	
	@Column(name="last_name_client")
	private String lastName;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Order> order;

	public Client(Long idUser, String login, String password, Address address,
				  Contact contact, byte[] image, String cpf, String firstName,
				  String lastName, List<Order> order) {
		super(idUser, login, password, address, contact, image);
		this.cpf = cpf;
		this.firstName = firstName;
		this.lastName = lastName;
		this.order = order;
	}

	public Client() {
		super();

	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

}

