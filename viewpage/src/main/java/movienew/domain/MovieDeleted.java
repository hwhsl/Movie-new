package movienew.domain;

import movienew.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class MovieDeleted extends AbstractEvent {

    private Long movieId;
    private String title;
    private Float price;
    private String status;
    private Integer count;
}
