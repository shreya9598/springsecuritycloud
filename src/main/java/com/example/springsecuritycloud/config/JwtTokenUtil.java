package com.example.springsecuritycloud.config;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;

@Service
public class JwtTokenUtil {
    private String SECRET_KEY = "secret";

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims= new HashMap<>();
        return createToken(claims,userDetails.getUsername());
    }

    private String createToken(Map<String,Object> claims, String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*10)).signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }
//@Autowired
//Logger log;
    public Boolean validateToken(String token, UserDetails userDetails){

        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
//            return true;
        } catch (SignatureException e) {
            System.out.println("error :" + e);
            return false;
//            log.info("Invalid JWT signature.");
//            log.trace("Invalid JWT signature trace: {}", jwtToken, e);
        }
//        } catch (MalformedJwtException e) {
//            log.info("Invalid JWT token.");
//            log.trace("Invalid JWT token trace: {}", jwtToken, e);
//        } catch (ExpiredJwtException e) {
//            log.info("Expired JWT token");
//        }
//        Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
//        final String username = extractUsername(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    return true;
    }
}
