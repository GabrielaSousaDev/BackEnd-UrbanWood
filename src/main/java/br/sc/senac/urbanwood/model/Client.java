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
@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(name="client")
public class Client extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_client")
	private Long id;
	
	@Column(name="cpf_client")
	private String cpf;
	
	@Column(name="first_name_client")
	private String firstName;
	
	@Column(name="last_name_client")
	private String lastName;
	
	@OneToMany(mappedBy = "order")
	private List<Order> order;
	
}

