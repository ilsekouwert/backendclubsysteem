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

    @GetMapping("/teamlijst/vindteam/{teamId}")
    public TeamDTO vindTeam(@PathVariable Long teamId){
        return teamService.vindLid(teamId);
    }

    @PatchMapping(value = "/teamlijst")
    public void updateTeam(@RequestBody Team team){
        teamService.updateTeam(team);
    }

    @GetMapping(value = "/spelerslijst/zoekteam/{teamId}")
    public List<SpelerDTO> zoekTeam(@PathVariable Long teamId) {
        return teamService.vindTeamLeden(teamId);
    }

    @GetMapping(value = "/lidtoevoegenteam/{lidId}/{teamId}/{role}")
    public void lidNaarTeam(@PathVariable Long lidId, @PathVariable Long teamId, @PathVariable String role) {
        teamService.LidToevoegenTeam(lidId, teamId, role);
    }
}
