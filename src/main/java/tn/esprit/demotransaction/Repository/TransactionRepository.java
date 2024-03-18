package tn.esprit.demotransaction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demotransaction.Entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {


}
