package movienew.domain;

import movienew.domain.*;
import movienew.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class MovieModified extends AbstractEvent {

    private Long movieId;
    private String title;
    private Float price;
    private String status;
    private Integer count;

    public MovieModified(Movie aggregate){
        super(aggregate);
    }
    public MovieModified(){
        super();
    }
}
