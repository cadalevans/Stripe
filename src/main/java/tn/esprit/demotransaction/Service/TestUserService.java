package tn.esprit.demotransaction.Service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import tn.esprit.demotransaction.Entity.TestUser;
import tn.esprit.demotransaction.Repository.TransactionRepository;
import tn.esprit.demotransaction.Repository.UserRepository;
import tn.esprit.demotransaction.model.EmailAlreadyExistsException;

import java.util.List;

@Service
public class TestUserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private TransactionRepository transactionRepository;
    /*
    @Transactional
    public TestUser createUserTrans(UserTransactionDto transactionDto){

        TestUser testUser = new TestUser();
        testUser.setUserName(transactionDto.getUserName());
        testUser.setUserSurName(transactionDto.getUserSurName());
        testUser.setUserEmail(transactionDto.getUserEmail());
        testUser.setUserNumber(transactionDto.getUserNumber());
        repository.save(testUser);

        // Create the transaction
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDto.getAmount());
        transaction.setCurrency(transactionDto.getCurrency());
        transaction.setStatus(transactionDto.getStatus());
        transaction.setTestUser(testUser);
        transactionRepository.save(transaction);

        return testUser;
    }


     */

    @Test
    public TestUser save(TestUser user) {
        // Check if the email already exists in the database
        if (emailExists(user.getEmail())) {
            // Handle the case where the email already exists, e.g., throw an exception or return an error response
            throw new EmailAlreadyExistsException("Email address already exists");
        }

        // If the email doesn't exist, save the user
        return repository.save(user);
    }

    @Test
    private boolean emailExists(String email) {
        // Use the repository's findByEmail method to check if an entry with the given email exists
        TestUser user = repository.findByEmail(email);
        return user != null; // If user is not null, the email exists
    }

    @Test
    public List<TestUser> getAll(){
        return repository.findAll();
    }
    public TestUser getById(int id){
        return repository.findById(id).orElse(null);
    }
    @Test
    public TestUser modify(TestUser user){
    TestUser user1= repository.findById(user.getUserId()).orElse(null);
   // user1.setUserEmail(user1.getUserEmail());
    user1.setUsername(user1.getUsername());
    //user1.setUserNumber(user1.getUserNumber());
    user1.setSurname(user1.getSurname());
    user1.setEmail(user1.getEmail());
    user1.setPassword(user1.getPassword());
    return repository.save(user1);
    }
    @Test
    public String deleteById(int id){
        repository.deleteById(id);
        return "user delete with id"+ id;
    }
}
