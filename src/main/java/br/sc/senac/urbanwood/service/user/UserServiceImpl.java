package br.sc.senac.urbanwood.service.user;

import br.sc.senac.urbanwood.exception.client.ClientLoginRegisteredException;
import br.sc.senac.urbanwood.exception.woodwork.WoodworkCnpjRegisteredException;
import br.sc.senac.urbanwood.model.Address;
import br.sc.senac.urbanwood.model.Contact;

public class UserServiceImpl {

	
	 Contact contact = contactRepository.findById(woodworkDTO.idContact())
             .orElseThrow(() -> new ContactNotFoundException("Contact " + woodworkDTO.idContact() + " was not found"));

     Address address = addressRepository.findById(woodworkDTO.idAddress())
             .orElseThrow(() -> new AddressNotFoundException("Address " + woodworkDTO.idAddress() + " was not found"));

     if (woodworkRepository.existsByCnpj(woodworkDTO.cnpj()))
         throw new WoodworkCnpjRegisteredException("Cnpj " + woodworkDTO.cnpj() + " is already registered");

     if (woodworkRepository.existsByLogin(woodworkDTO.login()))
         throw new ClientLoginRegisteredException("Login " + woodworkDTO.login() + " is already registered");

}
