package pizza.pizzaorderapp.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pizza.pizzaorderapp.Security.Role;
import pizza.pizzaorderapp.Security.RoleRepository;
import pizza.pizzaorderapp.Security.User;
import pizza.pizzaorderapp.Security.UserRepository;

import java.util.*;

@Component
public class DataLoaderPizza implements CommandLineRunner {

    @Autowired
    PizzaRepository pizzaRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    InputRepository inputRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... strings) throws Exception{


        User user=userRepository.findByUsername("Efrem");


        Pizza pizza=new Pizza("https://cdn.shopify.com/s/files/1/0808/5563/products/061219_Pepperoni_Full_800x.jpg?v=1560820716",14.50,"large","thin","square","normal","BBQ","light","Peporoni","Onion");
        pizzaRepository.save(pizza);

        Input input=new Input();
        List<Pizza> pizzaList=new ArrayList<>();
        pizzaList.add(pizza);
        pizza.setInput(input);
        input.setPizzaSet(pizzaList);
        input.setUser(user);
        inputRepository.save(input);
        List<Input> inputs=new ArrayList<>();
        inputs.add(input);
        user.setInputs(inputs);

        userRepository.save(user);

        pizza=new Pizza("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQol9yz-DsDRlgjFwpGbIk8OmWlcqvc0UpMWlsU2t7N33M8RxMr&s",13.50,"large","thin","square","normal","BBQ","light","Cheese","Cabbage");

        pizzaRepository.save(pizza);
        pizzaList.add(pizza);



    }

}

