package hico.group.assessment.demo.routes.auth;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hico.group.assessment.demo.routes.users.UserRepository;

@RestController
public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;
    private AuthenticationServices authenticationServices = new AuthenticationServices();

    @ResponseBody
    @PostMapping(value = "/authenticate", produces = "application/json")
    public String authenticateUser(@RequestBody String UserData) {
        return authenticationServices.authenticate(UserData, userRepository);
    }

    @ResponseBody
    @PostMapping(value = "/verifyToken", produces = "application/json")
    public String verifyToken(@RequestBody String Token) throws JSONException, IOException {
        return authenticationServices.validateToken(Token);
    }
}
