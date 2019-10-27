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
    private Long id;

    @Column
    private String shortName;

    @Column
    private String fullName;

    @Column
    private Float latitude;

    @Column
    private Float longitude;

    @Column
    private Float high;

    @OneToMany(mappedBy = "observationPoint")
    private Set<Device> devices;
}
