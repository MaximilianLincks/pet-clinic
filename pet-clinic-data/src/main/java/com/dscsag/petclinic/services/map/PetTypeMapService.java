package com.dscsag.petclinic.services.map;

import com.dscsag.petclinic.model.PetType;
import com.dscsag.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType,Long> implements PetTypeService {
}
