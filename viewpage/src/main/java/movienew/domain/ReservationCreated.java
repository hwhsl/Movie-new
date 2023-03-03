package movienew.domain;

import movienew.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class ReservationCreated extends AbstractEvent {

    private Long id;
    private Long movieId;
    private Float price;
    private String title;
    private String status;
}
