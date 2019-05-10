package pl.sda.kantor;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /* for static unprotected resources */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/**", "/json/**"); //security completely disabled
    }

    /* for google oauth */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //TODO fixme
                .antMatchers("/", "/weather/**", "/about/**", "/h2_console/**").permitAll()     // security still on but all permitted
                .antMatchers("/wojtek/**").access("hasRole('ADMIN')") // show that users don't have an access
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .oauth2Login();

        //for h2 console only
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    /* for testing the roles */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("{noop}admin")
                .roles("USER", "ADMIN");
    }
}