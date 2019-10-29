package clubsysteem.controller;

import clubsysteem.domein.Aanmelding;
import clubsysteem.domein.Coach;
import clubsysteem.domein.Team;
import clubsysteem.DTO.TeamDTO;
import clubsysteem.domein.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public Iterable<TeamDTO> geefMeTeams(){
        List<TeamDTO> teamDTO = new ArrayList<>();
        teamRepository.findAll().forEach(lid -> {teamDTO.add(new TeamDTO(lid));});
        return teamDTO;
    }

    public void updateTeam(Team teamupdates){
        teamRepository.save(teamupdates);
    }


    public void addTrainer(Long lidId, Long teamId) {
        Optional<Team> team = teamRepository.findById(teamId);
        Optional<Aanmelding> lid = aanmeldingRepository.findById(lidId);
        Team team2 = team.get();
        Aanmelding lid_aan = lid.get();
        Long trainer_id = lid_aan.getId();
        team2.setTrainer((Trainer) lid_aan);
        teamRepository.save(team2);
    }

    public void addCoach(Long lidId, Long teamId) {
        Optional<Team> team = teamRepository.findById(teamId);
        Optional<Aanmelding> lid = aanmeldingRepository.findById(lidId);
        Team team2 = team.get();
        Aanmelding lid_aan = lid.get();
        Long coach_id = lid_aan.getId();
        team2.setCoach((Coach) lid_aan);
        teamRepository.save(team2);
    }

    public List<TeamDTO> findByTrainer(Long trainerId){
        List<TeamDTO> selectie = new ArrayList<>();
        teamRepository.findByTrainerId(trainerId).forEach(lid -> {selectie.add(new TeamDTO(lid));});
    return selectie;
    }
}
