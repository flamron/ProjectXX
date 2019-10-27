package by.serahlazau.projectxx.service;

import by.serahlazau.projectxx.pojo.DeviceType;
import by.serahlazau.projectxx.repo.DeviceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceTypeService {

    @Autowired
    DeviceTypeRepository repository;

    public void createNewDeviceType() {
        DeviceType deviceType = new DeviceType();
        deviceType.setName("First device type");
        repository.save(deviceType);
    }
}
