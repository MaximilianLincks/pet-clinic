package com.dscsag.petclinic.services.map;

import com.dscsag.petclinic.model.Visit;
import com.dscsag.petclinic.services.OwnerService;
import com.dscsag.petclinic.services.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Profile("map")
public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {

    private final OwnerService ownerService;

    @Override
    public Visit save(Visit visit) {
        if(visit == null) throw new RuntimeException("Null Visit cannot be saved");
        if(visit.getPet() == null) throw new RuntimeException("Visit with Null pet connot be saveed");
        if(visit.getPet().getOwner() == null) throw new RuntimeException("Visits with Petzs with Null Owners cannot be saved");
        ownerService.save(visit.getPet().getOwner());
        return super.save(visit);
    }
}
