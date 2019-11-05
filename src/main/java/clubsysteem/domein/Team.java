package clubsysteem.domein;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "TEAM")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String teamnaam;
    private String niveau;
    private String teamType;
    private boolean wedstrijd;
    private int speleraantal;

    @OneToMany(mappedBy = "team")
    private List<Teamkoppel> koppels;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Training> training;

    public Set<Training> getTraining() {
        return training;
    }

    public List<String> krijgTrainerOfCoach(Team team, String role) {
        List<Teamkoppel> teamleden = team.getKoppels();
        List<String> geselecteerdeLid = new ArrayList<>();
        if (teamleden.size() != 0) {
            for (int i = 0; i < teamleden.size(); i++) {
                if (teamleden.get(i).getRole().equals(role)) {
                    geselecteerdeLid.add(teamleden.get(i).getLid().getVoornaam() + " " + teamleden.get(i).getLid().getAchternaam());
                }
            }
        } else {
            geselecteerdeLid.add("Team heeft geen " + role);
        }
        return geselecteerdeLid;
    }

    public List<Lid> krijgAlleLedenInTeam(Team team) {
        List<Teamkoppel> teamleden = team.getKoppels();
        List<Lid> leden = new ArrayList<>();
        for (int i = 0; i < teamleden.size(); i++) {
            leden.add(teamleden.get(i).getLid());
        }
        return leden;
    }

    public void setTraining(Set<Training> training) {
        this.training = training;
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

    public String getTeamType() {
        return teamType;
    }

    public void setTeamType(String teamType) {
        this.teamType = teamType;
    }

    public boolean isWedstrijd() {
        return wedstrijd;
    }

    public void setWedstrijd(boolean wedstrijd) {
        this.wedstrijd = wedstrijd;
    }

    public int getSpeleraantal() {
        return speleraantal;
    }

    public List<Teamkoppel> getKoppels() {
        return koppels;
    }

    public void updateSpeleraantal(int spelerinvoer) {
        this.speleraantal = this.speleraantal + spelerinvoer;
    }
}
