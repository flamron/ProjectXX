package by.serahlazau.projectxx.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Device {
    @Id
    String serialNumber;

    @ManyToOne
    DeviceType deviceType;

    @ManyToOne
    DeviceModel deviceModel;

    @OneToMany(mappedBy = "device")
    Set<Sensor> sensors;

    @ManyToOne
    ObservationPoint observationPoint;


}
