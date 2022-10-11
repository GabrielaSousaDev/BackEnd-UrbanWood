package br.sc.senac.urbanwood.service.contact;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.ContactDTO;
import br.sc.senac.urbanwood.projection.ClientBasicForSearchProjection.UserProjection.ContactProjection;
import br.sc.senac.urbanwood.projection.ProfileWoodworkForEditProjection;

@Service
public interface ContactService {

	ContactDTO save(ContactDTO contactDTO);

	void update(ContactDTO contactDTO, Long id);

	void delete(Long id);

	ContactProjection findById(Long id);

	ProfileWoodworkForEditProjection findByWoodworkPhoneNumber(String phoneNumberWoodwork);
}