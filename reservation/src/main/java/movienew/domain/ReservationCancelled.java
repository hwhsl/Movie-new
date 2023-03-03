package movienew.domain;

import movienew.domain.*;
import movienew.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class ReservationCancelled extends AbstractEvent {

    private Long id;
    private Long movieId;
    private String status;

    public ReservationCancelled(Reservation aggregate){
        super(aggregate);
    }
    public ReservationCancelled(){
        super();
    }
}
