package ma.emsi.GestionMedical.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.GestionMedical.enums.Genre;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String nom ;
    private String prenom ;
    @Enumerated(EnumType.STRING)
    private Genre sexe ;
    private String telephone ;
    private LocalDate dateNaissance ;
    private String address ;
    private String email ;
}
