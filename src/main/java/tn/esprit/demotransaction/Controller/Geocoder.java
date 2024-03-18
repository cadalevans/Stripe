package tn.esprit.demotransaction.Controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Geocoder {
    @GetMapping("/test")
    public String test(){
        return "service up";
    }
}
