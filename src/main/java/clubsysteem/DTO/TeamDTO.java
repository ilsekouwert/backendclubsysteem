package clubsysteem.DTO;

import clubsysteem.controller.TeamKoppelService;
import clubsysteem.domein.Team;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamDTO {
    @Autowired
    TeamKoppelService teamKoppelService;

    long id;
    private String teamnaam;
    private String niveau;
    private String teamType;
    private boolean wedstrijd;
    private int speleraantal;
    private String trainerNaam;
    private String coachNaam;

    public TeamDTO(){}
    public TeamDTO(Team team) {
        this.teamnaam = team.getTeamnaam();
        this.id = team.getId();
        this.niveau = team.getNiveau();
        this.trainerNaam = team.krijgTrainerOfCoach(team, "Trainer");
        this.teamType = team.getTeamType();
        //this.coachNaam = krijgCoachnaam(team.getId());
        this.speleraantal = team.getSpeleraantal();
    }




//    public String krijgCoachnaam(long teamId){
//        Lid coach = teamKoppelService.krijgDeTrainerOfCoach(teamId, "Coach");
//        String coachNaam;
//        if (coach == null){
//            coachNaam = "Geen coach aangewezen";
//        } else {
//            coachNaam = coach.getVoornaam() + " "+ coach.getAchternaam();
//        }
//        return coachNaam;
//    }


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

    public String getTrainerNaam() {
        return trainerNaam;
    }

    public String getCoachNaam() {
        return coachNaam;
    }
}
