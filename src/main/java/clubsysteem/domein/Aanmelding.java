package clubsysteem.domein;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.*;


@Entity
@Table(name="AANMELDING")
public class Aanmelding {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String voornaam;
    private String achternaam;
    private String telefoonnummer;
    private String email;
    private String wachtwoord;
    private long age;

    private String geslacht;
    private boolean speler;
    private boolean trainer;
    private boolean coach;
    private String posities;
    private String niveau;

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

    @JsonDeserialize(using=DateHandler.class)
    private LocalDate geboortedatum;

    @ManyToOne
    @JoinColumn(name="team_id", nullable = true)
    private Team team;

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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

    public long getAge() {
        return age;
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

    public void calculateAge() {
        this.age = Period.between(geboortedatum, LocalDate.now()).getYears();
    }
}
