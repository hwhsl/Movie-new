package movienew.infra;

import movienew.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="movieViews", path="movieViews")
public interface MovieViewRepository extends PagingAndSortingRepository<MovieView, Long> {

    List<MovieView> findByReservationId(Long reservationId);
List<MovieView> findByPaymentId(Long paymentId);
List<MovieView> findByMovieId(Long movieId);


    void deleteByMovieId(Long movieId);

}
