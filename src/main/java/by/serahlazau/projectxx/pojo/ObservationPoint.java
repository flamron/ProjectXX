package by.serahlazau.projectxx.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
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

    @ToString.Exclude
    @OneToMany(mappedBy = "observationPoint")
    private Set<Device> devices = new HashSet<>();
}
