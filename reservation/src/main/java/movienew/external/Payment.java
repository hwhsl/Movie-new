package movienew.external;

import lombok.Data;
import java.util.Date;
@Data
public class Payment {

    private Long id;
    private Long reservationId;
    private Long movieId;
    private String status;
    private Float price;
}


