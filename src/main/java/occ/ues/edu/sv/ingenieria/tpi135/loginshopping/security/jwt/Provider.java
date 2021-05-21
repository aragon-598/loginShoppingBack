package occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import occ.ues.edu.sv.ingenieria.tpi135.loginshopping.security.model.UserPrincipal;

/**
 * Crea el token y verifica si el token está bien formado
 */
@Component
public class Provider {
    
    private final static Logger logger = LoggerFactory.getLogger(Provider.class);

    @Value("${jwt.secret}")//obtiene el valor que dimos en application.properties
    private String secret;

    @Value("${jwt.expiration}")//obtiene el valor que dimos en application.properties
    private int expiration;

    public String generateToken(Authentication authentication){
        
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        
        return Jwts.builder().setSubject(userPrincipal.getUsername()).
                setIssuedAt(new Date()).
                setExpiration(new Date(new Date().getTime() + expiration*1000)).
                signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String getUserNameFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try {

            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);

            return true;
        } catch (MalformedJwtException e) {
            logger.error("Token mal formado");
        }
        catch (UnsupportedJwtException e) {
            logger.error("Token no soportado");
        }
        catch (ExpiredJwtException e) {
            logger.error("Token expirado");
        }
        catch (IllegalArgumentException e) {
            logger.error("Token vacío");
        }
        catch (SignatureException e) {
            logger.error("Token mal formado");
        }

        return false;
    }

}
