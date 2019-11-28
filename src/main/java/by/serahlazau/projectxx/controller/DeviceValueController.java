package by.serahlazau.projectxx.controller;

import by.serahlazau.projectxx.cmd.DeviceValuesCmd;
import by.serahlazau.projectxx.service.DeviceValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceValueController {

    @Autowired
    DeviceValueService service;

    @PostMapping("/add")
    public void createNewDeviceValues(@RequestBody DeviceValuesCmd deviceValuesCmd) {
        service.addNewDeviceValues(deviceValuesCmd);
    }

    /*@GetMapping("/add")
    public void createNewDeviceValues(@RequestParam Integer integer) {
        service.addNewTest(integer);
    }*/
}
