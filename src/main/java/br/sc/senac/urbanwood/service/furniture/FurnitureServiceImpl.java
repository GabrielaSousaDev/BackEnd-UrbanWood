package br.sc.senac.urbanwood.service.furniture;

import org.springframework.stereotype.Service;

import br.sc.senac.urbanwood.dto.furniture.AllFurnitureDTO;
import br.sc.senac.urbanwood.mapper.FurnitureMapper;
import br.sc.senac.urbanwood.model.Furniture;
import br.sc.senac.urbanwood.model.Woodwork;
import br.sc.senac.urbanwood.repository.FurnitureRepository;
import br.sc.senac.urbanwood.repository.WoodworkRepository;

@Service
public class FurnitureServiceImpl implements FurnitureService {

    private final FurnitureRepository furnitureRepository;
    private final FurnitureMapper furnitureMapper;
    private final WoodworkRepository woodworkRepository;

    public FurnitureServiceImpl(FurnitureRepository furnitureRepository, FurnitureMapper furnitureMapper, WoodworkRepository woodworkRepository) {
        this.furnitureRepository = furnitureRepository;
        this.furnitureMapper = furnitureMapper;
		this.woodworkRepository = woodworkRepository;
    }

    public AllFurnitureDTO save(AllFurnitureDTO dto) {
	
    	Woodwork woodwork = new Woodwork(dto.id_woodwork());
    	Woodwork woodworkSaved = furnitureRepository.save(woodwork);
    	
    	Furniture furniture = new Furniture(dto.idFurniture(),dto.name(), dto.price(), dto.description());
    	Furniture furnitureSaved = furnitureRepository.save(furniture);
    	
    	return new FurnitureMapper().toDTO(furnitureSaved);
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