package study.security.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new SimplePasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf(csrfConfig -> csrfConfig
                .disable()
        );

        httpSecurity.authorizeHttpRequests(authorization -> authorization
                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                .requestMatchers("/user/**").hasRole("MEMBER")
                .anyRequest().permitAll()
        );
        httpSecurity.formLogin(loginConfig -> loginConfig
                .defaultSuccessUrl("/",true)
                .permitAll()
        );

        return httpSecurity.build();
    }
}
