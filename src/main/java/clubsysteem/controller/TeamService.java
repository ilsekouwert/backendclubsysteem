package clubsysteem.controller;

import clubsysteem.domein.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    public void saveTeam(Team team){
        teamRepository.save(team);
    }

    public void deleteTeam(Long id){
        teamRepository.deleteById(id);
        System.out.println("team verwijderd " + id);
    }

    public Iterable<Team> geefMeTeams(){
        return teamRepository.findAll();
    }

    public void updateTeam(Team teamupdates){
        teamRepository.save(teamupdates);
    }
}
