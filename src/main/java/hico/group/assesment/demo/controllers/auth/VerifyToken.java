package hico.group.assesment.demo.controllers.auth;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hico.group.assesment.demo.exceptions.CustomJwtExceptions;
import hico.group.assesment.demo.response.JwtToken;
import hico.group.assesment.demo.utils.Jwt;

import java.io.IOException;

@RestController
public class VerifyToken {

    private final Jwt jwt = new Jwt();

    @ResponseBody
    @PostMapping(value = "/verifyToken", produces = "application/json")
    public String verifyToken(@RequestBody String Token) throws IOException {
        JSONObject token = new JSONObject(Token);
        if (jwt.verifyJwtToken(token.getString("token"), null))
            return new JwtToken().decodedTokenData(jwt.decodeJwtToken(token.getString("token")));
        return new CustomJwtExceptions().JwtTokenException("Invalid Token Error!");
    }

}
