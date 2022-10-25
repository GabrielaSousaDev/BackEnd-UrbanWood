package br.sc.senac.urbanwood.model;

import br.sc.senac.urbanwood.enumeration.Payment;
import br.sc.senac.urbanwood.enumeration.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;



@Entity
@Table(name = "orderRequest")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private Long id;

	@Column(name = "price_order")
	private Double price;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status_order", nullable = false)
	private Status status;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "payment_order", nullable = false)
	private Payment payment;

	@Column(name = "start_date_order")
	@JsonFormat(pattern = "dd-mm-yyyy")
	private LocalDate startDate;

	@Column(name = "end_date_order")
	@JsonFormat(pattern = "dd-mm-yyyy")
	private LocalDate endDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cpf_client")
	private Client client;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cnpj_woodwork")
	private Woodwork woodwork;

	@ManyToMany
	@JoinTable(name = "furniture_order", joinColumns = @JoinColumn(name = "id_order"),
	inverseJoinColumns = @JoinColumn(name = "id_furniture"))
	private List<Furniture> furnitures;

	public Order(Long id, Double price, Status status, Payment payment,
				 LocalDate startDate, LocalDate endDate, Client client,
				 Woodwork woodwork, List<Furniture> furnitures) {
		this.id = id;
		this.price = price;
		this.status = status;
		this.payment = payment;
		this.startDate = startDate;
		this.endDate = endDate;
		this.client = client;
		this.woodwork = woodwork;
		this.furnitures = furnitures;
	}

	public Order() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Woodwork getWoodwork() {
		return woodwork;
	}

	public void setWoodwork(Woodwork woodwork) {
		this.woodwork = woodwork;
	}

	public List<Furniture> getFurnitures() {
		return furnitures;
	}

	public void setFurnitures(List<Furniture> furnitures) {
		this.furnitures = furnitures;
	}
}
