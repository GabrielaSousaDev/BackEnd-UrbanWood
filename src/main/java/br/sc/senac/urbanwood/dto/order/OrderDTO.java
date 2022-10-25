package br.sc.senac.urbanwood.dto.order;

import br.sc.senac.urbanwood.enumeration.Payment;
import br.sc.senac.urbanwood.enumeration.Status;
import br.sc.senac.urbanwood.model.Client;
import br.sc.senac.urbanwood.model.Furniture;
import br.sc.senac.urbanwood.model.Woodwork;

import java.time.LocalDate;
import java.util.List;

public record OrderDTO(
        Long id,
        Double price,
        Status status,
        Payment payment,
        LocalDate startDate,
        LocalDate endDate,
        Client client,
        Woodwork woodwork,
        List<Furniture> listfurnitures

) {
}
