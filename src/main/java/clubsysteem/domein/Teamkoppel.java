package clubsysteem.domein;

import javax.persistence.*;

@Entity
@Table(name = "TEAMKOPPEL")
public class Teamkoppel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String role;

    @ManyToOne
    private Lid lid;

    @ManyToOne
    private Team team;

    public Teamkoppel(){};
    public Teamkoppel(Lid lid, Team team, String role){
        this.lid = lid;
        this.team = team;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Lid getLid() {
        return lid;
    }

    public void setLid(Lid lid) {
        this.lid = lid;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
