package br.sc.senac.urbanwood.service.furniture;

import java.util.List;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.furniture.AllFurnitureDTO;
import br.sc.senac.urbanwood.mapper.FurnitureMapper;
import br.sc.senac.urbanwood.model.Color;
import br.sc.senac.urbanwood.model.Furniture;
import br.sc.senac.urbanwood.repository.ColorRepository;
import br.sc.senac.urbanwood.repository.FurnitureRepository;

@Service
public class FurnitureServiceImpl implements FurnitureService {

    private final FurnitureRepository furnitureRepository;
    private final FurnitureMapper furnitureMapper;
    private final ColorRepository colorRepository;

    public FurnitureServiceImpl(FurnitureRepository furnitureRepository, FurnitureMapper furnitureMapper, ColorRepository colorRepository) {
        this.furnitureRepository = furnitureRepository;
        this.furnitureMapper = furnitureMapper;
        this.colorRepository = colorRepository;
    }

    public AllFurnitureDTO save(AllFurnitureDTO dto) {

    	Furniture furniture = new Furniture(dto.idFurniture(), dto.name(), dto.price(), dto.description(), dto.furnitureSize());
    	Furniture furnitureSaved = furnitureRepository.save(furniture);
    	
    	Color color = new List<Color>(dto.idColor());
    	Color colorSaved = colorRepository.save(color);	
    }

   /* public void update(FurnitureDTO furnitureDTO, Long id) {

        Furniture furniture = furnitureRepository.findById(id)
                .orElseThrow(() -> new FurnitureNotFoundException("Furniture " + id + " was not found"));

        if (furnitureDTO.furnitureSize() <= 0 || furnitureDTO.priceFurniture() <= 0)
            throw new FurnitureInvalidException("The Furniture Size is less than zero or the Price is less than zero");

        if (furnitureDTO.nameFurniture().equals(furniture.getNameFurniture())) {
            furniture.setDescription(furnitureDTO.description());
            furniture.setNameFurniture(furnitureDTO.nameFurniture());
            furniture.setFurnitureSize(furnitureDTO.furnitureSize());
            furniture.setPriceFurniture(furnitureDTO.priceFurniture());
            furnitureRepository.save(furniture);
            return;
        }

        if (furnitureRepository.existsByNameFurniture(furnitureDTO.nameFurniture()))
            throw new FurnitureNameRegisteredException("Furniture " + furnitureDTO.nameFurniture() + " is already registered");

        furniture.setDescription(furnitureDTO.description());
        furniture.setNameFurniture(furnitureDTO.nameFurniture());
        furniture.setFurnitureSize(furnitureDTO.furnitureSize());
        furniture.setPriceFurniture(furnitureDTO.priceFurniture());
        furnitureRepository.save(furniture);
    }

    public void delete(Long id) {
        if (!furnitureRepository.existsById(id))
            throw new FurnitureNotFoundException("Furniture " + id + " was not found");
        furnitureRepository.deleteById(id);
    }

    public FurnitureProjection findById(Long id) {
        return furnitureRepository.findFurnitureById(id)
                .orElseThrow(() -> new FurnitureNotFoundException("Id " + id + " was not found"));
    }

    public List<FurnitureProjection> findByNameFurniture(String nameFurniture) {
        List<FurnitureProjection> furniture = furnitureRepository.findFurnitureByNameFurniture(nameFurniture);

        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Name " + nameFurniture + " was not found");
        return furniture;
    }

    public List<FurnitureProjection> findByPriceFurniture(Double priceFurniture) {
        List<FurnitureProjection> furniture = furnitureRepository.findFurnitureByPriceFurniture(priceFurniture);

        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Price " + priceFurniture + " was not found");
        return furniture;
    }

    //Screen

    public FurnitureProjectionC14 findC14ById(Long id) {
        return furnitureRepository.findFurnitureC14ById(id)
                .orElseThrow(() -> new FurnitureNotFoundException("Id " + id + " was not found"));
    }

    public List<FurnitureProjectionC15> findC15OrderByNameFurniture() {
        List<FurnitureProjectionC15> furniture = furnitureRepository.findAllOrderByNameFurniture();

        if(furniture.isEmpty())
            throw new FurnitureNotFoundException("Was not found");
        return furniture;
    }*/
}