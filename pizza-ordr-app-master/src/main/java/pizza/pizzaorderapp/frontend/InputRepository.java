package pizza.pizzaorderapp.frontend;

import org.springframework.data.repository.CrudRepository;

public interface InputRepository extends CrudRepository<Input, Long> {
    Input findByOrOrderId(Long id);
}
