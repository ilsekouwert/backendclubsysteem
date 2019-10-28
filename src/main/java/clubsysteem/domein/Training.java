package clubsysteem.domein;

import javax.persistence.*;
import java.time.*;
import java.util.Set;

@Entity
@Table(name = "TRAINING")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private LocalDate dag;
    private LocalTime tijd;
    private String plaats;
    private boolean trainerAanwezig;

    @ManyToOne
    @JoinColumn(name = "teamId", nullable = true)
    private Team team;

    @ManyToMany
    @JoinColumn(name = "aanmeldingId", nullable = true)
    private Set<Aanmelding> aanmelding;

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public boolean isTrainerAanwezig() {
        return trainerAanwezig;
    }

    public void setTrainerAanwezig(boolean trainerAanwezig) {
        this.trainerAanwezig = trainerAanwezig;
    }

    public Set<Aanmelding> getAanmelding() {
        return aanmelding;
    }

    public void setAanmelding(Set<Aanmelding> aanmelding) {
        this.aanmelding = aanmelding;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDag() {
        return dag;
    }

    public void setDag(LocalDate dag) {
        this.dag = dag;
    }

    public LocalTime getTijd() {
        return tijd;
    }

    public void setTijd(LocalTime tijd) {
        this.tijd = tijd;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
