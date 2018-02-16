package com.example.demo.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigeration extends WebSecurityConfigurerAdapter {

    @Autowired
    private SSUserDetailsService userDetailsService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new SSUserDetailsService(userRepository);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http
                .authorizeRequests()
                .antMatchers("summary","/","/login","/h2-console/**","/registration").permitAll()
//                .antMatchers("/edu","/exp","/skill","/reference","/display","contact").access("hasAuthority('ADMIN')")
//               .antMatchers("/display").access("hasAuthority('USER')")
               .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()

                .and()
                .logout().logoutRequestMatcher(
                        new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll()
                .and()
                .httpBasic();
        http
                .csrf()
                .disable();
        http
                .headers().frameOptions().disable();



    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception{
        auth.inMemoryAuthentication()
//                .withUser("admin").password("password").authorities("ADMIN")
//                .and()
                .withUser("user").password("password").authorities("USER");
        auth
                .userDetailsService(userDetailsServiceBean());
    }

}
