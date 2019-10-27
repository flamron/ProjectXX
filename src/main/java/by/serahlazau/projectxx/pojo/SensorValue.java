package by.serahlazau.projectxx.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class SensorValue {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;*/

    @EmbeddedId
    SensorValueId id;

    @Column
    Double value;

    @Embeddable
    public static class SensorValueId implements Serializable {
        @ManyToOne
        Sensor sensor;

        @Column
        LocalDateTime localDateTime;

    }

}
