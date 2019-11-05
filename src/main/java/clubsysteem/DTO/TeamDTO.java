package clubsysteem.DTO;

import clubsysteem.controller.TeamKoppelService;
import clubsysteem.domein.Team;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeamDTO {
    @Autowired
    TeamKoppelService teamKoppelService;

    long id;
    private String teamnaam;
    private String niveau;
    private String teamType;
    private boolean wedstrijd;
    private int speleraantal;
    private List<String> trainerNaam;
    private List<String> coachNaam;

    public TeamDTO(){}
    public TeamDTO(Team team) {
        this.teamnaam = team.getTeamnaam();
        this.id = team.getId();
        this.niveau = team.getNiveau();
        this.trainerNaam = team.krijgTrainerOfCoach(team, "Trainer");
        this.teamType = team.getTeamType();
        this.coachNaam = team.krijgTrainerOfCoach(team, "Coach");
        this.speleraantal = team.berekenSpelerAantal(team);
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

    public List<String> getTrainerNaam() {
        return trainerNaam;
    }

    public List<String> getCoachNaam() {
        return coachNaam;
    }
}
