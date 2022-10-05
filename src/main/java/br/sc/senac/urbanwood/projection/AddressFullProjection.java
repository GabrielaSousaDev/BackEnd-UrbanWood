package br.sc.senac.urbanwood.projection;

public interface AddressFullProjection {
	
	Long getId();

    String getStreet();

    Integer getNumber();

    String getComplement();

    String getNeighborhood();

    String getProvince();

    String getCity();

    String getCep();

}
