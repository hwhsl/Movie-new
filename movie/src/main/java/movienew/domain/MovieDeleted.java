package movienew.domain;

import movienew.domain.*;
import movienew.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class MovieDeleted extends AbstractEvent {

    private Long movieId;
    private String title;
    private Float price;
    private String status;
    private Integer count;

    public MovieDeleted(Movie aggregate){
        super(aggregate);
    }
    public MovieDeleted(){
        super();
    }
}
