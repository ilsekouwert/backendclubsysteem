package clubsysteem.domein;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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

    public List<Lid> krijgAlleSpelersInTeam(Team team) {
        List<Teamkoppel> teamleden = team.getKoppels();
        List<Lid> spelers = new ArrayList<>();
        for (int i = 0; i < teamleden.size(); i++) {
            if (teamleden.get(i).getRole().equals("Speler")){
                spelers.add(teamleden.get(i).getLid());}
        }
        return spelers;
    }

    public int berekenSpelerAantal(Team team){
        List<Lid> speler = krijgAlleSpelersInTeam(team);
        return speler.size();
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

    public List<Teamkoppel> getKoppels() {
        return koppels;
    }

}
