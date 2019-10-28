package clubsysteem.domein;

import javax.persistence.*;
import java.time.*;

@Entity
@Table(name="TRAINING")
public class Training{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private LocalDate dag;
    private LocalTime tijd;

}
