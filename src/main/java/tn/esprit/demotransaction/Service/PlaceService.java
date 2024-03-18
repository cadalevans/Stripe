package tn.esprit.demotransaction.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import tn.esprit.demotransaction.Entity.BankInfo;
import tn.esprit.demotransaction.Entity.Place;
import tn.esprit.demotransaction.Repository.PlaceRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    public Place savePlace(Place place){
        return placeRepository.save(place);
    }

    public  List<Place> getPlace(){return placeRepository.findAll();}

    public Place getPlaceById(int id){return placeRepository.findById(id).orElse(null);}

    public Place getPlaceByName(String name){return placeRepository.findByPlaceName(name);}
    public String deletePlace(int id){ placeRepository.deleteById(id);
        return "Success Delete Place "+id;}
    public String deletePlaceByName(String name){placeRepository.deleteByPlaceName(name);
        return "Success Delete Place "+name;}

    public Place updatePlace(Place place){

        Place existingPlace = placeRepository.findById(place.getId()).orElse(null);
        existingPlace.setPlaceCity(place.getPlaceCity());
        existingPlace.setPlaceAddress(place.getPlaceAddress());
        existingPlace.setPlaceImg(place.getPlaceImg());
        existingPlace.setPlaceLng(place.getPlaceLng());
        existingPlace.setPlaceLat(place.getPlaceLat());
        existingPlace.setPlaceName(place.getPlaceName());
        return placeRepository.save(existingPlace);
    }



}


