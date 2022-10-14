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


@Entity
@Table(name="client")
public class Client extends User{
	
	
	@Column(name="cpf_client", length = 15, nullable = false, unique = true)
	private String cpf;
	
	@Column(name="first_name_client", nullable = false)
	private String firstName;
	
	@Column(name="last_name_client", nullable = false)
	private String lastName;
	
	@OneToMany(mappedBy = "client")
	private List<Order> order;
	
	
	

	public Client(Long id, Image image, String login, String password, Address address, Contact contact, String cpf,
			String firstName, String lastName) {
		super(id, image, login, password, address, contact);
		this.cpf = cpf;
		this.firstName = firstName;
		this.lastName = lastName;
		this.order = order;
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

