package movienew.domain;

import movienew.domain.*;
import movienew.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class ReservationCancelRequested extends AbstractEvent {

    private Long id;
    private Long movieId;

    public ReservationCancelRequested(Reservation aggregate){
        super(aggregate);
    }
    public ReservationCancelRequested(){
        super();
    }
}
