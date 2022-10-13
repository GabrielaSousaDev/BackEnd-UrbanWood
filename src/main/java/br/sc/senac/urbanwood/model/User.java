package br.sc.senac.urbanwood.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user")
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_image", nullable = true)
	private Image image;
	
	@Column(name="login_user")
	private String login;
	
	@Column(name="password_user")
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address", nullable = false)
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contact", nullable = false)
	private Contact contact;
	
}
