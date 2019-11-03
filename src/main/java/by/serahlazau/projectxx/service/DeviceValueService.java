package by.serahlazau.projectxx.service;

import by.serahlazau.projectxx.cmd.DeviceValuesCmd;
import by.serahlazau.projectxx.cmd.SensorValueCmd;
import by.serahlazau.projectxx.pojo.Device;
import by.serahlazau.projectxx.pojo.DeviceModel;
import by.serahlazau.projectxx.pojo.Sensor;
import by.serahlazau.projectxx.pojo.SensorValue;
import by.serahlazau.projectxx.repo.DeviceModelRepository;
import by.serahlazau.projectxx.repo.DeviceRepository;
import by.serahlazau.projectxx.repo.SensorRepository;
import by.serahlazau.projectxx.repo.SensorValueRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DeviceValueService {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    SensorRepository sensorRepository;

    @Autowired
    SensorValueRepository sensorValueRepository;

    /*private boolean validateSerialNumber(String serialNumber) {
        return deviceRepository.existsById(serialNumber);
    }*/

    /*@Value("${deviceValueService.NoSuchSensorPresent}")
    String val1;*/

    public void addNewDeviceValues(DeviceValuesCmd deviceValuesCmd) {

        String deviceSerialNumber = deviceValuesCmd.getSerialNumber();
        Optional<Device> od = deviceRepository.findBySerialNumber(deviceSerialNumber);
        if (od.isPresent()) {  // If device serial number is valid
            Device device = od.get();
            Map<Byte, Sensor> sensorsMap = device.getSensorsMap();
            for (SensorValueCmd cmd : deviceValuesCmd.getSensorValues()) { // For every sensorValue cmd

                Byte number = cmd.getSensorNumber();
                Sensor sensor = sensorsMap.get(number);
                if (sensor != null) { // If this sensor from cmd is really exists in the device
                    Double value = cmd.getValue();

                    // Create id = DateTime + Sensor
                    //SensorValue.SensorValueId svId = new SensorValue.SensorValueId(sensor, LocalDateTime.now());
                    LocalDateTime dt = cmd.getLocalDateTime();
                    if (dt == null)
                        dt = LocalDateTime.now();
                    SensorValue.SensorValueId svId = new SensorValue.SensorValueId(sensor, dt);

                    // Create SensorValue
                    SensorValue sv = new SensorValue(svId, value);

                    sensorValueRepository.save(sv);
                    //sensorValueRepository.saveOrUpdate(sv);

                } else {
                    logger.info(String.format(
                            "No such sensor present (Device serial numer='%s', sensor number = '%d')",
                            //val1,
                            deviceSerialNumber, number));
                }
            }
        } else {
            logger.info(String.format(
                    "No such device present (serial number='%s')",
                    //val1,
                    deviceSerialNumber));
        }
    }

    @Autowired
    DeviceModelService deviceModelService;


    public void addNewTest(Integer integer) {
        final Optional<DeviceModel> byId = deviceModelService.findById(Long.valueOf(integer));
        if (byId.isPresent()) {
            final DeviceModel deviceModel = byId.get();
            logger.info(deviceModel.getName());
        }
        else {
            logger.info("Нет такого");
        }

    }
}
