package clubsysteem.api;

import clubsysteem.controller.AanmeldingService;
import clubsysteem.domein.Aanmelding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AanmeldingEndpoint {

        @Autowired
        AanmeldingService aanmeldingService;

        @PostMapping("/aanmelding")
        public void saveAanmelding(@RequestBody Aanmelding aanmelding) {
            aanmeldingService.saveAanmelding(aanmelding);
            System.out.println("Persoon is aangemeld");
        }

        /*@GetMapping(value = "/ledenlijst/selectie")
        public List<Aanmelding> geefSelectie (@RequestParam(value="search")String search){
            //je kan ook nog toevoegen aan hierboven (@RequestParam(value="mode")String mode) om specifieke selectie op een variabele door te voeren
            // if(mode.equals("voornaam")){
            return(List<Aanmelding>)aanmeldingService.findByVoornaam(search);
        *//*}else{
            return(List<Aanmelding>)aanmeldingService.geefMeLeden();
        }*//*
        }*/

       /* @GetMapping(value = "/ledenlijst/niveau")
        public List<Aanmelding> geefNiveau (@RequestParam(value="search")String search){
            return(List<Aanmelding>)aanmeldingService.findByNiveau(search);
        }*/

        @GetMapping(value = "/ledenlijst/niveaugeslacht")
        public List<Aanmelding> geefNiveauGeslacht (@RequestParam(value="niveau")String niveau, @RequestParam(value="geslacht") String geslacht) {
            System.out.println("selectie is goed uitgevoerd");
            return (List<Aanmelding>) aanmeldingService.findByNiveau(niveau, geslacht);
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

        @GetMapping(value="/test")
        public void test() {
            System.out.println("test");
            aanmeldingService.selectLid();
        }

}







