package clubsysteem.controller;

import clubsysteem.DTO.SpelerDTO;
import clubsysteem.domein.Lid;
import clubsysteem.domein.Team;
import clubsysteem.DTO.TeamDTO;
import clubsysteem.domein.Teamkoppel;
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
    LidRepository lidRepository;
    @Autowired
    TeamKoppelRepository teamKoppelRepository;

    public void saveTeam(Team team) {
        teamRepository.save(team);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
        System.out.println("team verwijderd " + id);
    }

    public Iterable<TeamDTO> geefMeTeams() {
        List<TeamDTO> teamDTO = new ArrayList<>();
        teamRepository.findAll().forEach(team -> {
            teamDTO.add(new TeamDTO(team));
        });
        return teamDTO;
    }

    public void updateTeam(Team teamupdates) {
        teamRepository.save(teamupdates);
    }

    public List<SpelerDTO> vindTeamLeden(Long team_id) {
        Optional<Team> team = teamRepository.findById(team_id);
        List<Lid> leden = team.get().krijgAlleLedenInTeam(team.get());
        List<SpelerDTO> spelers = new ArrayList<>();
        leden.forEach(lid -> {
            spelers.add(new SpelerDTO(lid));
        });
        return spelers;
    }

    public void LidToevoegenTeam(Long lidId, Long teamId, String role) {
        Optional<Lid> lid = lidRepository.findById(lidId);
        Optional<Team> team = teamRepository.findById(teamId);
        List<Teamkoppel> teamkoppel = team.get().getKoppels();
        List<Teamkoppel> lidkoppels = lid.get().getTeamkoppels();

        if (lid.isPresent() & team.isPresent()) {
            Lid geselecteerdLid = lid.get();
            Team geselecteerdTeam = team.get();
            if (lidkoppels.size() == 0) {
                Teamkoppel nieuweKoppel = new Teamkoppel(geselecteerdLid, geselecteerdTeam, role);
                teamKoppelRepository.save(nieuweKoppel);
            } else {
                if (role.equals("Speler")) {
                    checkspeler:
                    for (int i = 0; i < lidkoppels.size(); i++) {
                        if (lidkoppels.get(i).getRole().equals(role)) {
                            break checkspeler;
                        }
                    }
                } else if (role.equals("Trainer") | role.equals("Coach")) {
                    checkteam:
                    for (int i = 0; i < lidkoppels.size(); i++) {
                        if (lidkoppels.get(i).getTeam().equals(geselecteerdTeam) & lidkoppels.get(i).getRole().equals(role)) {
                            break checkteam;
                        }else if (!lidkoppels.get(i).getRole().equals(role)){
                            continue;
                        }
                        else {
                            Teamkoppel nieuweKoppel = new Teamkoppel(geselecteerdLid, geselecteerdTeam, role);
                            teamKoppelRepository.save(nieuweKoppel);
                        }
                    }
                }
            }
        } else {
            System.out.println("lid of team bestaat niet");
        }
    }

    public TeamDTO vindLid(Long teamId) {
        TeamDTO team = new TeamDTO(teamRepository.findById(teamId).get());
        return team;
    }
}
