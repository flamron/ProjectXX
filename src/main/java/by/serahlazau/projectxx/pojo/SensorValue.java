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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class SensorValue {

    @EmbeddedId
    private SensorValueId id;

    @Column
    private Double value;

    @Data
    @NoArgsConstructor
    @Embeddable
    public static class SensorValueId implements Serializable {
        @ManyToOne
        private Sensor sensor;

        @Column
        private LocalDateTime localDateTime;

    }

}
