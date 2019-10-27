package by.serahlazau.projectxx.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String serialNumber;

    @ManyToOne
    private DeviceType deviceType;

    @ManyToOne
    private DeviceModel deviceModel;

    @OneToMany(mappedBy = "id.device")
    private Set<Sensor> sensors;

    @ManyToOne
    private ObservationPoint observationPoint;


}
