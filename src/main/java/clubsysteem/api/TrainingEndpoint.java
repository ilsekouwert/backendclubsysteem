package clubsysteem.api;

import clubsysteem.controller.TrainingService;
import clubsysteem.domein.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrainingEndpoint {

    @Autowired
    TrainingService trainingService;

    @GetMapping ("/trainingen")
    public Iterable<Training> geefTraining() {
        return trainingService.geefMeTrainingen();
    }

    @DeleteMapping (value = "/trainingen/{id}")
    public void deleteTraining(@PathVariable Long id){
        trainingService.deleteTraining(id);
        System.out.println(id + " de training is verwijderd");
    }
}
