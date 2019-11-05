package clubsysteem.DTO;

import clubsysteem.domein.Training;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TrainingDTO {
    long id;
    private LocalDate dag;
    private LocalTime tijd;
    private String plaats;
    private boolean trainerAanwezig;
    private List<String> namenSpelersAanwezig;
    private int aantalSpelersAanwezig;

    public TrainingDTO(Training training){
        this.id = training.getId();
        this.dag = training.getDag();
        this.tijd = training.getTijd();
        this.plaats = training.getPlaats();
        this.trainerAanwezig = training.isTrainerAanwezig();
        this.aantalSpelersAanwezig = training.getAantalSpelersAanwezig();
        this.namenSpelersAanwezig = training.krijgSpelersAanwezig(training);
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

    public boolean isTrainerAanwezig() {
        return trainerAanwezig;
    }

    public void setTrainerAanwezig(boolean trainerAanwezig) {
        this.trainerAanwezig = trainerAanwezig;
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
}
