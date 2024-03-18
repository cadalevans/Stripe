package tn.esprit.demotransaction.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demotransaction.Entity.Place;
import tn.esprit.demotransaction.Service.PlaceService;

import java.util.List;
@CrossOrigin("**")
@RestController
public class PlaceController {
    @Autowired
    private PlaceService placeService;



    @PostMapping("/Place")
    public Place savePlace(@RequestBody Place place){return placeService.savePlace(place);}

    @GetMapping("getplace")
    public List<Place> getPlace(){return placeService.getPlace();}
    @GetMapping("/Getplace/{id}")
    public Place getPlaceById(@PathVariable("id")int id){return placeService.getPlaceById(id);}
    @GetMapping("/place/{name}")
    public Place getPlaceByName(@PathVariable("name")String name){return placeService.getPlaceByName(name);}
    @PutMapping("/update")
    public Place updatePlace(@RequestBody Place place){return placeService.updatePlace(place);}

    @DeleteMapping("delete/{id}")
    public String deletePlace(@PathVariable("id")int id){return placeService.deletePlace(id);}
    @DeleteMapping("remove/{name}")
    public String deletePlaceByName(@PathVariable("name") String name){return placeService.deletePlaceByName(name);}
}
