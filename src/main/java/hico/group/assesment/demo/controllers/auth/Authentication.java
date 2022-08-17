package hico.group.assesment.demo.controllers.auth;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hico.group.assesment.demo.entities.users.Users;
import hico.group.assesment.demo.entities.users.repository.UserRepository;
import hico.group.assesment.demo.utils.Encryption;
import hico.group.assesment.demo.utils.Jwt;

@RestController
public class Authentication {
    @Autowired
    private UserRepository userRepository;
    private final Encryption encryption = new Encryption();
    private final Jwt jwt = new Jwt();

    @ResponseBody
    @PostMapping(value = "/authenticate", produces = "application/json")
    public String authenticateUser(@RequestBody String UserData) {
        JSONObject user = new JSONObject(UserData);
        String username = user.getString("username");
        String password = user.getString("password");
        if (username != null && password != null) {
            try {
                Users db_user = userRepository.findByUsername(user.getString("username"));
                if (encryption.decryptPassword(password, db_user.getPassword())) {
                    return new JSONObject()
                            .put("token", jwt.generateJwtToken(db_user.getUserDetails())).toString();
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
}
