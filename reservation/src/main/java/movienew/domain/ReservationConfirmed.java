package movienew.domain;

import movienew.domain.*;
import movienew.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class ReservationConfirmed extends AbstractEvent {

    private Long id;
    private Long movieId;
    private String status;

    public ReservationConfirmed(Reservation aggregate){
        super(aggregate);
    }
    public ReservationConfirmed(){
        super();
    }
}
