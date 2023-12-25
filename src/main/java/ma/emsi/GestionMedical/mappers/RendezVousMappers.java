package ma.emsi.GestionMedical.mappers;

import ma.emsi.GestionMedical.dtos.RendezVousDTO;
import ma.emsi.GestionMedical.entities.Patient;
import ma.emsi.GestionMedical.entities.RendezVous;
import ma.emsi.GestionMedical.repos.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RendezVousMappers {
    @Autowired
    PatientRepository patientRestClient ;
   public RendezVous fromRendezVousDTO(RendezVousDTO rendezVousDTO)
    {
        RendezVous rendezVous = new RendezVous() ;
        rendezVous.setDate(rendezVousDTO.getDate());
        rendezVous.setTime(rendezVousDTO.getTime());
        Patient p = patientRestClient.findById(rendezVousDTO.getPatientId()).get();
        rendezVous.setPatient(p);
        return  rendezVous ;
    }
}
