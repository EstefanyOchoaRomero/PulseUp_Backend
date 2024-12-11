// package com.pulseup.pulseup_backend.config;


// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// // import org.springframework.security.authentication.AuthenticationManager;
// // import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.UserDetailsService;

// import com.pulseup.pulseup_backend.repository.UserRepository;
// import com.pulseup.pulseup_backend.service.CustomUserDetailsService;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {
//     private final UserRepository userRepository;
//     public SecurityConfig(UserRepository userRepository) {
//         //     this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//             this.userRepository = userRepository;
//         }
//     protected void configure(HttpSecurity http) throws Exception {
//         http.csrf().disable()
//                 .authorizeRequests()
//                 .requestMatchers(HttpMethod.POST, "/api/**").permitAll()
//                 .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
//                 .requestMatchers(HttpMethod.PUT, "/api/**").permitAll()
//                 .requestMatchers(HttpMethod.DELETE, "/api/**").permitAll()
//                 .anyRequest().authenticated().and().httpBasic();

//     }
//     // @Override
//     @Bean
//     public UserDetailsService userDetailsService() {
//         return new CustomUserDetailsService(userRepository);
    //}
    // // private final JwtAuthenticationFilter jwtAuthenticationFilter;
    // private final UserRepository userRepository;

    // public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, UserRepository userRepository) {
    //     this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    //     this.userRepository = userRepository;
    // }

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http.csrf().disable()
    //         .cors().and()
    //         .authorizeHttpRequests(authorize -> authorize
    //             .requestMatchers("/api/auth/register", "/api/auth/login").permitAll()
    //             .anyRequest().authenticated()
    //         )
    //         .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    //     return http.build();
    // }

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }

    // @Bean
    // public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    //     return authenticationConfiguration.getAuthenticationManager();
    // }

    // @Bean
    // public UserDetailsService userDetailsService() {
    //     return new CustomUserDetailsService(userRepository);
    // }

    // @Bean
    // public WebMvcConfigurer corsConfigurer() {
    //     return new WebMvcConfigurer() {
    //         @Override
    //         public void addCorsMappings(CorsRegistry registry) {
    //             registry.addMapping("/**")
    //                     .allowedOrigins("http://localhost:8080")
    //                     .allowedMethods("*")
    //                     .allowedHeaders("*");
    //         }
    //     };
    // }
//}

