package clubsysteem.controller;

import clubsysteem.domein.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TeamRepository extends CrudRepository<Team, Long> {

}
