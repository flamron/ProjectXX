package by.serahlazau.projectxx.pojo;

import by.serahlazau.projectxx.pojo.Device;
import by.serahlazau.projectxx.pojo.UnitOfMeasure;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String name;

    @ManyToOne
    @JoinColumn(name = "measure_unit_id")
    UnitOfMeasure unitOfMeasure;

    @OneToMany(mappedBy = "id.sensor")
    Set<SensorValue> values;

    @Column(name = "sensor_number")
    Byte number;

    @ManyToOne
    @JoinColumn(name = "device_serial_number")
    Device device;

}
