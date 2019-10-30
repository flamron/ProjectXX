package by.serahlazau.projectxx.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity

public class Device implements Serializable {
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
    @MapKey(name = "id.number")
    private Map<Byte, Sensor> sensorsMap = new HashMap<>();

    @ManyToOne
    private ObservationPoint observationPoint;


}
