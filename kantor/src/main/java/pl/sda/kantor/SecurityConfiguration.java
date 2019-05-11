package pl.sda.kantor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /* for static unprotected resources */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/**"); //security completely disabled
    }

    /* for google oauth */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/contact/**", "/rates/**", "/h2_console/**").permitAll()     // security still on but all permitted
                .antMatchers("/admin/**").access("hasRole('ADMIN')") // show that users don't have an access
                .anyRequest().authenticated()
                .and()
                .formLogin();
//                .and()
//                .oauth2Login();
        //TODO setup Google OAuth login 

        //for h2 console only
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    /* for testing the roles */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder());

//                .inMemoryAuthentication()
//                .withUser("user")
//                .password("{noop}password")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("{noop}admin")
//                .roles("USER", "ADMIN");
    }
}
