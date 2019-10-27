package by.serahlazau.projectxx.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class ObservationPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String shortName;

    @Column
    String fullName;

    @Column
    Float latitude;

    @Column
    Float longitude;

    @Column
    Float high;

    @OneToMany(mappedBy = "observationPoint")
    Set<Device> devices;
}
