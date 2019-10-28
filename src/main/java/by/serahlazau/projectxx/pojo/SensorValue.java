package by.serahlazau.projectxx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
@AllArgsConstructor
@Entity
public class SensorValue {

    @EmbeddedId
    private SensorValueId id;

    @Column
    private Double value;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class SensorValueId implements Serializable {
        @ToString.Exclude
        @ManyToOne
        private Sensor sensor;

        @Column
        private LocalDateTime localDateTime;

    }

}
