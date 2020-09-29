package team8.partyinthebackend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: ZJendex
 * @Time: 9/26/2020, Sat
 **/

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Routes {
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