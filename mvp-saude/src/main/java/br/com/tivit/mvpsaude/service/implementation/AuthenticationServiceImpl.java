package br.com.tivit.mvpsaude.service.implementation;

import br.com.tivit.mvpsaude.configuration.UserDetailsImpl;
import br.com.tivit.mvpsaude.dto.auth.LoginRequest;
import br.com.tivit.mvpsaude.dto.auth.LoginResponse;
import br.com.tivit.mvpsaude.dto.auth.RefreshResponse;
import br.com.tivit.mvpsaude.exception.TokenRefreshException;
import br.com.tivit.mvpsaude.model.User;
import br.com.tivit.mvpsaude.service.Util;
import br.com.tivit.mvpsaude.service.contract.AuthenticationService;
import br.com.tivit.mvpsaude.service.contract.MailServiceStrategy;
import br.com.tivit.mvpsaude.service.contract.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final MailServiceStrategy mailService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(TokenService jwtUtils, AuthenticationManager authenticationManager,
                                     UserDetailsServiceImpl userDetailsService, MailServiceStrategy mailService,
                                     PasswordEncoder passwordEncoder) {
        this.tokenService = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.mailService = mailService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginResponse authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String accessToken = tokenService.generateAccessToken(userDetails);
        String refreshToken = this.tokenService.generateRefreshTokenFromUsername(userDetails.getUsername());
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();

        return LoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .username(userDetails.getUsername())
                .roles(roles)
                .build();
    }

    @Override
    public RefreshResponse refreshTheToken(String requestRefreshToken) {
        try {
            if(this.tokenService.validateJwtToken(requestRefreshToken)) {
                String username = this.tokenService.getUserNameFromJwtToken(requestRefreshToken);
                String newAccessToken = this.tokenService.generateAccessToken(username);
                String newRefreshToken = this.tokenService.generateRefreshTokenFromUsername(username);
                return RefreshResponse.builder()
                        .accessToken(newAccessToken)
                        .refreshToken(newRefreshToken)
                        .build();
            } else {
                throw new BadCredentialsException("Token expirado");
            }
        } catch (Exception e) {
            throw new TokenRefreshException(e.getMessage());
        }
    }



    //public test version
    @Override
    public String resetPassword(String email) {
        String generated = Integer.toString(Util.getRandomNumberInRange(100000, 999999));
        String encrypted = passwordEncoder.encode(generated);

        try {
            User user = userDetailsService.findByUsername(email);
            user.setPassword(encrypted);
            userDetailsService.save(user);
            mailService.sendText(email, "Gestor Peixaria - Recuperação de senha",
                    "Sua senha foi alterada para: " + generated);
        } catch (UsernameNotFoundException e) {
            User user = User.builder()
                    .email(email)
                    .username(email)
                    .password(encrypted)
                    .roles(Set.of("COLLABORATOR", "MANAGER"))
                    .build();
            userDetailsService.save(user);
            try {
                mailService.sendText(email, "Gestor Peixaria - Credenciais",
                        "Suas credenciais de acesso são:  \n\n" +
                                "Login: " + email + "\nSenha: " + generated);
            } catch (Exception mailException) {
                System.out.println("\nmail exception; " + mailException.getMessage());
            }
        }
        return generated;
    }
}