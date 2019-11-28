package by.serahlazau.projectxx;

import by.serahlazau.projectxx.cmd.DeviceValuesCmd;
import by.serahlazau.projectxx.cmd.SensorValueCmd;
import by.serahlazau.projectxx.pojo.SensorValue;
import by.serahlazau.projectxx.repo.SensorValueRepository;
import by.serahlazau.projectxx.service.DeviceValueService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Set;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Integration test to run the application.
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles("scratch")
@Transactional
public class ApplicationTest {
   @Autowired
    private WebApplicationContext context;

   private MockMvc mvc;

    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        sensorValueRepository.deleteAll();
    }

    @Test
    public void testHome() throws Exception {

        this.mvc.perform(get("/")).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello")));
    }

    @Autowired
    DeviceValueService deviceValueService;

    @Autowired
    SensorValueRepository sensorValueRepository;


    @Test
    public void addNewDeviceValues() {

        LocalDateTime localDateTime = LocalDateTime.now().withNano(0);
        SensorValueCmd sensorValueCmd = new SensorValueCmd();
        sensorValueCmd.setLocalDateTime(localDateTime);
        sensorValueCmd.setSensorNumber((byte)0);
        sensorValueCmd.setValue(10.5);
        Set<SensorValueCmd> myset = Set.of(sensorValueCmd);

        DeviceValuesCmd cmd = new DeviceValuesCmd();
        cmd.setSensorValues(myset);
        cmd.setSerialNumber("12346");

        deviceValueService.addNewDeviceValues(cmd);

        Iterable<SensorValue> all = sensorValueRepository.findAll();
        int counter = 0;
        for (SensorValue sensorValue : all) {
            assertEquals(localDateTime, sensorValue.getId().getLocalDateTime());
            SensorValue sensorValue1 = sensorValue.getId().getSensor().getValues().get(localDateTime);
            assertEquals(10.5, sensorValue.getValue(), 0.0001);
            counter++;
        }
        assertEquals(1, counter);

    }
}