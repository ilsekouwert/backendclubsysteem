package clubsysteem.controller;

import clubsysteem.domein.Aanmelding;
import clubsysteem.domein.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Iterable<Aanmelding> geefMeLeden() {
        return aanmeldingRepository.findAll();
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

    public void selectLid(){
        Optional<Aanmelding> aanmelding = aanmeldingRepository.findById(2L);
        Aanmelding aanmelding2 = aanmelding.get();
            Team hup = new Team();
            hup.setNiveau(2);
            Team a = teamRepository.save(hup);
            aanmelding2.setTeam(a);
            aanmeldingRepository.save(aanmelding2);
        // System.out.println(aanmelding.get().getVoornaam() + " " + aanmelding.get().getAge());
        System.out.println("het is gelukt");
    }

    /*public Iterable<Aanmelding> findByGeslacht(String geslacht){
        return aanmeldingRepository.findByGeslacht(geslacht);
    }*/


}
