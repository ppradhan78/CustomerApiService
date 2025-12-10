//package org.pkp.config;
//
//import org.springframework.context.annotation.Bean;
//
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/actuator/health", "/actuator/health/**", "/actuator/info").permitAll()
//                        .anyRequest().authenticated()
//                );
//
//        return http.build();
//    }
//
//}

//@Bean
//public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http
//            .csrf(csrf -> csrf.disable())
//            .authorizeHttpRequests(auth -> auth
//                    .requestMatchers("/actuator/**").permitAll()
//                    .anyRequest().authenticated()
//            )
//            .httpBasic();
//
//    return http.build();
//}
