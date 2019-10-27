package by.serahlazau.projectxx.cmd;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SensorValueCmd {
    private Byte sensorNumber;
    private Double value;
}
