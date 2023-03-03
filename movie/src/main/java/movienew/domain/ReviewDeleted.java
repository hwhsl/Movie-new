package movienew.domain;

import movienew.domain.*;
import movienew.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class ReviewDeleted extends AbstractEvent {

    private Long id;
    private Long reviewId;
    private Long movieId;
    private Float score;

    public ReviewDeleted(Review aggregate){
        super(aggregate);
    }
    public ReviewDeleted(){
        super();
    }
}
