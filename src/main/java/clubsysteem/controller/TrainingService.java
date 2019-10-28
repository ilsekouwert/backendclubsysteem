package clubsysteem.controller;

import clubsysteem.domein.Team;
import clubsysteem.domein.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class TrainingService {
    @Autowired
    TrainingRepository trainingRepository;
    @Autowired
    TeamRepository teamRepository;

    public void deleteTraining(Long id){
        trainingRepository.deleteById(id);
        System.out.println("training verwijderd");
    }

    public Iterable<Training> geefMeTrainingen(){
        return trainingRepository.findAll();
    }

    public void trainingenMaken(Training trainingTemplate, int hoeveel, Long teamId){
        Optional<Team> team = teamRepository.findById(teamId);
        Team team2 = team.get();
        Training eersteTraining = trainingTemplate;
        LocalDate dag1 = eersteTraining.getDag();
        LocalTime time1 = eersteTraining.getTijd();
        eersteTraining.setTeam(team2);
        trainingRepository.save(eersteTraining);

        System.out.println(dag1 + " " +time1);

        for (int i=1; i<hoeveel; i++){
            Training volgendeTraining = new Training();
            volgendeTraining.setDag(eersteTraining.getDag().plusDays(7*i));
            volgendeTraining.setTijd(eersteTraining.getTijd());
            volgendeTraining.setTeam(eersteTraining.getTeam());
            trainingRepository.save(volgendeTraining);
        }
    }

}
