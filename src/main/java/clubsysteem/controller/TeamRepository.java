package clubsysteem.controller;

import clubsysteem.domein.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TeamRepository extends JpaRepository<Team, Long> {
    //List<Team> findByTrainerId(Long trainerId);
}
