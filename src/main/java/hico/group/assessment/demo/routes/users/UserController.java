package hico.group.assessment.demo.routes.users;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private final UserServices userServices = new UserServices();

    @ResponseBody
    @GetMapping(value = "/api/users", produces = "application/json")
    public Iterable<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @ResponseBody
    @PostMapping(value = "/api/users", produces = "application/json")
    public Users addUser(@RequestBody String userData) {
        return userServices.addUser(new JSONObject(userData), userRepository);
    }

    @ResponseBody
    @GetMapping(value = "/api/user/{id}", produces = "application/json")
    public Users getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @ResponseBody
    @PatchMapping(value = "/api/user/{id}", produces = "application/json")
    public Users updateUser(@RequestBody String updatedUserData, @PathVariable Long id) {
        return userServices.updateUser(id, new JSONObject(updatedUserData), userRepository);
    }

    @ResponseBody
    @PostMapping(value = "/api/user/{id}/password_reset", produces = "application/json")
    public String updatePassword(@RequestBody String password, @PathVariable Long id) {
        userServices.updatePassword(id, new JSONObject(password), userRepository);
        return new JSONObject()
                .put("message", "Password updated.")
                .toString();
    }

    @ResponseBody
    @DeleteMapping(value = "/api/user/{id}", produces = "application/json")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
