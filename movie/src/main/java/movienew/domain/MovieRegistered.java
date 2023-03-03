package movienew.domain;

import movienew.domain.*;
import movienew.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class MovieRegistered extends AbstractEvent {

    private Long movieId;
    private String title;
    private Float price;
    private String status;
    private Integer count;

    public MovieRegistered(Movie aggregate){
        super(aggregate);
    }
    public MovieRegistered(){
        super();
    }
}
