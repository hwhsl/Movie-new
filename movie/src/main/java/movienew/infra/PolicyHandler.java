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
    @Autowired MovieRepository movieRepository;
    @Autowired ReviewRepository reviewRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ReservationConfirmed'")
    public void wheneverReservationConfirmed_ConfirmReservation(@Payload ReservationConfirmed reservationConfirmed){

        ReservationConfirmed event = reservationConfirmed;
        System.out.println("\n\n##### listener ConfirmReservation : " + reservationConfirmed + "\n\n");


        

        // Sample Logic //
        Movie.confirmReservation(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ReservationCancelled'")
    public void wheneverReservationCancelled_CancelReservation(@Payload ReservationCancelled reservationCancelled){

        ReservationCancelled event = reservationCancelled;
        System.out.println("\n\n##### listener CancelReservation : " + reservationCancelled + "\n\n");


        

        // Sample Logic //
        Movie.cancelReservation(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ReviewCreated'")
    public void wheneverReviewCreated_UpdateReview(@Payload ReviewCreated reviewCreated){

        ReviewCreated event = reviewCreated;
        System.out.println("\n\n##### listener UpdateReview : " + reviewCreated + "\n\n");


        // Comments // 
		//        
		//         repository().findById(reviewCreated.getMovieId()).ifPresent(movie->{
		//             
		//             movie.setScoreTotal(movie.getStoreTotal() + reviewCreated.getScore()); // do something
		//             movie.setReviewCount(movie.getReviewCount() + 1);
		// 
		//             movie.setScore(movie.getScoreTotal() / movie.getReviewCount());
		//             repository().save(movie);
		// 
		// 
		//          });

        // Sample Logic //
        Movie.updateReview(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ReviewModified'")
    public void wheneverReviewModified_UpdateReview(@Payload ReviewModified reviewModified){

        ReviewModified event = reviewModified;
        System.out.println("\n\n##### listener UpdateReview : " + reviewModified + "\n\n");


        // Comments // 
		//        
		//         repository().findById(reviewCreated.getMovieId()).ifPresent(movie->{
		//             
		//             movie.setScoreTotal(movie.getStoreTotal() + reviewCreated.getScore()); // do something
		//             movie.setReviewCount(movie.getReviewCount() + 1);
		// 
		//             movie.setScore(movie.getScoreTotal() / movie.getReviewCount());
		//             repository().save(movie);
		// 
		// 
		//          });

        // Sample Logic //
        Movie.updateReview(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ReviewDeleted'")
    public void wheneverReviewDeleted_UpdateReview(@Payload ReviewDeleted reviewDeleted){

        ReviewDeleted event = reviewDeleted;
        System.out.println("\n\n##### listener UpdateReview : " + reviewDeleted + "\n\n");


        // Comments // 
		//        
		//         repository().findById(reviewCreated.getMovieId()).ifPresent(movie->{
		//             
		//             movie.setScoreTotal(movie.getStoreTotal() + reviewCreated.getScore()); // do something
		//             movie.setReviewCount(movie.getReviewCount() + 1);
		// 
		//             movie.setScore(movie.getScoreTotal() / movie.getReviewCount());
		//             repository().save(movie);
		// 
		// 
		//          });

        // Sample Logic //
        Movie.updateReview(event);
        

        

    }

}


