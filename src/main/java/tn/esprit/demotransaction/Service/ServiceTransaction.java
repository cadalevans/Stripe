package tn.esprit.demotransaction.Service;

import org.junit.Test;
import org.springframework.stereotype.Service;
import tn.esprit.demotransaction.Entity.TestUser;
import tn.esprit.demotransaction.Entity.Transaction;
import tn.esprit.demotransaction.Repository.TransactionRepository;
import tn.esprit.demotransaction.Repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;

@Service
public class ServiceTransaction {


    private  UserRepository userRepository;
    private  TransactionRepository transactionRepository;


    public ServiceTransaction(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Test
    public Transaction createTransaction(int userId, Long amount) {
            TestUser user = userRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
            Transaction transaction = new Transaction();
            transaction.setTestUser(user);
            transaction.setAmount(amount);
            return transactionRepository.save(transaction);
        }

}
