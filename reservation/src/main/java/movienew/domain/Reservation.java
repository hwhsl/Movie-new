package movienew.domain;

import movienew.domain.ReservationCreated;
import movienew.domain.ReservationConfirmed;
import movienew.domain.ReservationCancelled;
import movienew.ReservationApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Reservation_table")
@Data

public class Reservation  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long movieId;
    
    
    
    
    
    private String title;
    
    
    
    
    
    private Float price;
    
    
    
    
    
    private Long payId;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.




        ReservationCreated reservationCreated = new ReservationCreated(this);
        reservationCreated.publishAfterCommit();

    }
    @PostUpdate
    public void onPostUpdate(){


        ReservationConfirmed reservationConfirmed = new ReservationConfirmed(this);
        reservationConfirmed.publishAfterCommit();



        ReservationCancelled reservationCancelled = new ReservationCancelled(this);
        reservationCancelled.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){
    }

    public static ReservationRepository repository(){
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(ReservationRepository.class);
        return reservationRepository;
    }



    public void cancel(){
        ReservationCancelRequested reservationCancelRequested = new ReservationCancelRequested(this);
        reservationCancelRequested.publishAfterCommit();

    }

    public static void approvePayment(PaymentApproved paymentApproved){

        /** Example 1:  new item 
        Reservation reservation = new Reservation();
        repository().save(reservation);

        ReservationConfirmed reservationConfirmed = new ReservationConfirmed(reservation);
        reservationConfirmed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paymentApproved.get???()).ifPresent(reservation->{
            
            reservation // do something
            repository().save(reservation);

            ReservationConfirmed reservationConfirmed = new ReservationConfirmed(reservation);
            reservationConfirmed.publishAfterCommit();

         });
        */

        
    }
    public static void cancelPayment(PaymentCancelled paymentCancelled){

        /** Example 1:  new item 
        Reservation reservation = new Reservation();
        repository().save(reservation);

        ReservationCancelled reservationCancelled = new ReservationCancelled(reservation);
        reservationCancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paymentCancelled.get???()).ifPresent(reservation->{
            
            reservation // do something
            repository().save(reservation);

            ReservationCancelled reservationCancelled = new ReservationCancelled(reservation);
            reservationCancelled.publishAfterCommit();

         });
        */

        
    }


}
