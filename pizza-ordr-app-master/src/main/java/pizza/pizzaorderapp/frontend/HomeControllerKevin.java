package pizza.pizzaorderapp.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pizza.pizzaorderapp.frontend.Input;
import pizza.pizzaorderapp.frontend.Pizza;

import java.util.Date;

@Controller
public class HomeControllerKevin {
    @Autowired
    PizzaRepository pizzaRepository;

    @Autowired
    InputRepository inputRepository;




    @RequestMapping("/checkout")
    public String checkout(Model model) {
        return "checkout";
    }



}
