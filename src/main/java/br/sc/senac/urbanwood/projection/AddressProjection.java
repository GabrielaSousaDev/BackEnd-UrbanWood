package br.sc.senac.urbanwood.projection;

public interface AddressProjection {
	
	Long getId();

    String getStreetName();

    Integer getNumber();

    String getComplement();

    String getNeighborhood();

    String getCity();

    String getCep();

}
