package tn.esprit.demotransaction.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "place_name")
    private String placeName;
    @Column(name = "place_address")
    private String placeAddress;
    @Column(name = "place_city")
    private String placeCity;
    @Column(name = "place_img")
    private String placeImg;

    @Column(name = "place_lng")
    private double placeLng;
    @Column(name = "bank_lat")
    private double placeLat;

}
