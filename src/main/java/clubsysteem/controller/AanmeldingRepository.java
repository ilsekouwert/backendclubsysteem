package clubsysteem.controller;

import clubsysteem.domein.Aanmelding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AanmeldingRepository extends CrudRepository<Aanmelding, Long> {
    List<Aanmelding> findByNiveauAndGeslacht(String niveau, String geslacht);
    List<Aanmelding> findByNiveau(String niveau);
    List<Aanmelding> findByGeslacht(String geslacht);
    List<Aanmelding> findByTeamId(Long team_id);
    List<Aanmelding> findByPositiesContaining(String posities);
    List<Aanmelding> findByNiveauAndGeslachtAndPositiesContaining(String niveau, String geslacht, String posities);
    List<Aanmelding> findBySpeler(boolean speler);
    List<Aanmelding> findByCoach(boolean coach);
    List<Aanmelding> findByTrainer(boolean trainer);
}
