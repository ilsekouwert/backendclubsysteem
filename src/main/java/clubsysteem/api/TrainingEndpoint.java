package clubsysteem.api;

import clubsysteem.DTO.TrainingDTO;
import clubsysteem.controller.TrainingService;
import clubsysteem.domein.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrainingEndpoint {

    @Autowired
    TrainingService trainingService;

    @GetMapping ("/trainingen")
    public Iterable<TrainingDTO> geefTraining() {
        return trainingService.geefMeTrainingen();
    }

    @DeleteMapping (value = "/trainingen/{id}")
    public void deleteTraining(@PathVariable Long id){
        trainingService.deleteTraining(id);
        System.out.println(id + " de training is verwijderd");
    }

    @PostMapping ("/trainingen/maaktraining/{hoeveel}/{teamId}")
    public void maakTraining(@RequestBody Training training, @PathVariable int hoeveel, @PathVariable Long teamId){
        trainingService.trainingenMaken(training, hoeveel, teamId);
        System.out.println("Trainingen gemaakt");
    }

    @PatchMapping("/training/updaten")
    public void updateTraining(@RequestBody Training training){
        trainingService.updateTraining(training);
        System.out.println(training + " is geupdate");
    }

    @GetMapping ("/training/voegtoe/{lidId}/{teamId}")
    public void spelerNaarTraining(@PathVariable Long lidId, @PathVariable Long teamId){
        trainingService.voegLidToeAanTraining(lidId, teamId);
    }
}
