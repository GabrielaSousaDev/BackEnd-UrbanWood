package br.sc.senac.urbanwood.service.furniture;

import br.sc.senac.urbanwood.dto.furniture.FurnitureDTO;
import org.springframework.stereotype.Service;

@Service
public interface FurnitureService {

    FurnitureDTO save(FurnitureDTO dto);

   /* void update(FurnitureDTO furnitureDTO, Long id);

    void delete(Long id);

    FurnitureProjection findById(Long id);

    List<FurnitureProjection> findByNameFurniture(String nameFurniture);

    List<FurnitureProjection> findByPriceFurniture(Double priceFurniture);

    //Screen

    FurnitureProjectionC14 findC14ById(Long id);

    List<FurnitureProjectionC15> findC15OrderByNameFurniture();*/
}