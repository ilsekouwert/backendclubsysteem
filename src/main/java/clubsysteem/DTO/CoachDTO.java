package clubsysteem.DTO;

import clubsysteem.domein.Aanmelding;

public class CoachDTO {
    private long id;
    private String voornaam;
    private String achternaam;
    private String niveau;

    public CoachDTO(){}
    public CoachDTO(Aanmelding aanmelding) {
      this.id =  aanmelding.getId();
      this.voornaam = aanmelding.getVoornaam();
      this.achternaam = aanmelding.getAchternaam();
      this.niveau = aanmelding.getNiveau();
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
