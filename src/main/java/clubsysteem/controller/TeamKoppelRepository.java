package clubsysteem.controller;

import clubsysteem.domein.Teamkoppel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface TeamKoppelRepository extends JpaRepository<Teamkoppel, Long> {
    List<Teamkoppel> findByTeamId(Long teamId);
    List<Teamkoppel> findByLidId(Long lidId);
}
