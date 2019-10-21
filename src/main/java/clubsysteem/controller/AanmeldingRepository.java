package clubsysteem.controller;

import clubsysteem.domein.Aanmelding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AanmeldingRepository extends CrudRepository<Aanmelding, Long> {
}
