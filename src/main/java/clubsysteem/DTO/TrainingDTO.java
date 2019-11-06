package clubsysteem.DTO;

import clubsysteem.domein.Training;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TrainingDTO {
    long id;
    private String teamnaam;
    private LocalDate dag;
    private LocalTime tijd;
    private String plaats;
    private List<String> trainerAanwezig;
    private List<String> namenSpelersAanwezig;
    private int aantalSpelersAanwezig;

    public TrainingDTO(Training training){
        this.id = training.getId();
        this.dag = training.getDag();
        this.tijd = training.getTijd();
        this.plaats = training.getPlaats();
        this.trainerAanwezig = training.krijgNamemTrainerAanwezig(training);
        this.aantalSpelersAanwezig = training.krijgAantalSpelersAanwezig(training);
        this.namenSpelersAanwezig = training.krijgNamenSpelersAanwezig(training);
        this.teamnaam = training.getTeam().getTeamnaam();
    }

    public List<String> getTrainerAanwezig() {
        return trainerAanwezig;
    }
    
    public LocalDate getDag() {
        return dag;
    }

    public void setDag(LocalDate dag) {
        this.dag = dag;
    }

    public LocalTime getTijd() {
        return tijd;
    }

    public void setTijd(LocalTime tijd) {
        this.tijd = tijd;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public List<String> isTrainerAanwezig() {
        return trainerAanwezig;
    }

    public List<String> getNamenSpelersAanwezig() {
        return namenSpelersAanwezig;
    }

    public int getAantalSpelersAanwezig() {
        return aantalSpelersAanwezig;
    }

    public void setAantalSpelersAanwezig(int aantalSpelersAanwezig) {
        this.aantalSpelersAanwezig = aantalSpelersAanwezig;
    }

    public String getTeamnaam() {
        return teamnaam;
    }

    public void setTeamnaam(String teamnaam) {
        this.teamnaam = teamnaam;
    }
}
