package ma.emsi.GestionMedical.repos;

import ma.emsi.GestionMedical.entities.WaitingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleAttenteRepo extends JpaRepository<WaitingRoom,Long> {

}
