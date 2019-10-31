package clubsysteem.DTO;

import clubsysteem.domein.Lid;

public class TrainerDTO {
//    @Autowired
//    TeamService teamService;

    private long id;
    private String voornaam;
    private String achternaam;
    private String geslacht;
    private String niveau;
    //private List<String> trainingTeamNaam;

    public TrainerDTO(){};
    public TrainerDTO(Lid lid){
        this.id = lid.getId();
        this.voornaam = lid.getVoornaam();
        this.achternaam = lid.getAchternaam();
        this.geslacht = lid.getGeslacht();
        this.niveau = lid.getNiveau();
       // this.trainingTeamNaam = zoekTeamNaam(aanmelding);
    }

//    private List<String> zoekTeamNaam(Aanmelding aan) {
//        Long trainerselect = aan.getId();
//        System.out.println(aan.getId());
//
//        List<TeamDTO> alleTeams = teamService.findByTrainer(trainerselect);
//        System.out.println("in zoekteamnaam" + alleTeams);
//        List<String> teamNamen = new ArrayList<>();
//        for (int i = 0; i < alleTeams.size(); i++) {
//            teamNamen.add(alleTeams.get(i).getTeamnaam());
//        }
//        return teamNamen;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

//    public List<String> getTrainingTeamNaam() {
//        return trainingTeamNaam;
//    }
//
//    public void setTrainingTeamNaam(List<String> trainingTeamNaam) {
//        this.trainingTeamNaam = trainingTeamNaam;
//    }

}
