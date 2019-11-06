package clubsysteem.controller;

import clubsysteem.DTO.TrainingDTO;
import clubsysteem.domein.Lid;
import clubsysteem.domein.Team;
import clubsysteem.domein.Teamkoppel;
import clubsysteem.domein.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TrainingService {
    @Autowired
    TrainingRepository trainingRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    LidRepository lidRepository;

    public void deleteTraining(Long id) {
        trainingRepository.deleteById(id);
        System.out.println("training verwijderd");
    }

    public Iterable<TrainingDTO> geefMeTrainingen() {
        List <TrainingDTO> trainingDTO = new ArrayList<>();
        trainingRepository.findAll().forEach(training -> {trainingDTO.add(new TrainingDTO(training));});
        return trainingDTO;
    }

    public void trainingenMaken(Training trainingTemplate, int hoeveel, Long teamId) {
        Optional<Team> team = teamRepository.findById(teamId);
        Team team2 = team.get();
        Training eersteTraining = trainingTemplate;
        //trainingTemplate.setDag(trainingTemplate.getDag().plusDays(1));
        eersteTraining.setTeam(team2);
        trainingRepository.save(eersteTraining);
        LocalDate dag1 = eersteTraining.getDag();
        LocalTime time1 = eersteTraining.getTijd();
        System.out.println(dag1 + " " + time1);

        for (int i = 1; i < hoeveel; i++) {
            Training volgendeTraining = new Training();
            volgendeTraining.setDag(eersteTraining.getDag().plusDays(7 * i));
            volgendeTraining.setTijd(eersteTraining.getTijd());
            volgendeTraining.setTeam(eersteTraining.getTeam());
            volgendeTraining.setPlaats(eersteTraining.getPlaats());
            trainingRepository.save(volgendeTraining);
        }
    }

    public void voegLidToeAanTraining(Long lidId, Long trainingId) throws NoSuchElementException {
        try {
            Training training = trainingRepository.findById(trainingId).get();
            long teamIdTraining = training.getTeam().getId();
            Lid lid = lidRepository.findById(lidId).get();
            List<Training> trainingen = lid.getTrainingen();
            checkTraining:
            if (lidRepository.findById(lidId).isPresent() & trainingRepository.findById(trainingId).isPresent()) {
                for (int j = 0; j < trainingen.size(); j++) {
                    if (trainingen.get(j).getTeam().getId() == teamIdTraining) {
                        System.out.println("Persoon zit al in de training");
                        break checkTraining;
                    }
                }
                for (int i = 0; i < lid.getTeamkoppels().size(); i++) {
                    long teamIdLid = lid.getTeamkoppels().get(i).getTeam().getId();
                    String teamRoleLid = lid.getTeamkoppels().get(i).getRole();
                    if (teamIdLid == teamIdTraining & teamRoleLid.equals("Speler") | teamIdLid == teamIdTraining & teamRoleLid.equals("Trainer")) {
                        training.voegLidToe(lid);
                        if (teamRoleLid.equals("Trainer")) {
                        } else if (teamRoleLid.equals("Speler")) {
                        }
                        trainingRepository.save(training);
                        System.out.println("Lid toegevoegd aan training");

                    } else{
                        System.out.println("Persoon is geen speler of Trainer van dit team.");
                    }
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Training of lid bestaat niet.");
        }
    }

    public void updateTraining(Training updates) {
        trainingRepository.save(updates);
    }
}
