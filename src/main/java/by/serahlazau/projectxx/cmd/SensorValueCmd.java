package by.serahlazau.projectxx.cmd;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class SensorValueCmd {
    private Byte sensorNumber;
    private LocalDateTime localDateTime;
    private Double value;
}
