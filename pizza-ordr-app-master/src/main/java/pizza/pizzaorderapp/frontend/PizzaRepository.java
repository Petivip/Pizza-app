package pizza.pizzaorderapp.frontend;

import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {
    Pizza findByMeatIgnoreCase(String meat);
    Pizza findByPizzaId(Long id);
}