package tn.esprit.demotransaction.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tn.esprit.demotransaction.Entity.Status;
import tn.esprit.demotransaction.Entity.TestUser;
import tn.esprit.demotransaction.Entity.Transaction;
import tn.esprit.demotransaction.Repository.TransactionRepository;
import tn.esprit.demotransaction.Repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TransactionService {

    @Value("${stripe.key.secret}")
    private String secretkey;
    @Autowired
    private TransactionRepository transactionRepository;// repository pour stocker les paiements dans la base de données
    private UserRepository userRepository;
    public TransactionService() throws StripeException {
    }

    @Value("${stripe.key.secret}")
    private String secretKey;
    @Test
    public void saveTransaction(Transaction transaction) {


        transactionRepository.save(transaction);
    }

   // User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

    @Test
   public Transaction processPayment(Transaction paymentRequest) throws StripeException {
       Stripe.apiKey = secretKey;
       // Create a PaymentIntent object with the payment details
       Map<String, Object> params = new HashMap<>();
       params.put("amount", paymentRequest.getAmount());
       params.put("currency", paymentRequest.getCurrency());
       params.put("payment_method_types", Collections.singletonList("card"));
       //params.put("transdate",paymentRequest.getTransDate());

       //params.put("payment_method_types", Collections.singletonList("card"));
       //params.put("payment_method", "pm_card_mastercard");
       params.put("payment_method", "pm_card_visa");
       // params.put("payment_method", "pm_card_amex");

       PaymentIntent paymentIntent = PaymentIntent.create(params);
       // Confirm the PaymentIntent to charge the payment
       paymentIntent.confirm();

       paymentRequest.setPaymentId(paymentIntent.getId());


       // Save the transaction to the database
       return transactionRepository.save(paymentRequest);
   }
    @Test
   public List<Transaction> getAll(){
        return transactionRepository.findAll();
   }


}









 /*    Transaction transaction1 = new Transaction();
        transaction1.setAmount(transaction.getAmount());
        transaction1.setCurrency(transaction.getCurrency());
        transaction1.setTransDate(transaction.getTransDate());
       // transaction1.setDescription(paymentRequest.getDescription());
        //transaction1.setToken(paymentRequest.getToken());
        transaction1.setStatus(transaction.getStatus());

    */