//package com.ex.websecurityconfig;
//
//import com.ex.UserService;
//import com.ex.module.entityservices.DesignerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfigDesigner extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/", "/home", "/registration").permitAll()
//                .antMatchers("/designer").hasAuthority("DESIGNER")
//                .antMatchers("/customer").hasAuthority("CUSTOMER")
//                .antMatchers("/company").hasAuthority("COMPANY")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//
//
//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(new DesignerService()).passwordEncoder(bCryptPasswordEncoder());
//    }
//
//    private PasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//
//    }
//}
