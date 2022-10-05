package br.sc.senac.urbanwood.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="contact")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_contact")
	private Long id;
	
	@Column(name="email_contact")
	private String email;
	
	@Column(name="phone_number_contact")
	private String phoneNumber;
	
	@Column(name="net_work_contact")
	private String netWork;
}
