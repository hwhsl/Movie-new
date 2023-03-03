package movienew.domain;

import movienew.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class ReservationCancelled extends AbstractEvent {

    private Long id;
    private Long movieId;
    private String status;
}
