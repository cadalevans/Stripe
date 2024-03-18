package tn.esprit.demotransaction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demotransaction.Entity.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Integer> {
    void deleteByPlaceName(String name);

    Place findByPlaceName(String name);
}
