package dio.designpatterns.spring_api_rest.model;

import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
