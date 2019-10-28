package by.serahlazau.projectxx.controller;

import by.serahlazau.projectxx.service.CreateTestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateTestDataController {

    @Autowired
    CreateTestDataService createTestDataService;

    @GetMapping("/createTestData")
    public void createTestData(@RequestParam String deviceSerialNumber,
                               @RequestParam Integer seed) {
        createTestDataService.createTestData(deviceSerialNumber, seed);
    }

}
