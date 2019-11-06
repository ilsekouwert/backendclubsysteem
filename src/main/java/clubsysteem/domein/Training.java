package clubsysteem.domein;

import javax.persistence.*;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TRAINING")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private LocalDate dag;
    private LocalTime tijd;
    private String plaats;

    @ManyToOne
    private Team team;

    @ManyToMany
    private List<Lid> lid;

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public List<Lid> getLid() {
        return lid;
    }

    public void setLid(List<Lid> lid) {
        this.lid = lid;
    }

    public void voegLidToe(Lid lid) {
        this.lid.add(lid);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Lid> krijgSpelersAanwezig(Training training) {
        long teamTrainingId = training.getTeam().getId();
        List<Lid> lijstKoppelsInTraining = training.getLid();
        List<Lid> spelersInTraining = new ArrayList<>();
        for (int i = 0; i < lijstKoppelsInTraining.size(); i++) {
            List<Teamkoppel> teamkoppelsSpeler = lijstKoppelsInTraining.get(i).getTeamkoppels();
            for (int j = 0; j < teamkoppelsSpeler.size(); j++) {
                if (teamkoppelsSpeler.get(j).getRole().equals("Speler") & teamkoppelsSpeler.get(j).getTeam().getId() == teamTrainingId) {
                    spelersInTraining.add(lijstKoppelsInTraining.get(i));
                }
            }
        }
        return spelersInTraining;
    }

    public List<String> krijgNamenSpelersAanwezig(Training training) {
        List<Lid> spelerlijstKoppels = krijgSpelersAanwezig(training);
        List<String> spelerslijstNamen = new ArrayList<>();
        if (spelerlijstKoppels.size() != 0) {
            for (int i = 0; i < spelerlijstKoppels.size(); i++) {
                String naam = spelerlijstKoppels.get(i).getVoornaam() + " " + spelerlijstKoppels.get(i).getAchternaam();
                System.out.println(naam);
                spelerslijstNamen.add(naam);
            }
        } else {
            spelerslijstNamen.add("Niemand in training");
            System.out.println("Er zit nog niemand in de training.");
        }
        return spelerslijstNamen;
    }

    public int krijgAantalSpelersAanwezig(Training training) {
        return krijgSpelersAanwezig(training).size();
    }

    public List<String> krijgNamemTrainerAanwezig(Training training) {
        long teamTrainingId = training.getTeam().getId();
        List<Lid> lijstKoppelsInTraining = training.getLid();
        List<String> trainersInTraining = new ArrayList<>();
        for (int i = 0; i < lijstKoppelsInTraining.size(); i++) {
            List<Teamkoppel> teamkoppelsSpeler = lijstKoppelsInTraining.get(i).getTeamkoppels();
            for (int j = 0; j < teamkoppelsSpeler.size(); j++) {
                if (teamkoppelsSpeler.get(j).getRole().equals("Trainer") & teamkoppelsSpeler.get(j).getTeam().getId() == teamTrainingId) {
                    trainersInTraining.add(lijstKoppelsInTraining.get(i).getVoornaam() + " " + lijstKoppelsInTraining.get(i).getAchternaam());
                }
            }
        }
        return trainersInTraining;
    }
}


