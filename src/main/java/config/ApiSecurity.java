package config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class ApiSecurity extends WebSecurityConfigurerAdapter{
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserDetailsService userDetailsService;
    public static final String SIGN_UP_URL = "/api/v1/users";
    public static final String LOGIN_URL = "/api/v1/login";
    public static final String SWAGGER_URL = "/swagger-ui.html";
    public static final String API_DOCS = "/api-docs";
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    public ApiSecurity(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http.csrf().disable();
    	 http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    	 http.authorizeRequests()
    	 .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
    	 .antMatchers(HttpMethod.POST, LOGIN_URL).permitAll()
    	 .antMatchers(HttpMethod.GET, SWAGGER_URL).permitAll()
    	 .antMatchers(HttpMethod.GET, API_DOCS).permitAll()
    	 .anyRequest().authenticated();
    	 http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
    }
    
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
    
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
    }

    
}