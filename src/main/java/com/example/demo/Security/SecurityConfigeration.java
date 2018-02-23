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
                .antMatchers("/summary","/","/login","/h2-console/**","/registration").permitAll()
               .antMatchers("/edu","/exp","/skill","/refer","/contact").access("hasAuthority('APPLICANT')")
                .antMatchers("/coverletter","/display").access("hasAnyAuthority('EMPLOYER','APPLICANT') ")
               .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/myLoginPage")
                .loginProcessingUrl("/loginprocess")
                .permitAll()

                .and()
//                .logout().logoutRequestMatcher(
//                        new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied")
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
              .withUser("app").password("pwd").authorities("APPLICANT")
                .and()
                .withUser("emp").password("pwd").authorities("EMPLOYER")
                .and()
                .withUser("rec").password("pwd").authorities("RECRUITER");



        auth
                .userDetailsService(userDetailsServiceBean());
    }

}
