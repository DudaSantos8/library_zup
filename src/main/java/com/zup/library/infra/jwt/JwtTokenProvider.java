package com.zup.library.infra.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final long jwtExpirationDate = 3600000;
    private String secretKey = "861a73737f3ab436407c938f2367256e8e3ffdbe72d6cde12bbfed73d051db045b33022e1d158bb7ef05ce61159bbbe0fb28f732ea6c0c0614cb927d6ab0ea2f";


    public String generateToken(Authentication authentication){
        String username =  authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, key())
                .compact();

        return token;
    }

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }

    public String getName(String token){
        return Jwts.parser()
                .setSigningKey((SecretKey) key())
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token){
        Jwts.parser()
                .setSigningKey(key())
                .parse(token);
        return true;
    }

}
