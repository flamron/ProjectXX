package by.serahlazau.projectxx.service;

import by.serahlazau.projectxx.pojo.Device;
import by.serahlazau.projectxx.pojo.DeviceModel;
import by.serahlazau.projectxx.pojo.DeviceType;
import by.serahlazau.projectxx.pojo.Manufacturer;
import by.serahlazau.projectxx.pojo.ObservationPoint;
import by.serahlazau.projectxx.pojo.Sensor;
import by.serahlazau.projectxx.pojo.UnitOfMeasure;
import by.serahlazau.projectxx.repo.DeviceModelRepository;
import by.serahlazau.projectxx.repo.DeviceRepository;
import by.serahlazau.projectxx.repo.DeviceTypeRepository;
import by.serahlazau.projectxx.repo.ManufacturerRepository;
import by.serahlazau.projectxx.repo.ObservationPointRepository;
import by.serahlazau.projectxx.repo.SensorRepository;
import by.serahlazau.projectxx.repo.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CreateTestDataService {
    @Autowired
    DeviceTypeRepository deviceTypeRepository;

    @Autowired
    ManufacturerRepository manufacturerRepository;

    @Autowired
    DeviceModelRepository deviceModelRepository;

    @Autowired
    ObservationPointRepository observationPointRepository;

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    SensorRepository sensorRepository;

    public void createTestData(String deviceSerialNumber, Integer seed) {
        Manufacturer abuDabu = new Manufacturer();
        abuDabu.setName("Abu-dabu devices producer" + seed);
        abuDabu = manufacturerRepository.save(abuDabu);

        DeviceType seismograph = new DeviceType();
        seismograph.setName("Seismograph" + seed);
        seismograph = deviceTypeRepository.save(seismograph);

        DeviceModel m225 = new DeviceModel();
        m225.setManufacturer(abuDabu);
        m225.setName("m225" + seed);
        m225 = deviceModelRepository.save(m225);

        ObservationPoint bor = new ObservationPoint();
        bor.setFullName("Boyary" + seed);
        bor.setShortName("BOR" + seed);
        bor.setLatitude(53.25f);
        bor.setLongitude(27.16f);
        bor.setHigh(123.0f);
        bor = observationPointRepository.save(bor);

        Device seis04 = new Device();
        seis04.setDeviceModel(m225);
        seis04.setDeviceType(seismograph);
        seis04.setObservationPoint(bor);
        seis04.setSerialNumber(deviceSerialNumber);
        seis04 = deviceRepository.save(seis04);

        UnitOfMeasure count = new UnitOfMeasure();
        count.setFullName("Count" + seed);
        count.setShortName("count" + seed);
        count = unitOfMeasureRepository.save(count);

        Sensor.SensorId sensorId = new Sensor.SensorId();
        sensorId.setNumber((byte)0);
        sensorId.setDevice(seis04);

        Sensor gpsLevel = new Sensor();
        gpsLevel.setName("GPS level" + seed);
        gpsLevel.setUnitOfMeasure(count);
        gpsLevel.setId(sensorId);
        gpsLevel = sensorRepository.save(gpsLevel);
    }

}
