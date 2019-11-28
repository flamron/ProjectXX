package by.serahlazau.projectxx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Root
{
    @RequestMapping("/")
    String home() {
        return "Hello";
    }
}
