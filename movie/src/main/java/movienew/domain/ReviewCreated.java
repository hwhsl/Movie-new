package movienew.domain;

import movienew.domain.*;
import movienew.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class ReviewCreated extends AbstractEvent {

    private Long id;
    private Long reviewId;
    private Long movieId;
    private Float score;

    public ReviewCreated(Review aggregate){
        super(aggregate);
    }
    public ReviewCreated(){
        super();
    }
}
