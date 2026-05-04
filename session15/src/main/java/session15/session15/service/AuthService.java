package session15.session15.service;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import session15.session15.repository.UserRepository;
import session15.session15.security.jwt.JwtProvider;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public User createUser (UserCreateDTO req) {

        if (userRepository.existsByEmail(req.getEmail())) {
            throw new DuplicateResourceException("Email đã tồn tại");
        }
        if (userRepository.existsByPhone(req.getPhone())) {
            throw new DuplicateResourceException("Số điện thoại đã tồn tại");
        }

        User newUser = new User();

        newUser.setPhone(req.getPhone());
        newUser.setEmail(req.getEmail());
        newUser.setPassword(passwordEncoder.encode(req.getPassword()));
        newUser.setRole(req.getRole());

        return userRepository.save(newUser);
    }

    public JwtResponse loginByEmailAndPassword (UserLoginDTO req) {
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            req.getEmail(),
                            req.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsExceptionCustom("Email hoặc mật khẩu không đúng");
        }

        User user = userRepository.findUserByEmail(req.getEmail())
                .orElseThrow();

        JwtResponse res = JwtResponse.builder()
                .username(user.getEmail())
                .accessToken(jwtProvider.generateAccessToken((UserDetails) authentication.getPrincipal()))
                .refreshToken(null)
                .expirationDate(new Date(new Date().getTime() + 15 * 60 * 1000))
                .build();

        return res;
    }
}
