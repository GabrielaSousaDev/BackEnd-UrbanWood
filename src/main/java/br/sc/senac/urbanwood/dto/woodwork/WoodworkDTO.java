package br.sc.senac.urbanwood.dto.woodwork;

import br.sc.senac.urbanwood.enumeration.Environment;
import br.sc.senac.urbanwood.model.*;

import java.util.List;

public record WoodworkDTO(Long idUser, String login, String password,
                          Address address, Contact contact, byte[] image,
                          String companyName, String description, String cnpj,
                          List<Furniture> furniture, List<Order> order,
                          Environment environment) {}

