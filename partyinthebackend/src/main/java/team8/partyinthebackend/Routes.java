package team8.partyinthebackend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ZJendex
 * @Time: 9/26/2020, Sat
 **/

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
}