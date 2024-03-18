package tn.esprit.demotransaction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.demotransaction.Entity.BankInfo;

import java.util.List;


@Repository
public interface BankRepository extends JpaRepository<BankInfo,Integer> {
   // @Query(value = "SELECT * FROM banks WHERE earth_distance(ll_to_earth(?1, ?2), ll_to_earth(bank_lat, bank_lng)) <= ?3", nativeQuery = true)
   @Query(value = "SELECT *, ( 6371 * acos( cos( radians(:latitude) ) * cos( radians( bank_lat ) ) * cos( radians( bank_lng ) - radians(:longitude) ) + sin( radians(:latitude) ) * sin( radians( bank_lat ) ) ) ) AS distance FROM bank_info HAVING distance <= :radius ORDER BY distance", nativeQuery = true)
   List<BankInfo> findNearbyBanks(@Param("latitude") double latitude,
                                  @Param("longitude") double longitude,
                                  @Param("radius") double radius);
}
//http://localhost:8080/banks/nearby?latitude=37.7749&longitude=-122.4194&radius=5