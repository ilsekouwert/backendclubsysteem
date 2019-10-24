package clubsysteem.domein;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TEAM")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String teamnaam;
    private String niveau;
    private String trainer;
    private String[] teamType;
    private String coach;
    private boolean wedstrijd;

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private Set<Aanmelding> aanmelding;

    public Set<Aanmelding> getAanmelding() {
        return aanmelding;
    }

    public void setAanmelding(Set<Aanmelding> aanmelding) {
        this.aanmelding = aanmelding;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeamnaam() {
        return teamnaam;
    }

    public void setTeamnaam(String teamnaam) {
        this.teamnaam = teamnaam;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String[] getTeamType() {
        return teamType;
    }

    public void setTeamType(String[] teamType) {
        this.teamType = teamType;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public boolean isWedstrijd() {
        return wedstrijd;
    }

    public void setWedstrijd(boolean wedstrijd) {
        this.wedstrijd = wedstrijd;
    }
}
