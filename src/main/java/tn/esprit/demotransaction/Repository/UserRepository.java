package tn.esprit.demotransaction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.demotransaction.Entity.TestUser;

public interface UserRepository extends JpaRepository<TestUser,Integer> {
    TestUser findByEmail(String email);
}
