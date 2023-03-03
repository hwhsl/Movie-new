package movienew.domain;

import movienew.domain.*;
import movienew.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class ReservationCreated extends AbstractEvent {

    private Long id;
    private Long movieId;
    private Float price;
    private String title;
    private String status;

    public ReservationCreated(Reservation aggregate){
        super(aggregate);
    }
    public ReservationCreated(){
        super();
    }
}
