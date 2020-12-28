//package ir.prince.bankdemo;
//
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//@EnableOAuth2Sso
//@Configuration
//@Order(2)
//public class UiSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/**")
//        	.csrf().disable()
//            .authorizeRequests()
//            .antMatchers("/", "/login**","/loginpage","/pub/**","/static/**","/dashboard/banktransfer")
//            .permitAll()
//            .anyRequest()
//            .authenticated();
//        
//
//    }
//
//}
