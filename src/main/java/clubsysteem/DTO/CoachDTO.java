package clubsysteem.DTO;

import clubsysteem.domein.Lid;

import java.util.List;

public class CoachDTO {
    private long id;
    private String voornaam;
    private String achternaam;
    private String geslacht;
    private String niveau;
    private List<String> coachingTeamNamen;

    public CoachDTO(){}
    public CoachDTO(Lid lid) {
      this.id =  lid.getId();
      this.voornaam = lid.getVoornaam();
      this.achternaam = lid.getAchternaam();
      this.geslacht = lid.getGeslacht();
      this.coachingTeamNamen = lid.voorCoachZoekTeams(lid);
      this.niveau = lid.getNiveau();
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public List<String> getCoachingTeamNamen() {
        return coachingTeamNamen;
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

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
}
