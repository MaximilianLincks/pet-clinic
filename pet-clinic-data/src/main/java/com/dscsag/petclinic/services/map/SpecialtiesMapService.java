package com.dscsag.petclinic.services.map;

import com.dscsag.petclinic.model.Specialty;
import com.dscsag.petclinic.services.SpecialtiesService;
import org.springframework.stereotype.Service;

@Service
public class SpecialtiesMapService extends AbstractMapService<Specialty, Long> implements SpecialtiesService {
}
