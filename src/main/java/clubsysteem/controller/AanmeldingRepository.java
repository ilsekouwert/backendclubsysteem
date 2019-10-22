package clubsysteem.controller;

import clubsysteem.domein.Aanmelding;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AanmeldingRepository extends CrudRepository<Aanmelding, Long> {
    @Query(value = "SELECT * FROM AANMELDING WHERE VOORNAAM = ?1", nativeQuery = true)
    List<Aanmelding> findByVoornaam(String voornaam);

}
