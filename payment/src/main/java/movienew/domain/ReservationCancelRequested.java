package movienew.domain;

import movienew.domain.*;
import movienew.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class ReservationCancelRequested extends AbstractEvent {

    private Long id;
    private Long movieId;
}


