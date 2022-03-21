package com.dscsag.petclinic.services.map;

import com.dscsag.petclinic.model.Owner;
import com.dscsag.petclinic.services.OwnerService;
import com.dscsag.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("map")
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;

    public OwnerMapService(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Owner save(Owner owner){
        if(owner == null) throw new RuntimeException("Null Owner cannot be saved");
        if(owner.getPets() == null) return owner;
        owner.getPets().forEach(pet ->{
            if(pet == null) throw new RuntimeException("Pets cannot be null");
            if(pet.getId() == null) petService.save(pet);
        });
        return super.save(owner);
    }

}
