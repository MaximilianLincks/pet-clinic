package com.dscsag.petclinic.services.map;

import com.dscsag.petclinic.model.Pet;
import com.dscsag.petclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

}
