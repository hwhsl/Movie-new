package movienew.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import movienew.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import movienew.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired ReservationRepository reservationRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PaymentApproved'")
    public void wheneverPaymentApproved_ApprovePayment(@Payload PaymentApproved paymentApproved){

        PaymentApproved event = paymentApproved;
        System.out.println("\n\n##### listener ApprovePayment : " + paymentApproved + "\n\n");


        // Comments // 
		//        repository().findById(paymentApproved.getReservationId()).ifPresent(reservation->{
		//             
		//             reservation.setStatus("PAID"); // do something
		//             repository().save(reservation);
		// 
		// 
		//          });
		//        
		// 

        // Sample Logic //
        Reservation.approvePayment(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PaymentCancelled'")
    public void wheneverPaymentCancelled_CancelPayment(@Payload PaymentCancelled paymentCancelled){

        PaymentCancelled event = paymentCancelled;
        System.out.println("\n\n##### listener CancelPayment : " + paymentCancelled + "\n\n");


        

        // Sample Logic //
        Reservation.cancelPayment(event);
        

        

    }

}


