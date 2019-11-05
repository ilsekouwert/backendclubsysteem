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
import java.util.NoSuchElementException;
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
        List<Lid> leden = team.get().krijgAlleSpelersInTeam(team.get());
        List<SpelerDTO> spelers = new ArrayList<>();
        leden.forEach(lid -> {
            spelers.add(new SpelerDTO(lid));
        });
        return spelers;
    }

    public boolean containsRole(final List<Teamkoppel> list, final String role) {
        return list.stream().map(Teamkoppel::getRole).filter(role::equals).findFirst().isPresent();
    }

    public void LidToevoegenTeam(Long lidId, Long teamId, String role) throws NoSuchElementException {
        try {
            Optional<Lid> lid = lidRepository.findById(lidId);
            Optional<Team> team = teamRepository.findById(teamId);
            List<Teamkoppel> teamkoppel = team.get().getKoppels();
            List<Teamkoppel> lidkoppels = lid.get().getTeamkoppels();
            Lid geselecteerdLid = lid.get();
            Team geselecteerdTeam = team.get();

            if (lidkoppels.size() == 0) {
                Teamkoppel nieuweKoppel = new Teamkoppel(geselecteerdLid, geselecteerdTeam, role);
                teamKoppelRepository.save(nieuweKoppel);
            } else {
                switch (role) {
                    case "Speler":
                        for (Teamkoppel lidkoppel : lidkoppels) {
                            if (lidkoppel.getRole().equals(role)) {
                                System.out.println("Speler zit al in een team.");
                                return;
                            } else {
                                System.out.println("Kan Speler toevoegen. Teamid: " + lidkoppel.getTeam().getId() + " Speler id is: " + geselecteerdLid.getId());
                                Teamkoppel nieuweKoppel = new Teamkoppel(geselecteerdLid, geselecteerdTeam, role);
                                teamKoppelRepository.save(nieuweKoppel);
                            }
                        }
                        break;
                    case "Trainer": {
                        for (Teamkoppel lidkoppel : lidkoppels) {
                            if (lidkoppel.getRole().equals(role) && lidkoppel.getTeam().getId() == teamId) {
                                System.out.println("is al trainer van dit team");
                                return;
                            }
                        }
                        System.out.println("Trainer toegevoegd");
                        System.out.println("Trainer toegevoegd");
                        Teamkoppel nieuweKoppel = new Teamkoppel(geselecteerdLid, geselecteerdTeam, role);
                        teamKoppelRepository.save(nieuweKoppel);
                        break;
                    }
                    case "Coach": {
                        for (Teamkoppel lidkoppel : lidkoppels) {
                            if (lidkoppel.getRole().equals(role) && lidkoppel.getTeam().getId() == teamId) {
                                System.out.println("is al coach van dit team");
                                return;
                            }
                        }
                        System.out.println("Coach toegevoegd");
                        Teamkoppel nieuweKoppel = new Teamkoppel(geselecteerdLid, geselecteerdTeam, role);
                        teamKoppelRepository.save(nieuweKoppel);
                        break;
                    }
                }
            }
        } catch (
                NoSuchElementException e) {
            System.out.println("Lid of team bestaat niet");
        }

    }

    public TeamDTO vindLid(Long teamId) {
        TeamDTO team = new TeamDTO(teamRepository.findById(teamId).get());
        return team;
    }
}
