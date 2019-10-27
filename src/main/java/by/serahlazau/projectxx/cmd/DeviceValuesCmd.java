package by.serahlazau.projectxx.cmd;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class DeviceValuesCmd {
    private String serialNumber;
    private Set<SensorValueCmd> sensorValues;
}
