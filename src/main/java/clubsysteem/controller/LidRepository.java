package clubsysteem.controller;

import clubsysteem.domein.Lid;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface LidRepository extends CrudRepository<Lid, Long> {
    List<Lid> findByNiveauAndGeslacht(String niveau, String geslacht);
    List<Lid> findByNiveau(String niveau);
    List<Lid> findByNiveauAndPositiesContaining(String niveau, String posities);
    List<Lid> findByGeslacht(String geslacht);
    List<Lid> findByGeslachtAndPositiesContaining(String geslacht, String posities);
    List<Lid> findByPositiesContaining(String posities);
    List<Lid> findByNiveauAndGeslachtAndPositiesContaining(String niveau, String geslacht, String posities);
    List<Lid> findBySpeler(boolean speler);
    List<Lid> findByCoach(boolean coach);
    List<Lid> findByTrainer(boolean trainer);
}
