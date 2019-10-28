package clubsysteem.controller;

import clubsysteem.domein.Aanmelding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AanmeldingRepository extends JpaRepository<Aanmelding, Long> {
    List<Aanmelding> findByNiveauAndGeslacht(String niveau, String geslacht);
    List<Aanmelding> findByNiveau(String niveau);
    List<Aanmelding> findByGeslacht(String geslacht);
    List<Aanmelding> findByTeamId(long team_id);
    List<Aanmelding> findByPosities(String posities);
    List<Aanmelding> findByVoornaam(String voornaam);



}
