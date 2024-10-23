package es.uvigo.mei.drugs_to_avoid.controller;

import es.uvigo.mei.drugs_to_avoid.repository.daos_drug.DrugDao;
import es.uvigo.mei.drugs_to_avoid.repository.entidades_drug.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="drugs", produces = "application/json")
public class DrugController {

    @Autowired
    DrugDao drugDao;

    @GetMapping
    public List<Drug> recuperarDrugs(){
        return  drugDao.findAll();
    }


}
