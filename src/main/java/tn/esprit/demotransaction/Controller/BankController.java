package tn.esprit.demotransaction.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demotransaction.Entity.BankInfo;
import tn.esprit.demotransaction.Service.BankService;

import java.util.List;

@RestController
@CrossOrigin("**")
public class BankController {

    @Autowired
   // private BankLocator bankLocator;
    private BankService bankService;
    @PostMapping("/Banks")
    public BankInfo addBank(@RequestBody BankInfo bank) {
        return bankService.saveBank(bank);
    }
    @GetMapping("/Banks/nearby")
    public List<BankInfo> getNearbyBanks(@RequestParam("latitude")double latitude
            , @RequestParam("longitude") double longitude, @RequestParam("radius") double radius){
        return bankService.findNearestBanks(latitude,longitude,radius);

    }

    @GetMapping("/getBank")
    public List<BankInfo> getAllBankLocations() {
        return bankService.getAllBankLocations();
    }


}
