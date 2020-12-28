//package ir.prince.bankdemo;
//
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
//import org.springframework.stereotype.Component;
//
//@Component
//@Order(1)
//public class ApiSecurityConfig extends WebSecurityConfigurerAdapter  {
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/api/**")
//        	.csrf().disable()
//            .authorizeRequests()
//            .antMatchers("/", "/login**")
//            .permitAll()
//            .anyRequest()
//            .authenticated();
//        
//        http.exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint());
//    }
//
//
//    
//}
