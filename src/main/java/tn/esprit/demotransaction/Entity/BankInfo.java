package tn.esprit.demotransaction.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "bank_address")
    private String bankAddress;
    @Column(name = "bank_city")
    private String bankCity;
    @Column(name = "bank_state")
    private String bankState;
    @Column(name = "bank_zip_code")
    private int bankZipCode;
    @Column(name = "bank_lng")
    private double bankLng;
    @Column(name = "bank_lat")
    private double bankLat;


    @Column(name = "description")
    private String description;
    @ManyToMany
    private Set<TestUser> testUsers;

}


















   /* public double getRadius(double userLng, double userLat) {
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

    */