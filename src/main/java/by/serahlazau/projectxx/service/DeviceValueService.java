package by.serahlazau.projectxx.service;

import by.serahlazau.projectxx.cmd.DeviceValuesCmd;
import by.serahlazau.projectxx.cmd.SensorValueCmd;
import by.serahlazau.projectxx.pojo.Device;
import by.serahlazau.projectxx.pojo.Sensor;
import by.serahlazau.projectxx.pojo.SensorValue;
import by.serahlazau.projectxx.repo.DeviceRepository;
import by.serahlazau.projectxx.repo.SensorRepository;
import by.serahlazau.projectxx.repo.SensorValueRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DeviceValueService {
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    SensorRepository sensorRepository;

    @Autowired
    SensorValueRepository sensorValueRepository;

    private boolean validateSerialNumber(String serialNumber) {
        return deviceRepository.existsById(serialNumber);
    }

    /*@Value("${deviceValueService.NoSuchSensorPresent}")
    String val1;*/

    public void addNewDeviceValues(DeviceValuesCmd deviceValuesCmd) {

        /*Optional<Device> od = deviceRepository.findById(deviceValuesCmd.getSerialNumber());
        // If device serial number is valid
        if (od.isPresent()) {
            Device device = od.get();
            // For every sensor in this device
            for (SensorValueCmd cmd : deviceValuesCmd.getSensorValues()) {
                Byte sensorNumber = cmd.getSensorNumber();
                Double value = cmd.getValue();
                Sensor.SensorId sensorId = new Sensor.SensorId(sensorNumber, device);
                Optional<Sensor> os = sensorRepository.findById(sensorId);
                // If sensor id is valid
                if (os.isPresent()) {
                    Sensor sensor = os.get();
                    SensorValue.SensorValueId svId = new SensorValue.SensorValueId();
                    // Create id = DateTime + Sensor
                    svId.setLocalDateTime(LocalDateTime.now());
                    svId.setSensor(sensor);
                    // Create SensorValue
                    SensorValue sv = new SensorValue();
                    sv.setId(svId);
                    sv.setValue(value);
                    sensorValueRepository.save(sv);

                } else {
                    logger.info(String.format(
                            //"No such sensor present (Device serial numer='%s', sensor number = '%d')",
                            val1,
                            device.getSerialNumber(), sensorNumber));
                }
            }
        } else {
            //TODO add to log
        }*/
    }
}
