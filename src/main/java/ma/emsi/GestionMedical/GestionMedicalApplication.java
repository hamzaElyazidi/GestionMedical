package ma.emsi.GestionMedical;

import ma.emsi.GestionMedical.entities.Delegue;
import ma.emsi.GestionMedical.entities.Patient;
import ma.emsi.GestionMedical.entities.RendezVous;
import ma.emsi.GestionMedical.entities.WaitingRoom;
import ma.emsi.GestionMedical.enums.Genre;
import ma.emsi.GestionMedical.repos.DelegueRepository;
import ma.emsi.GestionMedical.repos.PatientRepository;
import ma.emsi.GestionMedical.repos.RendezVousRepo;
import ma.emsi.GestionMedical.repos.SalleAttenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GestionMedicalApplication implements CommandLineRunner {
	@Autowired
	PatientRepository patientRepository ;
	@Autowired
	DelegueRepository  delegueRepository ;
	@Autowired
	RendezVousRepo rendezVousRepo ;
	@Autowired
	SalleAttenteRepo salleAttenteRepo ;

	public static void main(String[] args) {
		SpringApplication.run(GestionMedicalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Patients
		Patient p = new Patient() ;
		p.setNom("Allami");
		p.setPrenom("Ahmed");
		p.setSexe(Genre.HOMME);
		p.setDateNaissance(LocalDate.of(1999,9,9));
		p.setEmail("allami.ahmed@gmail.com");
		p.setAddress("Address 1");
		p.setTelephone("0666987655");
		Patient p2 = new Patient() ;
		p2.setNom("Radi");
		p2.setPrenom("Amina");
		p2.setSexe(Genre.FEMME);
		p2.setDateNaissance(LocalDate.of(1988,12,12));
		p2.setEmail("radi.amina@gmail.com");
		p2.setAddress("Address 2");
		p2.setTelephone("0766334455");
		Patient p3 = new Patient() ;
		p3.setNom("Hamza");
		p3.setPrenom("Choui");
		p3.setSexe(Genre.HOMME);
		p3.setDateNaissance(LocalDate.of(2001,11,10));
		p3.setEmail("Hamza.Choui@gmail.com");
		p3.setAddress("Address 3");
		p3.setTelephone("0688345688");
		patientRepository.save(p2) ;
		patientRepository.save(p3) ;
		patientRepository.save(p) ;
		// Delegue
		Delegue d = new Delegue() ;
		d.setNom("Hafidi");
		d.setPrenom("Anas");
		d.setTelephone("0657483443");
		d.setAddress("Adresse 4");
		d.setEmail("Hafidi.Anas@outlook.com");
		delegueRepository.save(d) ;
		// Rendez-Vous
		RendezVous rendezVous1 = new RendezVous() ;
		rendezVous1.setDate(LocalDate.of(2024,2,9));
		rendezVous1.setTime(LocalTime.of(10,0,0));
		rendezVous1.setPatient(p);
		RendezVous rendezVous2 = new RendezVous() ;
		rendezVous2.setDate(LocalDate.of(2024,12,1));
		rendezVous2.setTime(LocalTime.of(9,30,0));
		rendezVous2.setPatient(p2);
		RendezVous rendezVous3 = new RendezVous() ;
		rendezVous3.setDate(LocalDate.now());
		rendezVous3.setTime(LocalTime.of(10,0,0));
		rendezVous3.setPatient(p3);
		rendezVousRepo.save(rendezVous1) ;
		rendezVousRepo.save(rendezVous2) ;
		rendezVousRepo.save(rendezVous3) ;

		WaitingRoom w = new WaitingRoom() ;
		w.setId(0L);
		List<Patient> list = new ArrayList<Patient>() ;
		list.add(p) ;
		w.setPatientsInWaitingRoom(list); ;
		salleAttenteRepo.save(w) ;
	}
}
