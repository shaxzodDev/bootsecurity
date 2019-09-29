package rc.bootsecurity.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import rc.bootsecurity.security.UserPrincipal;

import java.util.Date;

@Component
public class JwtProvider {

    @Autowired
    private JwtProperties jwtProperties;

    public String generateJwtToken(Authentication authentication) {

        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        String token = JWT.create()
                .withSubject(principal.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(JwtProperties.SECRET.getBytes()));

        return token;

    }

}
