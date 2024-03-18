package tn.esprit.demotransaction.Controller;


import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demotransaction.Entity.Status;
import tn.esprit.demotransaction.Entity.Transaction;
import tn.esprit.demotransaction.Repository.TransactionRepository;
import tn.esprit.demotransaction.Repository.UserRepository;
import tn.esprit.demotransaction.Service.TransactionService;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController


public class TransactionController {

    @Value("${stripe.key.secret}")
    private String secretKey;

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/payments")
    public ResponseEntity<String> processPayment(@RequestBody Transaction paymentRequest) {
        try {
            Transaction transaction = transactionService.processPayment(paymentRequest);

            // Return a success response to the client
            return ResponseEntity.ok().body("Payment successful");
        } catch (StripeException e) {
            e.printStackTrace();

            // Return an error response to the client
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Payment failed: " + e.getMessage());
        }
    }

    @GetMapping("/payments/all")
    public List<Transaction> findAll(){
        return transactionService.getAll();
    }


}







// Save the transaction details to the database
         /*   Transaction transaction = new Transaction();
            transaction.setAmount(paymentRequest.getAmount());
            transaction.setCurrency(paymentRequest.getCurrency());
           // transaction.setDescription(paymentRequest.getDescription());
           // transaction.setToken(paymentRequest.getToken());
            transaction.setStatus(paymentRequest.getStatus());

          }

          */
