package team8.partyinthebackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public String index(){
        return "Hello World";
    }
    @RequestMapping("/home")
    public String home(){
        return "Homepage";
    }
    @GetMapping("/test")
    public String test() {
    	return "{\"success\":\"Hello React\"}";
    }
}