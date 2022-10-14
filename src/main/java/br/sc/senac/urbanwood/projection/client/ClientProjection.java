package br.sc.senac.urbanwood.projection.client;

import br.sc.senac.urbanwood.model.Address;
import br.sc.senac.urbanwood.model.Contact;
import br.sc.senac.urbanwood.model.Image;

public interface ClientProjection {

	Long getId();
	
	Image getImage();
	
	String getLogin();
	
	String getPassword();
	
	Address getAddress();
	
	Contact getContact();
	
	String getCpf();
	
	String getFirstName();
	
	String getLastName();
}
