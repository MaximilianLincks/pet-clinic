package com.dscsag.petclinic.services.map;

import com.dscsag.petclinic.model.Pet;

public class PetMapService extends AbstractMapService<Pet, Long>{
    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(),pet);
    }
}
