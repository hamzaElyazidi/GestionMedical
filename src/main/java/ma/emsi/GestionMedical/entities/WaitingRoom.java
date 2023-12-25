package ma.emsi.GestionMedical.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Delegate;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaitingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    @OneToMany
    List<Patient> PatientsInWaitingRoom ;
    @OneToMany
    List<Delegue> DelegueInWatingRoom ;
}
