package pizza.pizzaorderapp.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    //******************************************************
    // By default, if access is not specified, it is denied
    // you have to specifically permit access to each page, directory, or group of pages in your application (!)
    //******************************************************

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        //******************************************************************************
        // creates an object that can be re-used to encode passwords in your application
        // this method is called to provide an instance of a BCryptPasswordEncoder
        // BCryptPasswordEncoder's encode() method is called to return a String
        //          this String is the password hashed using the BCrypt hashing function
        //******************************************************************************
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private SSUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new SSUserDetailsService(userRepository);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //*****************************************************************************
        // .authorizeRequest :: tells application which requests should be authorized
        // .and() :: adds additional authentication rules
        // .formLogin() :: indicates the application should show a login form
        // .permitAll() :: everyone can see it even if they're not authenticated
        //*****************************************************************************

        //// 401: for the default login form, use this instead:
        // http.authorizeRequests().anyRequest().authenticated().and().formLogin();

        //// 402: basic login-form as defined in "/login"
        // http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll();

        //// 403: adding specific authorizations for specific directories
        ////       order matters!!
        ////       more specific access rules go last
        //http.authorizeRequests()
        //.antMatchers("/").access("hasAnyAuthority('USER','ADMIN')")
        //// regular 'USER' has access to all root directory
        //.antMatchers("/admin").access("hasAuthority('ADMIN')")
        //// 'ADMIN' has access to /admin directory
        //.anyRequest().authenticated()
        //// any request should be authenticated!...
        //.and()
        //.formLogin().loginPage("/login").permitAll()
        //// everyone is allowed to login
        //.and()
        //.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll();
        //// everyone is allowed to logout

        // 404: adding the DATABASE LAYER to our SECURITY LAYER
        //      this is set up to allow the h2-console for the h2 database
        //      this code implements mySQL but all the h2 stuff is there and ready to go if needed
        http.authorizeRequests()
                .antMatchers("/**","/index","/orderform","/orderform2",
                        "/process", "/pizzadetail","/pizzadetail2",
                        "/secondprocess","/cart","/checkout","/checkoutprocess",
                        "/checkoutprocess2","/base","/h2-console/**", "/register","/css/**", "static/**","/js/**", "/image/**").permitAll()
                // everyone is allowed to view root, h2-console, registration page, and all static files
                .antMatchers("/admin").access("hasAuthority('ADMIN')")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").loginPage("/login2").defaultSuccessUrl("/secure", true).permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout").permitAll()
                .and()
                .httpBasic();

        // 404: also added this
        http.csrf().disable();  // no tokens
        http.headers().frameOptions().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //******************************************************
        // overrides the default configure method, and configures users who can use the application
        // by default, SpringBoot will assign a new random password to "user" if you don't configure this
        // once this is set up, you can log-in with any users specified here
        //******************************************************

        //// 401-403: used this:
        //auth.inMemoryAuthentication()
        ////******************************************************
        //// when users are created, they can have at least one (or more!) "authorities" assigned to them.
        //// these "authorities" can restrict the user even further
        ////******************************************************
        //// note: the passwordEncoder() method, below, is the one we defined as a static @Bean, above!
        //// it simply returns a new BCryptPasswordEncoder on which we then call the encode() method to encode our password!
        ////******************************************************
        //.withUser("user").password(passwordEncoder().encode("password")).authorities("USER")
        //.and()
        //.withUser("rose").password(passwordEncoder().encode("lake")).authorities("ADMIN");

        //404: uses this:
        auth.userDetailsService(userDetailsServiceBean()).passwordEncoder(passwordEncoder());
        // userDetailsServiceBean() :: returns a new SSUserDetailsService built using the userRepository
        // SSUserDetailsService passwordEncoder() method :: receives as parameter a new BCryptPasswordEncoder() from our local passwordEncoder method

    }

}
