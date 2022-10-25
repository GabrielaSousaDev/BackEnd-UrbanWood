package br.sc.senac.urbanwood.service.furniture;

import br.sc.senac.urbanwood.dto.furniture.FurnitureDTO;
import br.sc.senac.urbanwood.exception.furniture.FurnitureInvalidException;
import br.sc.senac.urbanwood.exception.furniture.FurnitureNameRegisteredException;
import br.sc.senac.urbanwood.exception.furniture.FurnitureNotFoundException;
import br.sc.senac.urbanwood.mapper.FurnitureMapper;
import br.sc.senac.urbanwood.model.Furniture;

import br.sc.senac.urbanwood.repository.FurnitureRepository;

import org.springframework.stereotype.Service;

@Service
public class FurnitureServiceImpl implements FurnitureService {

    private final FurnitureRepository furnitureRepository;
    private final FurnitureMapper furnitureMapper;

    public FurnitureServiceImpl(FurnitureRepository furnitureRepository, FurnitureMapper furnitureMapper) {
        this.furnitureRepository = furnitureRepository;
        this.furnitureMapper = furnitureMapper;

    }

    public FurnitureDTO save(FurnitureDTO dto) {

    	Furniture furniture = new Furniture(dto.idFurniture(),dto.name(), dto.price(),
                dto.description(), dto.sizeFurniture(), dto.environment(), dto.color(),
                dto.woodwork());
    	Furniture furnitureSaved = furnitureRepository.save(furniture);

    	return furnitureMapper.toDTO(furnitureSaved);
    }

    public void update(FurnitureDTO furnitureDTO, Long id) {

        Furniture furniture = furnitureRepository.findById(id)
                .orElseThrow(() -> new FurnitureNotFoundException("Furniture " + id + " was not found"));

        if ((furnitureDTO.sizeFurniture().equals(0)) || furnitureDTO.price() <= 0)
            throw new FurnitureInvalidException("The Furniture Size is less than zero or the Price is less than zero");

        if (furnitureDTO.name().equals(furniture.getName())) {
            furniture.setDescription(furnitureDTO.description());
            furniture.setName(furnitureDTO.name());
            furniture.setFurnitureSize(furnitureDTO.sizeFurniture());
            furniture.setPrice(furnitureDTO.price());
            furnitureRepository.saveAndFlush(furniture);
            return;
        }

        furniture.setDescription(furnitureDTO.description());
        furniture.setName(furnitureDTO.name());
        furniture.setFurnitureSize(furnitureDTO.sizeFurniture());
        furniture.setPrice(furnitureDTO.price());
        furnitureRepository.saveAndFlush(furniture);
    }

    public void delete(Long id) {
        if (!furnitureRepository.existsById(id))
            throw new FurnitureNotFoundException("Furniture " + id + " was not found");
        furnitureRepository.deleteById(id);
    }
    public FurnitureDTO findById(Long id) {
        Furniture furniture = furnitureRepository.findById(id)
                .orElseThrow(() -> new FurnitureNotFoundException("Furniture on " + id + " was not found"));
        return furnitureMapper.toDTO(furniture);
    }



}