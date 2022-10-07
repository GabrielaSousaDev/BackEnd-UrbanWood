package br.sc.senac.urbanwood.projection;

public interface AddressProjection {
	
	Long getId();

    String getStreet();

    Integer getNumber();

    String getComplement();

    String getNeighborhood();

    String getProvince();

    String getCity();

    String getCep();

}
