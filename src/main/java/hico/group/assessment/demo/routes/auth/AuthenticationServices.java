package hico.group.assessment.demo.routes.auth;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import hico.group.assessment.demo.exceptions.CustomJwtExceptions;
import hico.group.assessment.demo.routes.users.UserRepository;
import hico.group.assessment.demo.routes.users.Users;
import hico.group.assessment.demo.utils.Encryption;
import hico.group.assessment.demo.utils.Jwt;

public class AuthenticationServices {
    private final Encryption encryption = new Encryption();
    private final Jwt jwt = new Jwt();

    public String authenticate(String UserData, UserRepository userRepository) {
        JSONObject user = new JSONObject(UserData);
        String username = user.getString("username");
        String password = user.getString("password");
        if (username != null && password != null) {
            try {
                Users db_user = userRepository.findByUsername(user.getString("username"));
                if (encryption.decryptPassword(password, db_user.getPassword())) {
                    return new JSONObject()
                            .put("token", jwt.generateJwtToken())
                            .put("user", db_user.getUserDetails())
                            .toString();
                }
            } catch (Exception USER_NOT_FOUND) {
                return new JSONObject()
                        .put("error", "USER_NOT_FOUND")
                        .put("message", USER_NOT_FOUND)
                        .toString();
            }
        }
        return new JSONObject()
                .put("error", "Please input a valid username and password.").toString();
    }

    public String validateToken(String Token) throws JSONException, IOException {
        JSONObject token = new JSONObject(Token);
        if (jwt.verifyJwtToken(token.getString("token"), null))
            return new JSONObject()
                    .put("validated", true)
                    .toString();
        return new CustomJwtExceptions().JwtTokenException("Invalid Token Error!");
    }
}
