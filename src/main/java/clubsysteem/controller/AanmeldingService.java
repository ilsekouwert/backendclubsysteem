package clubsysteem.controller;

import clubsysteem.domein.Aanmelding;
import clubsysteem.domein.AanmeldingDTO;
import clubsysteem.domein.Team;
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

    public void updateLid(Aanmelding updates) {
        aanmeldingRepository.save(updates);
    }

    public List<AanmeldingDTO> findByNiveauAndGeslacht(String niveau, String geslacht) {
        List<AanmeldingDTO> nivGesl = new ArrayList<>();
        aanmeldingRepository.findByNiveauAndGeslacht(niveau, geslacht).forEach(lid -> {
            nivGesl.add(new AanmeldingDTO());
        });
        return nivGesl;
    }

    public List<AanmeldingDTO> findByNiveau(String niveau) {
        List<AanmeldingDTO> niveaus = new ArrayList<>();
        aanmeldingRepository.findByNiveau(niveau).forEach(lid -> {
            niveaus.add(new AanmeldingDTO());
        });
        return niveaus;
    }

    public List<AanmeldingDTO> findByGeslacht(String geslacht) {
        List<AanmeldingDTO> geslachten = new ArrayList<>();
        aanmeldingRepository.findByGeslacht(geslacht).forEach(lid -> {
            geslachten.add(new AanmeldingDTO());
        });
        return geslachten;
    }

    public List<AanmeldingDTO> findByPositie(String posities) {
        List<AanmeldingDTO> pos = new ArrayList<>();
        aanmeldingRepository.findByPosities(posities).forEach(lid -> {pos.add(new AanmeldingDTO());}
        );
        return pos;
    }

    public List<AanmeldingDTO> findByTeamId(long team_id) {
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
    }


    /*public Iterable<Aanmelding> findByGeslacht(String geslacht){
        return aanmeldingRepository.findByGeslacht(geslacht);
    }*/


}
