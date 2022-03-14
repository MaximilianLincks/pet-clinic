package com.dscsag.petclinic.services.map;

import com.dscsag.petclinic.model.Vet;
import com.dscsag.petclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {

}
