package com.dscsag.controllers;

import com.dscsag.petclinic.model.Vet;
import com.dscsag.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
@RequestMapping({"/vets","vets.html"})
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String listVets(Model model){

        model.addAttribute("vets",vetService.findAll());

        return  "vets/index";
    }

    @RequestMapping("/api")
    public @ResponseBody Set<Vet> getVetsJSON(){
        return vetService.findAll();
    }
}
