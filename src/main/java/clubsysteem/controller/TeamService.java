package clubsysteem.controller;

import clubsysteem.domein.Aanmelding;
import clubsysteem.domein.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    AanmeldingRepository aanmeldingRepository;

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


    public void addTrainer(Long lidId, Long teamId) {
        Optional<Team> team = teamRepository.findById(teamId);
        Optional<Aanmelding> lid = aanmeldingRepository.findById(lidId);
        Team team2 = team.get();
        Aanmelding lid_aan = lid.get();
        String trainer_name = lid_aan.getVoornaam() + " " + lid_aan.getAchternaam() + " (id: " + lid_aan.getId() + ")" ;
        team2.setTrainer(trainer_name);
        teamRepository.save(team2);
    }

    public void addCoach(Long lidId, Long teamId) {
        Optional<Team> team = teamRepository.findById(teamId);
        Optional<Aanmelding> lid = aanmeldingRepository.findById(lidId);
        Team team2 = team.get();
        Aanmelding lid_aan = lid.get();
        String coach_name = lid_aan.getVoornaam() + " " + lid_aan.getAchternaam() + " (id: " + lid_aan.getId() + ")" ;
        team2.setCoach(coach_name);
        teamRepository.save(team2);
    }
}
