package clubsysteem.controller;

import clubsysteem.domein.Lid;
import clubsysteem.domein.Team;
import clubsysteem.domein.Teamkoppel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamKoppelService {
    @Autowired
    TeamKoppelRepository teamKoppelRepository;
    @Autowired
    LidRepository lidRepository;
    @Autowired
    TeamRepository teamRepository;

    public List<Team> krijgAlleTeamsVoorLid(Long lidId){
        List<Teamkoppel> koppelsvoorlid = teamKoppelRepository.findByLidId(lidId);
        List<Team> teams = new ArrayList<>();
        for (int i=0;i<koppelsvoorlid.size();i++){
            teams.add(koppelsvoorlid.get(i).getTeam());
        }
        return teams;
    }

}
