package clubsysteem.api;

import clubsysteem.controller.TeamService;
import clubsysteem.domein.Team;
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
    public Iterable<Team> geefTeams(){
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
}
