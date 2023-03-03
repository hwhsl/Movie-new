package movienew.domain;

import movienew.domain.*;
import movienew.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class PaymentCancelled extends AbstractEvent {

    private Long id;
    private Long reservationId;
    private String status;

    public PaymentCancelled(Payment aggregate){
        super(aggregate);
    }
    public PaymentCancelled(){
        super();
    }
}
