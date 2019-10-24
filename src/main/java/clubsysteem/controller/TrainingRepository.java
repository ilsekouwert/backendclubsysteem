package clubsysteem.controller;

import clubsysteem.domein.Training;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TrainingRepository extends CrudRepository <Training, Long> {
}
