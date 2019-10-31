package clubsysteem.api;

import clubsysteem.DTO.SpelerDTO;
import clubsysteem.controller.TeamService;
import clubsysteem.domein.Team;
import clubsysteem.DTO.TeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TeamEndpoint {

    @Autowired
    TeamService teamService;

    @PostMapping("/team")
    public void saveTeam(@RequestBody Team team){
        teamService.saveTeam(team);
        System.out.println("team is ingevoerd");
    }

    @GetMapping("/teamlijst")
    public Iterable<TeamDTO> geefTeams(){
        return teamService.geefMeTeams();
    }

    @DeleteMapping (value="/teamlijst/{id}")
    public void deleteTeam(@PathVariable Long id){
        teamService.deleteTeam(id);
        System.out.println(id + " is deleted");
    }

    @PatchMapping(value = "/teamlijst")
    public void updateTeam(@RequestBody Team team){
        teamService.updateTeam(team);
    }

    @GetMapping(value = "/spelerslijst/zoekteam/{teamId}")
    public List<SpelerDTO> zoekTeam(@PathVariable Long teamId) {
        return teamService.vindTeamLeden(teamId);
    }

    @GetMapping(value = "/teamlijst/trainertoevoegen/{lidId}/{teamId}")
    public void trainerNaarTeam(@PathVariable Long lidId, @PathVariable Long teamId) {
        teamService.addTrainer(lidId, teamId);
    }

    @GetMapping(value = "/teamlijst/coachtoevoegen/{lidId}/{teamId}")
    public void coachNaarTeam(@PathVariable Long lidId, @PathVariable Long teamId) {
        teamService.addCoach(lidId, teamId);
    }

//    @GetMapping(value = "/teamlijst/trainervinden/{lidId}")
//    public Iterable<TeamDTO> trainerVinden(@PathVariable Long lidId){
//        System.out.println(lidId);
//        return teamService.findByTrainer(lidId);
//    }
}
