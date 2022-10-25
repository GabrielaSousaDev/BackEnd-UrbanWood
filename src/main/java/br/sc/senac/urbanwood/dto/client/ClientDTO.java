package br.sc.senac.urbanwood.dto.client;

import br.sc.senac.urbanwood.model.Address;
import br.sc.senac.urbanwood.model.Contact;
import br.sc.senac.urbanwood.model.Order;

import java.util.List;

public record ClientDTO(Long idUser, String login, String password, Address address,
                        Contact contact, String cpf, String firstName, String lastName,
                        List<Order> order, byte[] imageProfile) {}
