package by.serahlazau.projectxx.repo;

import by.serahlazau.projectxx.pojo.Sensor;
import org.springframework.data.repository.CrudRepository;

public interface SensorRepository extends CrudRepository<Sensor, Sensor.SensorId> {
}
