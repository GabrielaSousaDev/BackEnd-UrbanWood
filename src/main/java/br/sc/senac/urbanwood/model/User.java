package br.sc.senac.urbanwood.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="user")
public abstract class User {
	
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
	
	public User(Long id, Image image, String login, String password, Address address, Contact contact) {
		super();
		this.id = id;
		this.image = image;
		this.login = login;
		this.password = password;
		this.address = address;
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	
}
