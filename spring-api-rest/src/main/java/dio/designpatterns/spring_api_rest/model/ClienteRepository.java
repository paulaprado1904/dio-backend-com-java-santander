package dio.designpatterns.spring_api_rest.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
