package nl.woensdag.janbusker.repository;

import nl.woensdag.janbusker.model.Schip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface SchipRepository extends CrudRepository<Schip, Long> {
}
