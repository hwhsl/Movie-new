package movienew.infra;

import movienew.domain.*;
import movienew.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MovieViewViewHandler {

    @Autowired
    private MovieViewRepository movieViewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenMovieRegistered_then_CREATE_1 (@Payload MovieRegistered movieRegistered) {
        try {

            if (!movieRegistered.validate()) return;

            // view 객체 생성
            MovieView movieView = new MovieView();
            // view 객체에 이벤트의 Value 를 set 함
            movieView.setId(movieRegistered.getId());
            movieView.setMovieId(String.valueOf(movieRegistered.getMovieId()));
            movieView.setTitle(movieRegistered.getTitle());
            movieView.setCount(0);
            movieView.setMovieStatus(movieRegistered.getStatus());
            // view 레파지 토리에 save
            movieViewRepository.save(movieView);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCreated_then_CREATE_2 (@Payload ReservationCreated reservationCreated) {
        try {

            if (!reservationCreated.validate()) return;

            // view 객체 생성
            MovieView movieView = new MovieView();
            // view 객체에 이벤트의 Value 를 set 함
            movieView.setReservationId(reservationCreated.getId());
            movieView.setReservationStatus(reservationCreated.getStatus());
            // view 레파지 토리에 save
            movieViewRepository.save(movieView);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentApproved_then_CREATE_3 (@Payload PaymentApproved paymentApproved) {
        try {

            if (!paymentApproved.validate()) return;

            // view 객체 생성
            MovieView movieView = new MovieView();
            // view 객체에 이벤트의 Value 를 set 함
            movieView.setPaymentId(paymentApproved.getId());
            movieView.setPaymentStatus(paymentApproved.getStatus());
            // view 레파지 토리에 save
            movieViewRepository.save(movieView);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationConfirmed_then_UPDATE_1(@Payload ReservationConfirmed reservationConfirmed) {
        try {
            if (!reservationConfirmed.validate()) return;
                // view 객체 조회

                List<MovieView> movieViewList = movieViewRepository.findByReservationId(reservationConfirmed.getId());
                for(MovieView movieView : movieViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    movieView.setCount(movieView.getCount() + 1);
                    movieView.setReservationStatus(reservationConfirmed.getStatus());
                // view 레파지 토리에 save
                movieViewRepository.save(movieView);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCancelled_then_UPDATE_2(@Payload ReservationCancelled reservationCancelled) {
        try {
            if (!reservationCancelled.validate()) return;
                // view 객체 조회

                List<MovieView> movieViewList = movieViewRepository.findByReservationId(reservationCancelled.getId());
                for(MovieView movieView : movieViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    movieView.setCount(movieView.getCount() - 1);
                    movieView.setReservationStatus(reservationCancelled.getStatus());
                // view 레파지 토리에 save
                movieViewRepository.save(movieView);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCancelled_then_UPDATE_3(@Payload PaymentCancelled paymentCancelled) {
        try {
            if (!paymentCancelled.validate()) return;
                // view 객체 조회

                List<MovieView> movieViewList = movieViewRepository.findByPaymentId(paymentCancelled.getId());
                for(MovieView movieView : movieViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    movieView.setPaymentStatus(paymentCancelled.getStatus());
                // view 레파지 토리에 save
                movieViewRepository.save(movieView);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenMovieModified_then_UPDATE_4(@Payload MovieModified movieModified) {
        try {
            if (!movieModified.validate()) return;
                // view 객체 조회

                List<MovieView> movieViewList = movieViewRepository.findByMovieId(movieModified.getMovieId());
                for(MovieView movieView : movieViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    movieView.setTitle(movieModified.getTitle());
                    movieView.setMovieStatus(movieModified.getStatus());
                // view 레파지 토리에 save
                movieViewRepository.save(movieView);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenMovieDeleted_then_DELETE_1(@Payload MovieDeleted movieDeleted) {
        try {
            if (!movieDeleted.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            movieViewRepository.deleteByMovieId(movieDeleted.getMovieId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

