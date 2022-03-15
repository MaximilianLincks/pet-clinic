package com.dscsag.petclinic.services.map;

import com.dscsag.petclinic.model.Pet;
import com.dscsag.petclinic.services.PetService;
import com.dscsag.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
    private final PetTypeService petTypeService;

    public PetMapService(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public Pet save(Pet pet){
        if(pet == null) throw new RuntimeException("Null Pet cannot be saved");
        if(pet.getPetType() == null) throw new RuntimeException("Pets without a PetType cannot be saved");
        if(pet.getPetType().getId() == null) petTypeService.save(pet.getPetType());
        return super.save(pet);
    }
}
