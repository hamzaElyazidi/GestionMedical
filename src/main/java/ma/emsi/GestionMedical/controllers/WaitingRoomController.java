package ma.emsi.GestionMedical.controllers;

import ma.emsi.GestionMedical.entities.Patient;
import ma.emsi.GestionMedical.repos.SalleAttenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class WaitingRoomController {
    @Autowired
    SalleAttenteRepo salleAttenteRepo ;
    @GetMapping("/salleAttente")
    public List<Patient> getAllWaitingPatient()
    {
        return salleAttenteRepo.findAll().get(0).getPatientsInWaitingRoom() ;
    }
}
