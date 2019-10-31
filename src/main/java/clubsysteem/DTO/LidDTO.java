package clubsysteem.DTO;

import clubsysteem.domein.Lid;

public class LidDTO {
    private long id;
    private String voornaam;
    private String achternaam;
    private long age;
    private String geslacht;
    private String posities;
    private String niveau;
    private boolean isSpeler;
    private boolean isTrainer;
    private boolean isCoach;
    private String teamNaam;

    public LidDTO(){}
    public LidDTO(Lid lid){
            this.id = lid.getId();
            this.voornaam = lid.getVoornaam();
            this.achternaam = lid.getAchternaam();
            this.age = lid.getAge();
            this.geslacht = lid.getGeslacht();
            this.posities = lid.getPosities();
            this.niveau = lid.getNiveau();
            this.isSpeler = lid.isSpeler();
            this.teamNaam = lid.krijgTeamNaam(lid);
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

    public boolean isTrainer() {
        return isTrainer;
    }

    public void setTrainer(boolean trainer) {
        isTrainer = trainer;
    }

    public boolean isCoach() {
        return isCoach;
    }

    public void setCoach(boolean coach) {
        isCoach = coach;
    }

    public boolean isSpeler() {
        return isSpeler;
    }

    public void setSpeler(boolean speler) {
        isSpeler = speler;
    }

    public String getTeamNaam() {
        return teamNaam;
    }
}
