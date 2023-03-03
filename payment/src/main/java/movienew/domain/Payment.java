package movienew.domain;

import movienew.domain.PaymentCancelled;
import movienew.PaymentApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Payment_table")
@Data

public class Payment  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long reservationId;
    
    
    
    
    
    private Long movieId;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private Float price;

    @PostPersist
    public void onPostPersist(){
    }
    @PostUpdate
    public void onPostUpdate(){


        PaymentCancelled paymentCancelled = new PaymentCancelled(this);
        paymentCancelled.publishAfterCommit();

    }

    public static PaymentRepository repository(){
        PaymentRepository paymentRepository = PaymentApplication.applicationContext.getBean(PaymentRepository.class);
        return paymentRepository;
    }



    public void approvePayment(){
        PaymentApproved paymentApproved = new PaymentApproved(this);
        paymentApproved.publishAfterCommit();

    }

    public static void cancelPayment(ReservationCancelRequested reservationCancelRequested){

        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        PaymentCancelled paymentCancelled = new PaymentCancelled(payment);
        paymentCancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(reservationCancelRequested.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);

            PaymentCancelled paymentCancelled = new PaymentCancelled(payment);
            paymentCancelled.publishAfterCommit();

         });
        */

        
    }


}
