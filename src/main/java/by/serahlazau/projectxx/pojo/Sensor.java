package by.serahlazau.projectxx.pojo;

import by.serahlazau.projectxx.pojo.Device;
import by.serahlazau.projectxx.pojo.UnitOfMeasure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Sensor {

   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    @EmbeddedId
    SensorId id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "measure_unit_id")
    private UnitOfMeasure unitOfMeasure;

    @OneToMany(mappedBy = "id.sensor", fetch = FetchType.LAZY)
    @MapKey(name = "id.localDateTime")
    private Map<LocalDateTime, SensorValue> values = new HashMap<>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class SensorId implements Serializable {
        @Column
        private Byte number;

        @ToString.Exclude
        @ManyToOne
        private Device device;
    }

}
