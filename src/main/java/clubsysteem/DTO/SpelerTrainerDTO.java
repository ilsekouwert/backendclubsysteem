package clubsysteem.DTO;

import clubsysteem.domein.Lid;

import java.util.List;

public class SpelerTrainerDTO {
    private long id;
    private String Naam;
    private String isSpelerInTeam;
    private List<String> isTrainerInTeam;


    public SpelerTrainerDTO(Lid lid){
        this.id = lid.getId();
        this.Naam = lid.getVoornaam() + " " + lid.getAchternaam();
        this.isSpelerInTeam = lid.krijgTeamNaam(lid);
        this.isTrainerInTeam = lid.voorTrainerZoekTeams(lid);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaam() {
        return Naam;
    }

    public void setNaam(String naam) {
        Naam = naam;
    }

    public String getTeamNaam() {
        return isSpelerInTeam;
    }

    public void setTeamNaam(String teamNaam) {
        this.isSpelerInTeam = teamNaam;
    }

    public List<String> getIsTrainerInTeams() {
        return isTrainerInTeam;
    }

    public void setIsTrainerInTeams(List<String> isTrainerInTeams) {
        this.isTrainerInTeam = isTrainerInTeams;
    }
}
