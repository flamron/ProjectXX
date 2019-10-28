package by.serahlazau.projectxx.repo;

import by.serahlazau.projectxx.pojo.Device;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeviceRepository extends CrudRepository<Device, Long> {
    Optional<Device> findBySerialNumber(String deviceSerialNumber);
}
