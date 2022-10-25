package br.sc.senac.urbanwood.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
	
	@Column(name="email_contact", length = 45)
	private String email;
	
	@Column(name="phone_number_contact", length = 30)
	private String phoneNumber;
	
	@Column(name="net_work_contact", length = 45)
	private String netWork;
/*, nullable = false, unique = true*/
}
