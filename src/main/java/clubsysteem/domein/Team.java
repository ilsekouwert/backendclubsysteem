package clubsysteem.domein;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TEAM")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String teamnaam;
    private String niveau;
    //private Long trainerId;
    private String teamType;
    //private Long coachId;
    private boolean wedstrijd;
    private int speleraantal;

    @OneToMany (mappedBy = "team")
    private Set<Teamkoppel> koppels;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Training> training;

    public Set<Training> getTraining() {
        return training;
    }

    public void setTraining(Set<Training> training) {
        this.training = training;
    }

//    public Set<Lid> getLid() {
//        return lid;
//    }
//
//    public void setLid(Set<Lid> lid) {
//        this.lid = lid;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeamnaam() {
        return teamnaam;
    }

    public void setTeamnaam(String teamnaam) {
        this.teamnaam = teamnaam;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getTeamType() {
        return teamType;
    }

    public void setTeamType(String teamType) {
        this.teamType = teamType;
    }

    public boolean isWedstrijd() {
        return wedstrijd;
    }

    public void setWedstrijd(boolean wedstrijd) {
        this.wedstrijd = wedstrijd;
    }

    public int getSpeleraantal() {
        return speleraantal;
    }

  /*  public void setSpeleraantal(int speleraantal) {
        this.speleraantal = speleraantal;
    }*/

    public void updateSpeleraantal(int spelerinvoer) {
        this.speleraantal = this.speleraantal + spelerinvoer;
    }
}
