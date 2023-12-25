package ma.emsi.GestionMedical.controllers;

import ma.emsi.GestionMedical.dtos.RendezVousDTO;
import ma.emsi.GestionMedical.entities.RendezVous;
import ma.emsi.GestionMedical.mappers.RendezVousMappers;
import ma.emsi.GestionMedical.repos.PatientRepository;
import ma.emsi.GestionMedical.repos.RendezVousRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RendezVousController {
    @Autowired
    RendezVousRepo rendezVousRepo;
    @Autowired
    RendezVousMappers mapper;
    @Autowired
    PatientRepository patientRepo;

    @GetMapping("/rendezvous")
    public List<RendezVous> getAll() {
        return rendezVousRepo.findAll();
    }

    @PostMapping("/rendezvous")
    public RendezVous addRendezVous(@RequestBody RendezVousDTO rendezVousDTO) {

        if (patientRepo.findById(rendezVousDTO.getPatientId()).isPresent())
        {
            if (getAll().stream().anyMatch(rendezVous -> rendezVous.getDate().equals(rendezVousDTO.getDate()) && rendezVous.getTime().equals(rendezVousDTO.getTime())))
            {
                System.out.println("timeslot already in use");
                return null;
            }
            else
                return rendezVousRepo.save(mapper.fromRendezVousDTO(rendezVousDTO));
        } else
        {
            System.out.println("there is no patient with id = " + rendezVousDTO.getPatientId());
            return null;
        }
    }
    @GetMapping("/rendezvous/today")
    public List<RendezVous> getTodayRendezVous()
    {
        List<RendezVous> rendezVousList = new ArrayList<>() ;
        rendezVousList = rendezVousRepo
                .findAll()
                .stream()
                .filter(rendezVous -> rendezVous.getDate().isEqual(LocalDate.now())).collect(Collectors.toList()) ;
        return rendezVousList ;
    }
    @DeleteMapping("/rendezvous/{id}")
    public void deleteRendezVous(@PathVariable Long id)
    {
        rendezVousRepo.deleteById(id);
    }



}
