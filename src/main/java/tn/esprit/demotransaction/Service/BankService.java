package tn.esprit.demotransaction.Service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tn.esprit.demotransaction.Controller.BankController;
import tn.esprit.demotransaction.Entity.BankInfo;
import tn.esprit.demotransaction.Repository.BankRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    @Test
    public BankInfo saveBank(BankInfo bank){
        return bankRepository.save(bank);
    }
   /* public List<BankInfo> getAllBanks(){
       return bankRepository.findAll();
    }

    */


    // Define the URL of the geolocation API endpoint
    private static final String GEOLOCATION_API_URL = "https://freegeoip.app/json/";

    @Test
    public List<BankInfo> findNearestBanks(double userLat, double userLng, double radius) {
       List<BankInfo> allBanks = bankRepository.findAll();
       List<BankInfo> nearbyBanks = new ArrayList<>();
       //BankController controller = new BankController();

       for (BankInfo bank : allBanks) {
           double distance = getRadius( userLng, userLat, bank.getBankLat(), bank.getBankLng());
           if (distance <= radius) {
               nearbyBanks.add(bank);
           }
       }

       return bankRepository.findNearbyBanks(userLat,userLng,radius);
   }
   @Test
    public double getRadius(double userLng, double userLat,double bankLat,double bankLng) {
        double R = 6731;// earth's radius in km
        double dLat = Math.toRadians(userLat - bankLat);
        double dLng =  Math.toRadians(userLng - bankLng);
        // Haversine formula
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(bankLat))
                + Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1 - a));
        double distance = R * c;
        return distance;



    }
    public List<BankInfo> getAllBankLocations() {
        List<BankInfo> bankLocations = new ArrayList<>();
        bankRepository.findAll().forEach(bankLocations::add);
        return bankLocations;
    }

}
