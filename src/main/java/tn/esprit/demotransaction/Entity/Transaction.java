package tn.esprit.demotransaction.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private Long amount;
    private String currency;

    @Temporal(TemporalType.DATE)
   private Date transDate= new Date(System.currentTimeMillis());
    @Temporal(TemporalType.TIME)
    private Date transTime = new Date(System.currentTimeMillis());
  // @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private Status status;
    private String paymentId;
@ManyToOne
    private TestUser testUser;

}




