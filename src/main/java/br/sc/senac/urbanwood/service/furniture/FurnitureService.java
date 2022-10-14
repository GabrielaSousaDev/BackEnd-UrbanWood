package br.sc.senac.urbanwood.service.furniture;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.client.AllClientDTO;
import br.sc.senac.urbanwood.dto.furniture.AllFurnitureDTO;

@Service
public interface FurnitureService {

    AllFurnitureDTO save(AllFurnitureDTO dto);

   /* void update(FurnitureDTO furnitureDTO, Long id);

    void delete(Long id);

    FurnitureProjection findById(Long id);

    List<FurnitureProjection> findByNameFurniture(String nameFurniture);

    List<FurnitureProjection> findByPriceFurniture(Double priceFurniture);

    //Screen

    FurnitureProjectionC14 findC14ById(Long id);

    List<FurnitureProjectionC15> findC15OrderByNameFurniture();*/
}