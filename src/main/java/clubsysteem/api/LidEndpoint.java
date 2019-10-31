package clubsysteem.api;

import clubsysteem.DTO.LidDTO;
import clubsysteem.DTO.CoachDTO;
import clubsysteem.DTO.SpelerDTO;
import clubsysteem.DTO.TrainerDTO;
import clubsysteem.controller.LidService;
import clubsysteem.domein.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class LidEndpoint {

    @Autowired
    LidService lidService;

    @PostMapping("/aanmelding")
    public void saveLid(@RequestBody Lid lid) {
        lidService.saveLid(lid);
        System.out.println("Persoon is aangemeld");
    }

    @DeleteMapping(value = "/ledenlijst/{id}")
    public void deleteLid(@PathVariable Long id) {
        lidService.deleteLid(id);
        System.out.println(id + " is verwijderd");
    }

    @PatchMapping(value = "/ledenlijst")
    public void updateLid(@RequestBody Lid lid) {
        lidService.updateLid(lid);
        System.out.println(lid + " is geupdate");
    }

    @GetMapping("/ledenlijst")
    public Iterable<LidDTO> geefLeden() {
        return lidService.geefMeLeden();
    }

    @GetMapping("/spelerslijst/{speler}")
    public Iterable<SpelerDTO> vindLeden(@PathVariable boolean speler){
        return lidService.findBySpeler(speler);
    }

    @GetMapping("/trainerslijst/{trainer}")
    public Iterable<TrainerDTO> vindTrainers(@PathVariable boolean trainer){
        return lidService.findByTrainer(trainer);
    }

    @GetMapping("/coachlijst/{coach}")
    public Iterable<CoachDTO> vindCoaches(@PathVariable boolean coach){
        return lidService.findByCoach(coach);
    }

    @GetMapping(value = "/spelerslijst/zoekgeslacht/{geslacht}")
    public List<LidDTO> geefGeslacht(@PathVariable String geslacht) {
        return lidService.findByGeslacht(geslacht);
    }

    @GetMapping(value = "/spelerslijst/zoekniveau/{niveau}")
    public List<LidDTO> geefNiveau(@PathVariable String niveau) {
        return lidService.findByNiveau(niveau);
    }

    @GetMapping(value = "/spelerslijst/zoekteam/{teamId}")
    public List<SpelerDTO> zoekTeam(@PathVariable Long teamId) {
        return lidService.vindTeamLeden(teamId);
    }

    @GetMapping(value = "/spelerslijst/zoekpositie/{posities}")
    public List<LidDTO> zoekposities(@PathVariable String posities) {
        return lidService.findByPositiesContaining(posities);
    }

    @GetMapping(value = "/spelerslijst/niveaugeslacht")
    public List<LidDTO> geefNiveauGeslacht(@RequestParam(value = "niveau") String niveau, @RequestParam(value = "geslacht") String geslacht) {
        System.out.println("selectie is goed uitgevoerd");
        return lidService.findByNiveauAndGeslacht(niveau, geslacht);
    }

    @GetMapping(value = "/spelerslijst/zoekcombo/{geslacht}/{niveau}/{positie}")
    public List<LidDTO> zoekCombo(@PathVariable String geslacht, @PathVariable String niveau, @PathVariable String positie) {
        return lidService.findByNiveauAndGeslachtAndPositiesContaining(niveau, geslacht, positie);
    }

    @GetMapping(value = "/lidtoevoegenteam/{lidId}/{teamId}")
    public void lidNaarTeam(@PathVariable Long lidId, @PathVariable Long teamId) {
        lidService.selectLid(lidId, teamId);
    }

}







