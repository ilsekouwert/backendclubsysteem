package clubsysteem.controller;

import clubsysteem.DTO.LidDTO;
import clubsysteem.DTO.CoachDTO;
import clubsysteem.DTO.SpelerDTO;
import clubsysteem.DTO.TrainerDTO;
import clubsysteem.domein.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class LidService {
    @Autowired
    LidRepository lidRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    TeamKoppelRepository teamKoppelRepository;
    @Autowired
    TeamKoppelService teamKoppelService;

    public void saveLid(Lid aan) {
        aan.calculateAge();
        lidRepository.save(aan);
    }

    public void deleteLid(Long id) {
        lidRepository.deleteById(id);
    }

    public Iterable<LidDTO> geefMeLeden() {
        List<LidDTO> ledenDTO = new ArrayList<>();
        lidRepository.findAll().forEach(lid -> {
            ledenDTO.add(new LidDTO(lid));
        });
        return ledenDTO;
    }

    public List<SpelerDTO> findBySpeler(boolean speler) {
        List<SpelerDTO> selectie = new ArrayList<>();
        lidRepository.findBySpeler(speler).forEach(lid -> {
            selectie.add(new SpelerDTO(lid));
        });
        return selectie;
    }


    public void updateLid(Lid updates) {
        lidRepository.save(updates);
    }

    public List<LidDTO> findByNiveau(String niveau) {
        List<LidDTO> niveaus = new ArrayList<>();
        lidRepository.findByNiveau(niveau).forEach(lid -> {
            niveaus.add(new LidDTO(lid));
        });
        return niveaus;
    }

    public List<LidDTO> findByGeslacht(String geslacht) {
        List<LidDTO> geslachten = new ArrayList<>();
        lidRepository.findByGeslacht(geslacht).forEach(lid -> {
            geslachten.add(new LidDTO(lid));
        });
        return geslachten;
    }

    public List<LidDTO> findByPositiesContaining(String posities) {
        List<LidDTO> pos = new ArrayList<>();
        lidRepository.findByPositiesContaining(posities).forEach(lid -> {
            pos.add(new LidDTO(lid));
        });
/*        for (int i = 0; i < posities.length(); i++) {
            String letter = posities.substring(i, i + 1);
            System.out.println(letter);
            aanmeldingRepository.findByPositiesContaining(letter).forEach(lid -> {
                pos.add(new AanmeldingDTO(lid));
            });
        }*/
        return pos;
    }

    public List<LidDTO> findByNiveauAndGeslacht(String niveau, String geslacht) {
        List<LidDTO> nivGesl = new ArrayList<>();
        lidRepository.findByNiveauAndGeslacht(niveau, geslacht).forEach(lid -> {
            nivGesl.add(new LidDTO(lid));
        });
        return nivGesl;
    }

    public List<LidDTO> findByNiveauAndGeslachtAndPositiesContaining(String niveau, String geslacht, String posities) {
        List<LidDTO> nivGesPos = new ArrayList<>();
        lidRepository.findByNiveauAndGeslachtAndPositiesContaining(niveau, geslacht, posities).forEach(lid -> {
            nivGesPos.add(new LidDTO(lid));
        });
        return nivGesPos;
    }

    public List<SpelerDTO> vindTeamLeden(Long team_id) {
        List<Lid> leden = teamKoppelService.krijgAlleLedenInTeam(team_id);
        List<SpelerDTO> spelers = new ArrayList<>();
        leden.forEach(lid -> {
            spelers.add(new SpelerDTO(lid));
        });
        return spelers;
    }

    public void selectLid(Long lidId, Long teamId) {
        Optional<Lid> lid = lidRepository.findById(lidId);
        Optional<Team> team = teamRepository.findById(teamId);
        List<Teamkoppel> teamkoppel = teamKoppelRepository.findByTeamId(teamId);
        List<Teamkoppel> lidkoppels = teamKoppelRepository.findByLidId(lidId);

        if (lid.isPresent() & team.isPresent()) {
            Lid geselecteerdLid = lid.get();
            Team geselecteerdTeam = team.get();
            if (teamkoppel.size() == 0 | lidkoppels.size() == 0) {
                Teamkoppel nieuweKoppel = new Teamkoppel(geselecteerdLid, geselecteerdTeam, "Speler");
                teamKoppelRepository.save(nieuweKoppel);
            } else {
                for (int i = 0; i < lidkoppels.size(); i++) {
                    if (lidkoppels.get(i).getRole().equals("Speler")) {
                        System.out.println("Deze persoon is al een speler in een ander team");
                        break;
                    } else {
                        Teamkoppel nieuweKoppel = new Teamkoppel(geselecteerdLid, geselecteerdTeam, "Speler");
                        teamKoppelRepository.save(nieuweKoppel);
                    }
                }

                for (int j = 0; j < teamkoppel.size(); j++) {
                    if (teamkoppel.get(j).getLid() == geselecteerdLid) {
                        System.out.println("Lid zit al in het team");
                        break;
                    }
                }
            }
        } else {
            System.out.println("lid of team bestaat niet");
        }
    }


    public Iterable<TrainerDTO> findByTrainer(boolean trainer) {
        List<TrainerDTO> selectie = new ArrayList<>();
        lidRepository.findByTrainer(trainer).forEach(lid -> {
            selectie.add(new TrainerDTO(lid));
        });
        return selectie;
    }

    public Iterable<CoachDTO> findByCoach(boolean coach) {
        List<CoachDTO> selectie = new ArrayList<>();
        lidRepository.findByCoach(coach).forEach(lid -> {
            selectie.add(new CoachDTO(lid));
        });
        return selectie;

    }
}
