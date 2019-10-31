package clubsysteem.DTO;

import clubsysteem.domein.Lid;

import java.util.List;

public class TrainerDTO {
    private long id;
    private String voornaam;
    private String achternaam;
    private String geslacht;
    private String niveau;
    private List<String> trainingTeamNamen;

    public TrainerDTO(){};
    public TrainerDTO(Lid lid){
        this.id = lid.getId();
        this.voornaam = lid.getVoornaam();
        this.achternaam = lid.getAchternaam();
        this.geslacht = lid.getGeslacht();
        this.niveau = lid.getNiveau();
        this.trainingTeamNamen = lid.voorTrainerZoekTeams(lid);
    }

    public List<String> getTrainingTeamNamen() {
        return trainingTeamNamen;
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

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

}
