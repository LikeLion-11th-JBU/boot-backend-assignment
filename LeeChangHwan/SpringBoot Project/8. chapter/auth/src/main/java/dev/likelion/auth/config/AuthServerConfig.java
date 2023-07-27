//package dev.likelion.auth.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AuthServerConfig {
//    @Bean
//    public RegisteredClientRepository registeredClientRepository(
//            @Autowired
//            RegisteredClientRepository registeredClientRepository
//    ) {
//        return registeredClientRepository;
//    }
//
//    @Bean
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    public SecurityFilterChain authServerSecurityFilterChain(HttpSecurity http) throws Exception {
//        OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
//
//        return http.formLogin(formLogin -> formLogin.loginPage("/user/login")).build();
//    }
//
//    @Bean
//    public ProviderSettings providerSettings() {
//        return ProviderSettings.builder()
//                .issuer("http://localhost:10000")
//                .build();
//    }
//}
