package clubsysteem.DTO;

import clubsysteem.domein.Aanmelding;

public class SpelerDTO {
    private long id;
    private String voornaam;
    private String achternaam;
    private long age;
    private String geslacht;
    private String posities;
    private String niveau;
    private long teamId;

    public SpelerDTO(Aanmelding aanmelding){
        this.id = aanmelding.getId();
        this.voornaam = aanmelding.getVoornaam();
        this.achternaam = aanmelding.getAchternaam();
        this.age = aanmelding.getAge();
        this.geslacht = aanmelding.getGeslacht();
        this.posities = aanmelding.getPosities();
        this.niveau = aanmelding.getNiveau();
        this.teamId = checkTeamId(aanmelding);
    }

    public long checkTeamId(Aanmelding aan){
        if(aan.getTeam()!=null)
            return aan.getTeam().getId();
        else
            return 0;}

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

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
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

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }
}
