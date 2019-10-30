package by.serahlazau.projectxx.repo;

import by.serahlazau.projectxx.pojo.DeviceModel;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeviceModelRepository extends CrudRepository<DeviceModel, Long> {
}
