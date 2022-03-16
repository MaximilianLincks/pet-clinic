package com.dscsag.petclinic.services.map;

import com.dscsag.petclinic.model.PetType;
import com.dscsag.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class PetTypeMapService extends AbstractMapService<PetType,Long> implements PetTypeService {
}
