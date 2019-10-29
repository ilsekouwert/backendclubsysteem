package clubsysteem;

import clubsysteem.domein.Aanmelding;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class voorbeeldTest {

    @Test
    public void contextLoads(){
        int a =3;
        int b=3;
        Assert.isTrue(a==b);
        Aanmelding aan = new Aanmelding();
        aan.setAchternaam("hallo");
        Assert.isTrue(aan.getAchternaam().equals("hallo"));

    }
}
