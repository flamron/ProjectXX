package by.serahlazau.projectxx.controller;

import by.serahlazau.projectxx.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Root
{
    @Autowired
    DeviceTypeService deviceTypeService;

    @RequestMapping("/")
    String home() {
        return "Hello";
    }

}
