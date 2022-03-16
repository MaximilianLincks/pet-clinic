package com.dscsag.petclinic.services.map;

import com.dscsag.petclinic.model.Vet;
import com.dscsag.petclinic.services.SpecialtyService;
import com.dscsag.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet save(Vet vet){
        if(vet == null) throw new RuntimeException("Null Vet cannot be saved");
        if(vet.getSpecialties() == null) return vet;
        vet.getSpecialties().forEach(specialty ->{
            if(specialty == null) throw new RuntimeException("Specialties cannot be null");
            if(specialty.getId() == null) specialtyService.save(specialty);
        });
        return super.save(vet);
    }
}
