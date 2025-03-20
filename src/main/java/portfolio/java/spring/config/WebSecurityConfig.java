//package portfolio.java.spring.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails cliente = User.withUsername("cliente")
//                .password("{noop}cli123") // {noop} indica que a senha não está criptografada
//                .roles("CLIENTE")
//                .build();
//
//        UserDetails tecnico = User.withUsername("tecnico")
//                .password("{noop}tec123")
//                .roles("TECNICO")
//                .build();
//
//        UserDetails administrador = User.withUsername("administrador")
//                .password("{noop}admin123")
//                .roles("ADMINISTRADOR")
//                .build();
//        return new InMemoryUserDetailsManager(cliente, tecnico, administrador);
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/").permitAll()
//                        .requestMatchers(HttpMethod.GET,"/login").permitAll()
//                        .requestMatchers("/usuarios").permitAll()
////                        .requestMatchers(HttpMethod.GET,"/visualizarChamados").permitAll()
////                        .requestMatchers(HttpMethod.POST,"/abrirChamado").hasAnyRole("CLIENTE")
////                        .requestMatchers("/atualizarChamado").hasAnyRole("TECNICO")
////                        .requestMatchers("/resolverChamado").hasAnyRole("TECNICO")
////                        .requestMatchers(HttpMethod.GET, "/exibirChamadosPorInsercao").hasAnyRole("ADMINISTRADOR")
////                        .requestMatchers(HttpMethod.GET, "/exibirChamadosPorPrioridade").hasAnyRole("ADMINISTRADOR")
////                        .requestMatchers(HttpMethod.GET, "/exibirChamadosFechados").hasAnyRole("ADMINISTRADOR")
////                        .requestMatchers(HttpMethod.PATCH, "/atribuirChamados").hasAnyRole("ADMINISTRADOR")
//                        .anyRequest().authenticated()
//                )
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return NoOpPasswordEncoder.getInstance(); // Apenas para testes (não usar em produção!)
////    }
//}