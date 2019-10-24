package clubsysteem.controller;

import clubsysteem.domein.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {
    @Autowired
    TrainingRepository trainingRepository;

    public void deleteTraining(Long id){
        trainingRepository.deleteById(id);
        System.out.println("training verwijderd");
    }

    public Iterable<Training> geefMeTrainingen(){
        return trainingRepository.findAll();
    }

}
