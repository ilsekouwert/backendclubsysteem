package clubsysteem.controller;

import clubsysteem.domein.Lid;
import clubsysteem.domein.Team;
import clubsysteem.domein.Teamkoppel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class LidServiceTests {

    @TestConfiguration
    static class testConfig{
        @Bean
        public LidService lidService() {
            return new LidService();
        }
    }

    @Autowired
    private LidService lidService;

    @MockBean
    private LidRepository lidRepository;
    @MockBean
    private TeamKoppelRepository teamKoppelRepository;
    @MockBean
    private TeamRepository teamRepository;

    @Before
    public void setUp() {
        Team team1 = new Team();
        team1.setId(1);
        Lid lid1 = new Lid();
        lid1.setId(2);
        Teamkoppel koppel1 = new Teamkoppel();
        koppel1.setId(3);
        koppel1.setTeam(team1);
        koppel1.setLid(lid1);

        List<Team> teams = new ArrayList<>();
        teams.add(team1);

        List<Lid> leden = new ArrayList<>();
        leden.add(lid1);

        List<Teamkoppel> koppels = new ArrayList<>();
        koppels.add(koppel1);

        when(teamRepository.findById(team1.getId()))
                .thenReturn(java.util.Optional.of((team1)));
        when(lidRepository.findById(lid1.getId()))
                .thenReturn(java.util.Optional.of((lid1)));

        when(teamKoppelRepository.findByTeamId(team1.getId()))
                .thenReturn(koppels);

        when(teamKoppelRepository.findByLidId(lid1.getId()))
                .thenReturn(koppels);
    }

    @Test
    public void koppelShouldByFoundByTeamId() {
        long teamid = 1;
        long lidid = 2;
        //List<Teamkoppel> kop = lidService.selectLid(lidid, teamid);
        //assertThat(kop).isEqualTo(teamKoppelRepository.findByTeamId(teamid));
    }

}
