package movienew.domain;

import movienew.domain.ReviewCreated;
import movienew.domain.ReviewModified;
import movienew.domain.ReviewDeleted;
import movienew.MovieApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Review_table")
@Data

public class Review  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long reviewId;
    
    
    
    
    
    private Long movieId;
    
    
    
    
    
    private Float score;

    @PostPersist
    public void onPostPersist(){


        ReviewCreated reviewCreated = new ReviewCreated(this);
        reviewCreated.publishAfterCommit();



        ReviewModified reviewModified = new ReviewModified(this);
        reviewModified.publishAfterCommit();



        ReviewDeleted reviewDeleted = new ReviewDeleted(this);
        reviewDeleted.publishAfterCommit();

    }
    @PreUpdate
    public void onPreUpdate(){
    }
    @PreRemove
    public void onPreRemove(){
    }

    public static ReviewRepository repository(){
        ReviewRepository reviewRepository = MovieApplication.applicationContext.getBean(ReviewRepository.class);
        return reviewRepository;
    }






}
