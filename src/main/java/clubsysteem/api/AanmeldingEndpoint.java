package clubsysteem.api;

import clubsysteem.DTO.AanmeldingDTO;
import clubsysteem.DTO.CoachDTO;
import clubsysteem.DTO.SpelerDTO;
import clubsysteem.DTO.TrainerDTO;
import clubsysteem.controller.AanmeldingService;
import clubsysteem.domein.*;
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

    @DeleteMapping(value = "/ledenlijst/{id}")
    public void deleteLid(@PathVariable Long id) {
        aanmeldingService.deleteLid(id);
        System.out.println(id + " is verwijderd");
    }

    @PatchMapping(value = "/ledenlijst")
    public void updateLid(@RequestBody Aanmelding aanmelding) {
        aanmeldingService.updateLid(aanmelding);
        System.out.println(aanmelding + " is geupdate");
    }

    @GetMapping("/ledenlijst")
    public Iterable<AanmeldingDTO> geefLeden() {
        return aanmeldingService.geefMeLeden();
    }

    @GetMapping("/spelerslijst/{speler}")
    public Iterable<SpelerDTO> vindLeden(@PathVariable boolean speler){
        return aanmeldingService.findBySpeler(speler);
    }

    @GetMapping("/trainerslijst/{trainer}")
    public Iterable<TrainerDTO> vindTrainers(@PathVariable boolean trainer){
        return aanmeldingService.findByTrainer(trainer);
    }

    @GetMapping("/coachlijst/{coach}")
    public Iterable<CoachDTO> vindCoaches(@PathVariable boolean coach){
        return aanmeldingService.findByCoach(coach);
    }

    @GetMapping(value = "/spelerslijst/zoekgeslacht/{geslacht}")
    public List<AanmeldingDTO> geefGeslacht(@PathVariable String geslacht) {
        return aanmeldingService.findByGeslacht(geslacht);
    }

    @GetMapping(value = "/spelerslijst/zoekniveau/{niveau}")
    public List<AanmeldingDTO> geefNiveau(@PathVariable String niveau) {
        return aanmeldingService.findByNiveau(niveau);
    }

    @GetMapping(value = "/spelerslijst/zoekteam/{teamId}")
    public List<AanmeldingDTO> zoekTeam(@PathVariable Long teamId) {
        return aanmeldingService.findByTeamId(teamId);
    }

    @GetMapping(value = "/spelerslijst/zoekpositie/{posities}")
    public List<AanmeldingDTO> zoekposities(@PathVariable String posities) {
        return aanmeldingService.findByPositiesContaining(posities);
    }

    @GetMapping(value = "/spelerslijst/niveaugeslacht")
    public List<AanmeldingDTO> geefNiveauGeslacht(@RequestParam(value = "niveau") String niveau, @RequestParam(value = "geslacht") String geslacht) {
        System.out.println("selectie is goed uitgevoerd");
        return aanmeldingService.findByNiveauAndGeslacht(niveau, geslacht);
    }

    @GetMapping(value = "/spelerslijst/zoekcombo/{geslacht}/{niveau}/{positie}")
    public List<AanmeldingDTO> zoekCombo(@PathVariable String geslacht, @PathVariable String niveau, @PathVariable String positie) {
        return aanmeldingService.findByNiveauAndGeslachtAndPositiesContaining(niveau, geslacht, positie);
    }

    @GetMapping(value = "/lidtoevoegenteam/{lidId}/{teamId}")
    public void lidNaarTeam(@PathVariable Long lidId, @PathVariable Long teamId) {
        aanmeldingService.selectLid(lidId, teamId);
    }

}







