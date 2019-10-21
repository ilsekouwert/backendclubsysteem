package clubsysteem.api;

import clubsysteem.controller.AanmeldingService;
import clubsysteem.domein.Aanmelding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AanmeldingEndpoint {

        @Autowired
        AanmeldingService aanmeldingService;

        @PostMapping("/aanmelding")
        public void saveAanmelding(@RequestBody Aanmelding aanmelding) {
            aanmeldingService.saveAanmelding(aanmelding);
            System.out.println("Persoon is aangemeld");
        }

        @GetMapping("/ledenlijst")
        public Iterable<Aanmelding> geefLeden() {
            return aanmeldingService.geefMeLeden();
        }

        @DeleteMapping (value = "/ledenlijst/{id}")
        public void deleteLid(@PathVariable Long id){
            aanmeldingService.deleteLid(id);
            System.out.println(id + " is verwijderd");
        };

        @PatchMapping(value = "/ledenlijst")
        public void updateLid(@RequestBody Aanmelding aanmelding){
            aanmeldingService.updateLid(aanmelding);
            System.out.println(aanmelding + " is geupdate");
        }
    }





