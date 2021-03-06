package com.dscsag.petclinic.services.map;

import com.dscsag.petclinic.model.Specialty;
import com.dscsag.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {
}
