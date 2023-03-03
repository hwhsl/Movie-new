package movienew.domain;

import movienew.domain.MovieRegistered;
import movienew.domain.MovieModified;
import movienew.domain.MovieDeleted;
import movienew.MovieApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Movie_table")
@Data

public class Movie  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long movieId;
    
    
    
    
    
    private String genre;
    
    
    
    
    
    private Float price;
    
    
    
    
    
    private String description;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private Float score;
    
    
    
    
    
    private Integer count;
    
    
    
    
    
    private Float scoreTotal;
    
    
    
    
    
    private Integer reviewCount;

    @PostPersist
    public void onPostPersist(){


        MovieRegistered movieRegistered = new MovieRegistered(this);
        movieRegistered.publishAfterCommit();

    }
    @PostUpdate
    public void onPostUpdate(){


        MovieModified movieModified = new MovieModified(this);
        movieModified.publishAfterCommit();

    }
    @PostRemove
    public void onPostRemove(){


        MovieDeleted movieDeleted = new MovieDeleted(this);
        movieDeleted.publishAfterCommit();

    }
    @PreUpdate
    public void onPreUpdate(){
    }
    @PreRemove
    public void onPreRemove(){
    }

    public static MovieRepository repository(){
        MovieRepository movieRepository = MovieApplication.applicationContext.getBean(MovieRepository.class);
        return movieRepository;
    }




    public static void confirmReservation(ReservationConfirmed reservationConfirmed){

        /** Example 1:  new item 
        Movie movie = new Movie();
        repository().save(movie);

        */

        /** Example 2:  finding and process
        
        repository().findById(reservationConfirmed.get???()).ifPresent(movie->{
            
            movie // do something
            repository().save(movie);


         });
        */

        
    }
    public static void cancelReservation(ReservationCancelled reservationCancelled){

        /** Example 1:  new item 
        Movie movie = new Movie();
        repository().save(movie);

        */

        /** Example 2:  finding and process
        
        repository().findById(reservationCancelled.get???()).ifPresent(movie->{
            
            movie // do something
            repository().save(movie);


         });
        */

        
    }
    public static void updateReview(ReviewCreated reviewCreated){

        /** Example 1:  new item 
        Movie movie = new Movie();
        repository().save(movie);

        */

        /** Example 2:  finding and process
        
        repository().findById(reviewCreated.get???()).ifPresent(movie->{
            
            movie // do something
            repository().save(movie);


         });
        */

        
    }
    public static void updateReview(ReviewModified reviewModified){

        /** Example 1:  new item 
        Movie movie = new Movie();
        repository().save(movie);

        */

        /** Example 2:  finding and process
        
        repository().findById(reviewModified.get???()).ifPresent(movie->{
            
            movie // do something
            repository().save(movie);


         });
        */

        
    }
    public static void updateReview(ReviewDeleted reviewDeleted){

        /** Example 1:  new item 
        Movie movie = new Movie();
        repository().save(movie);

        */

        /** Example 2:  finding and process
        
        repository().findById(reviewDeleted.get???()).ifPresent(movie->{
            
            movie // do something
            repository().save(movie);


         });
        */

        
    }


}
