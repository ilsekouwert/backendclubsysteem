package clubsysteem.DTO;

import clubsysteem.controller.LidRepository;
import clubsysteem.domein.Lid;
import clubsysteem.domein.Team;
import org.springframework.beans.factory.annotation.Autowired;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class TeamDTO {
    @Autowired
    LidRepository lidRepository;

    long id;
    private String teamnaam;
    private String niveau;
    private Long trainerId;
    private String teamType;
    private Long coachId;
    private boolean wedstrijd;
    private int speleraantal;
    private Long trainerNaam;

    public TeamDTO(){}
    public TeamDTO(Team team) {
        this.teamnaam = team.getTeamnaam();
        this.id = team.getId();
        this.niveau = team.getNiveau();
        this.trainerNaam = trainerNaamKrijgen(team);
        //this.trainerId = team.getTrainer();
        this.teamType = team.getTeamType();
        //this.coachId = team.getCoach();
        this.speleraantal = team.getSpeleraantal();
    }



    public Long trainerNaamKrijgen(Team team){
        //Long trainerId = team.getTrainerId();
        Lid aan = lidRepository.findById(trainerId)
                .orElseThrow(()-> new NotImplementedException());
        System.out.println(trainerId);
        return trainerId;
    }

    public Long getTrainerNaam() {
        return trainerNaam;
    }

    public void setTrainerNaam(Long trainerNaam) {
        this.trainerNaam = trainerNaam;
    }

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

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
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

}
