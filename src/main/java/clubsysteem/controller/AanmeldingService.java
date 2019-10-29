package clubsysteem.controller;

import clubsysteem.DTO.AanmeldingDTO;
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
public class AanmeldingService {
    @Autowired
    AanmeldingRepository aanmeldingRepository;
    @Autowired
    TeamRepository teamRepository;

    public void saveAanmelding(Aanmelding aan) {
        aan.calculateAge();
        aanmeldingRepository.save(aan);
    }

    public void deleteLid(Long id) {
        aanmeldingRepository.deleteById(id);
    }

    public Iterable<AanmeldingDTO> geefMeLeden() {
        List<AanmeldingDTO> ledenDTO = new ArrayList<>();
        aanmeldingRepository.findAll().forEach(lid -> {
            ledenDTO.add(new AanmeldingDTO(lid));
        });
        return ledenDTO;
    }

    public List<SpelerDTO> findBySpeler(boolean speler){
        List <SpelerDTO> selectie = new ArrayList<>();
        aanmeldingRepository.findBySpeler(speler).forEach(lid -> {selectie.add(new SpelerDTO(lid));});
        return selectie;
    }


    public void updateLid(Aanmelding updates) {
        aanmeldingRepository.save(updates);
    }

    public List<AanmeldingDTO> findByNiveau(String niveau) {
        List<AanmeldingDTO> niveaus = new ArrayList<>();
        aanmeldingRepository.findByNiveau(niveau).forEach(lid -> {
            niveaus.add(new AanmeldingDTO(lid));
        });
        return niveaus;
    }

    public List<AanmeldingDTO> findByGeslacht(String geslacht) {
        List<AanmeldingDTO> geslachten = new ArrayList<>();
        aanmeldingRepository.findByGeslacht(geslacht).forEach(lid -> {
            geslachten.add(new AanmeldingDTO(lid));
        });
        return geslachten;
    }

    public List<AanmeldingDTO> findByPositiesContaining(String posities) {
        List<AanmeldingDTO> pos = new ArrayList<>();
        aanmeldingRepository.findByPositiesContaining(posities).forEach(lid -> {
            pos.add(new AanmeldingDTO(lid));
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

    public List<AanmeldingDTO> findByNiveauAndGeslacht(String niveau, String geslacht) {
        List<AanmeldingDTO> nivGesl = new ArrayList<>();
        aanmeldingRepository.findByNiveauAndGeslacht(niveau, geslacht).forEach(lid -> {
            nivGesl.add(new AanmeldingDTO(lid));
        });
        return nivGesl;
    }

    public List<AanmeldingDTO> findByNiveauAndGeslachtAndPositiesContaining(String niveau, String geslacht, String posities) {
        List<AanmeldingDTO> nivGesPos = new ArrayList<>();
        aanmeldingRepository.findByNiveauAndGeslachtAndPositiesContaining(niveau, geslacht, posities).forEach(lid -> {
            nivGesPos.add(new AanmeldingDTO(lid));
        });
        return nivGesPos;
    }

    public List<AanmeldingDTO> findByTeamId(Long team_id) {
        List<AanmeldingDTO> teamDTO = new ArrayList<>();
        aanmeldingRepository.findByTeamId(team_id).forEach(lid -> {
            teamDTO.add(new AanmeldingDTO(lid));
        });
        return teamDTO;
    }


    public void selectLid(Long lidId, Long teamId) {
        Optional<Aanmelding> aanmelding = aanmeldingRepository.findById(lidId);
        Optional<Team> team = teamRepository.findById(teamId);
        Aanmelding aanmelding2 = aanmelding.get();
        Team team2 = team.get();
        aanmelding2.setTeam(team2);
        aanmeldingRepository.save(aanmelding2);
        team2.updateSpeleraantal(1);
        teamRepository.save(team2);
    }

    public Iterable<TrainerDTO> findByTrainer(boolean trainer) {
        List <TrainerDTO> selectie = new ArrayList<>();
        aanmeldingRepository.findByTrainer(trainer).forEach(lid -> {selectie.add(new TrainerDTO(lid));});
        return selectie;
    }

    public Iterable<CoachDTO> findByCoach(boolean coach) {
        List <CoachDTO> selectie = new ArrayList<>();
        aanmeldingRepository.findByCoach(coach).forEach(lid -> {selectie.add(new CoachDTO(lid));});
        return selectie;

    }
}
