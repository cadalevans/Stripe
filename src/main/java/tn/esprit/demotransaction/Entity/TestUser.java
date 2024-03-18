package tn.esprit.demotransaction.Entity;

import lombok.*;

import javax.persistence.*;
import java.security.PrivateKey;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class TestUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String username;
    private String surname;
    private String email;
    private String password;

   /* @OneToMany(mappedBy = "testUser")
    private Set<Transaction> transaction;
    @ManyToMany
    private Set<BankInfo> bankInfos;

    */


}

