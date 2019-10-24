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

    public void saveAanmelding(Aanmelding aan){
        aan.calculateAge();
        aanmeldingRepository.save(aan);
    }

    public void deleteLid(Long id) {
        aanmeldingRepository.deleteById(id);
        System.out.println("in de functie verwijderd: " + id);
    }

    public Iterable<AanmeldingDTO> geefMeLeden() {
        List<AanmeldingDTO> ledenDTO = new ArrayList<>();
        aanmeldingRepository.findAll().forEach(lid -> {ledenDTO.add(new AanmeldingDTO(lid));
        });
        return ledenDTO;
    }

    public void updateLid(Aanmelding updates){
        aanmeldingRepository.save(updates);
    }

    /*public Iterable<Aanmelding> findByVoornaam(String voornaam){
        return aanmeldingRepository.findByVoornaam(voornaam);
    }*/

    public Iterable<Aanmelding> findByNiveau(String niveau, String geslacht){
        return aanmeldingRepository.findByNiveau(niveau, geslacht);
    }

    public void selectLid(Long lidId, Long teamId){
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
