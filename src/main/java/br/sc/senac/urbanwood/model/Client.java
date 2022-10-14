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
@EqualsAndHashCode
@Data
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
	
}

