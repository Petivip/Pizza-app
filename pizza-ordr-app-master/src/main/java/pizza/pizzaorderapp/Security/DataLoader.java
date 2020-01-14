package pizza.pizzaorderapp.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... strings) throws Exception {

        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");

        User rose = new User("Efrem","pass", "Efrem", "Berhane", "efrembak@gmail.com", true);
        rose.setRoles(Arrays.asList(userRole, adminRole));
        userRepository.save(rose);

        User user = new User("user", "user", "User", "Last", "user@user.com",true );
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);

        User admin = new User("admin", "password", "Admin", "Last", "admin@admin.com",true);
        admin.setRoles(Arrays.asList(adminRole));
        userRepository.save(admin);

    }
}

