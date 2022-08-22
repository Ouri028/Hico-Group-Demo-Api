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
    @PostMapping(value = "/api/authenticate", produces = "application/json")
    public String authenticateUser(@RequestBody String userData) {
        return authenticationServices.authenticate(userData, userRepository);
    }

    @ResponseBody
    @PostMapping(value = "/api/verifyToken", produces = "application/json")
    public String verifyToken(@RequestBody String Token) throws JSONException, IOException {
        return authenticationServices.validateToken(Token);
    }
}
