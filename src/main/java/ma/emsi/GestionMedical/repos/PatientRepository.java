package ma.emsi.GestionMedical.repos;

import ma.emsi.GestionMedical.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
