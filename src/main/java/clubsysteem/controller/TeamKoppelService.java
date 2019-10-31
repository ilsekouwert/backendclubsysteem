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

    public List<Lid> krijgAlleLedenInTeam(Long teamId){
        List<Teamkoppel> koppelsvoorteam = teamKoppelRepository.findByTeamId(teamId);
        List<Lid> leden = new ArrayList<>();
        for (int i = 0; i < koppelsvoorteam.size(); i++) {
            leden.add(koppelsvoorteam.get(i).getLid());
        }
        return leden;
    }

    public List<Team> krijgAlleTeamsVoorLid(Long lidId){
        List<Teamkoppel> koppelsvoorlid = teamKoppelRepository.findByLidId(lidId);
        List<Team> teams = new ArrayList<>();
        for (int i=0;i<koppelsvoorlid.size();i++){
            teams.add(koppelsvoorlid.get(i).getTeam());
        }
        return teams;
    }
}
