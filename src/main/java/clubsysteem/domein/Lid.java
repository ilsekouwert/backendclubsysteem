package clubsysteem.domein;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "LEDEN")
public class Lid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String voornaam;
    private String achternaam;
    private String telefoonnummer;
    private String email;
    private String wachtwoord;
    private String geslacht;
    private boolean speler;
    private boolean trainer;
    private boolean coach;
    private String posities;
    private String niveau;
    private String trainniveau;
    private LocalDate geboortedatum;

    @OneToMany(mappedBy = "lid", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Teamkoppel> teamkoppels;

    @ManyToMany(mappedBy = "lid", cascade = {CascadeType.ALL})
    private List<Training> trainingen;

    public List<Teamkoppel> getTeamkoppels() {
        return teamkoppels;
    }

    public void setTrainingen(List<Training> trainingen) {
        this.trainingen = trainingen;
    }

    public List<String> voorTrainerZoekTeams(Lid lid) {
        List<String> teamnamen = new ArrayList<>();
        if (lid.isTrainer() == true) {
            List<Teamkoppel> koppels = lid.getTeamkoppels();
            int counter = 0;
            for (int i = 0; i < koppels.size(); i++) {
                if (koppels.get(i).getRole().equals("Trainer")) {
                    teamnamen.add(koppels.get(i).getTeam().getTeamnaam());
                    counter++;
                }
            }
            if (counter > 0) {
                return teamnamen;
            } else {
                teamnamen.add("Trainer is nog niet aan team toegewezen");
                return teamnamen;
            }
        } else {
            teamnamen.add("Lid is niet aangemeld als trainer");
            return teamnamen;
        }
    }

    public List<String> voorCoachZoekTeams(Lid lid) {
        List<String> teamnamen = new ArrayList<>();
        if (lid.isCoach() == true) {
            List<Teamkoppel> koppels = lid.getTeamkoppels();
            int counter = 0;
            for (int i = 0; i < koppels.size(); i++) {
                if (koppels.get(i).getRole().equals("Coach")) {
                    teamnamen.add(koppels.get(i).getTeam().getTeamnaam());
                    counter++;
                }
            }
            if (counter > 0) {
                return teamnamen;
            } else {
                teamnamen.add("Coach is nog niet aan team toegewezen");
                return teamnamen;
            }
        } else {
            teamnamen.add("Lid is niet aangemeld als coach");
            return teamnamen;
        }
    }

    public String krijgTeamNaam(Lid lid) {
        List<Teamkoppel> lidkoppel = lid.getTeamkoppels();
        String teamnaam = "Speler heeft nog geen team.";
        if (lidkoppel != null) {
            for (int i = 0; i < lidkoppel.size(); i++) {
                if (lidkoppel.get(i).getRole().equals("Speler")) {
                    teamnaam = lidkoppel.get(i).getTeam().getTeamnaam();
                }
            }
        }
        return teamnaam;
    }

    public String getTrainniveau() {
        return trainniveau;
    }

    public void setTrainniveau(String trainniveau) {
        this.trainniveau = trainniveau;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public String getPosities() {
        return posities;
    }

    public void setPosities(String posities) {
        this.posities = posities;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(LocalDate geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public boolean isSpeler() {
        return speler;
    }

    public void setSpeler(boolean speler) {
        this.speler = speler;
    }

    public boolean isTrainer() {
        return trainer;
    }

    public void setTrainer(boolean trainer) {
        this.trainer = trainer;
    }

    public boolean isCoach() {
        return coach;
    }

    public void setCoach(boolean coach) {
        this.coach = coach;
    }

    public List<Training> getTrainingen() {
        return trainingen;
    }

    public int calculateAge(Lid lid) {
        int leeftijd = Period.between(lid.getGeboortedatum(), LocalDate.now()).getYears();
        return leeftijd;
    }
}
