package by.serahlazau.projectxx.service;

import by.serahlazau.projectxx.pojo.DeviceModel;
import by.serahlazau.projectxx.repo.DeviceModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceModelService {

    @Autowired
    DeviceModelRepository deviceModelRepository;

    //@Cacheable("DeviceModel")
    public Optional<DeviceModel> findById(Long id) {
        return deviceModelRepository.findById(id);
    }
}
