package br.sc.senac.urbanwood.dto.adress;

public record AddressDTO(
        Long id,
        String streetName,
        int number,
        String neighborhood,
        String complement,
        String city,
        String cep
) {
}
