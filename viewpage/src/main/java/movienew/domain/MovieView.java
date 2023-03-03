package movienew.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="MovieView_table")
@Data
public class MovieView {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long movieId;
        private String title;
        private Integer count;
        private String movieStatus;
        private String reservationStatus;
        private Long reservationId;
        private Long paymentId;
        private String paymentStatus;


}
