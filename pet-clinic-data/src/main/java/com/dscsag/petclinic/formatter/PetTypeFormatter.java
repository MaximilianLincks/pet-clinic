package com.dscsag.petclinic.formatter;


import com.dscsag.petclinic.model.PetType;
import com.dscsag.petclinic.services.PetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        return petTypeService.findByName(text);
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }
}
