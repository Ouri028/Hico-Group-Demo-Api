package hico.group.assessment.demo.utils;

import java.io.IOException;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import hico.group.assessment.demo.exceptions.CustomJwtExceptions;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Jwt {

    private final Env env = new Env();
    private final CustomJwtExceptions customJwtExceptions = new CustomJwtExceptions();
    protected String secret = env.getEnv("JWT_SECRET");

    Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
            SignatureAlgorithm.HS256.getJcaName());

    public String generateJwtToken(String UserData) {
        Date expiredAt = Date.from(Instant.now().plus(12, ChronoUnit.HOURS));
        return Jwts.builder()
                .setIssuer("Demo")
                .setSubject("Demo_User")
                .claim("User", UserData)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(expiredAt)
                .signWith(hmacKey)
                .compact();
    }

    public boolean verifyJwtToken(String JwtToken, HttpServletResponse response) throws IOException {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(hmacKey)
                    .build()
                    .parseClaimsJws(JwtToken);
            return true;
        } catch (JwtException INVALID_TOKEN) {
            if (response != null) {
                JSONObject VALIDATION_FAILED = new JSONObject()
                        .put("error", "VALIDATION_FAILED")
                        .put("message", "The token provided is not valid or has expired!");
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.setStatus(401);
                response.getWriter().write(VALIDATION_FAILED.toString());
                return false;
            }
            return false;
        }

    }

    public String decodeJwtToken(String JwtToken) {
        try {
            Jws<Claims> jwt = Jwts.parserBuilder()
                    .setSigningKey(hmacKey)
                    .build()
                    .parseClaimsJws(JwtToken);
            return jwt.getBody().get("User").toString();
        } catch (JwtException INVALID_TOKEN) {
            return customJwtExceptions.JwtTokenException(INVALID_TOKEN.getMessage());
        }

    }
}
