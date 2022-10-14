package br.sc.senac.urbanwood.projection.woodwork;

import br.sc.senac.urbanwood.model.Address;
import br.sc.senac.urbanwood.model.Contact;
import br.sc.senac.urbanwood.model.Image;

public interface WoodworkProjection {

	Long getId();

	Image getImage();

	String getLogin();

	String getPassword();

	Address getAddress();

	Contact getContact();

	String getCnpj();

	String getCompanyName();

	String getDescription();

}
