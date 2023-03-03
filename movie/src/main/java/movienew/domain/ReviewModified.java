package movienew.domain;

import movienew.domain.*;
import movienew.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class ReviewModified extends AbstractEvent {

    private Long id;
    private Long reviewId;
    private Long movieId;
    private Float score;

    public ReviewModified(Review aggregate){
        super(aggregate);
    }
    public ReviewModified(){
        super();
    }
}
