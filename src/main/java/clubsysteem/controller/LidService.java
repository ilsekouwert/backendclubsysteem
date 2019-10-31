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

    public void saveLid(Lid aan) {
        aan.calculateAge();
        lidRepository.save(aan);
    }

    public void deleteLid(Long id) {
        lidRepository.deleteById(id);
    }

    public void vindLid(Long id){
        lidRepository.findById(id);
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

    public List<LidDTO> findByGeslachtAndPositiesContaining(String geslacht, String posities) {
        List<LidDTO> gesPos = new ArrayList<>();
        lidRepository.findByGeslachtAndPositiesContaining(geslacht,posities).forEach(lid -> {gesPos.add(new LidDTO(lid));});
        return gesPos;
    }

    public List<LidDTO> findByNiveauAndPositiesContaining(String niveau, String posities){
        List<LidDTO> nivPos = new ArrayList<>();
        lidRepository.findByNiveauAndPositiesContaining(niveau, posities).forEach(lid -> {nivPos.add(new LidDTO(lid));});
        return nivPos;
    }

    public List<LidDTO> findByNiveauAndGeslachtAndPositiesContaining(String niveau, String geslacht, String posities) {
        List<LidDTO> nivGesPos = new ArrayList<>();
        lidRepository.findByNiveauAndGeslachtAndPositiesContaining(niveau, geslacht, posities).forEach(lid -> {
            nivGesPos.add(new LidDTO(lid));
        });
        return nivGesPos;
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
