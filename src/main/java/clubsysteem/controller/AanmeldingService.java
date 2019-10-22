package clubsysteem.controller;

import clubsysteem.domein.Aanmelding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AanmeldingService {
    @Autowired
    AanmeldingRepository aanmeldingRepository;

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

    public Iterable<Aanmelding> findByVoornaam(String voornaam){
        return aanmeldingRepository.findByVoornaam(voornaam);
    }
}
