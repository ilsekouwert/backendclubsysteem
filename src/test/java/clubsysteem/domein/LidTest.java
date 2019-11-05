package clubsysteem.domein;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class LidTest {
    @Test
    public void TestLidAchternaamOpslaan(){
        Lid lid = new Lid();
        lid.setAchternaam("TestAchternaam");
        assertThat(lid.getAchternaam()).isEqualTo("TestAchternaam");
    }

    @Test
    public void TestLidVoornaamOpslaan(){
        Lid lid = new Lid();
        lid.setVoornaam("TestVoornaam");
        assertThat(lid.getVoornaam()).isEqualTo("TestVoornaam");
    }

    @Test
    public void TestLidNiveauOpslaan(){
        Lid lid = new Lid();
        lid.setNiveau("1e Klasse");
        assertThat(lid.getNiveau()).isEqualTo("1e Klasse");
    }

    @Test
    public void TestLidGeslachtOpslaan(){
        Lid lid = new Lid();
        lid.setGeslacht("Vrouw");
        assertThat(lid.getGeslacht()).isEqualTo("Vrouw");
        }

    @Test
    public void TestLidTrainerOpslaan(){
        Lid lid = new Lid();
        lid.setTrainer(true);
        assertThat(lid.isTrainer()).isEqualTo(true);
    }

}
