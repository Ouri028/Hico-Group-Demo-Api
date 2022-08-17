package hico.group.assessment.demo.routes.users;

import org.json.JSONObject;

import hico.group.assessment.demo.utils.Encryption;

public class UserServices {

    private final Encryption encryption = new Encryption();

    public Users addUser(JSONObject UserData, UserRepository userRepository) {
        Users users = new Users();
        users.setUsername(UserData.getString("username"));
        users.setPassword(encryption.encryptPassword(UserData.getString("password")));
        users.setFirstName(UserData.getString("firstName"));
        users.setLastName(UserData.getString("lastName"));
        return userRepository.save(users);
    }

    public Users updateUser(Long id, JSONObject UpdatedUserData, UserRepository userRepository) {
        Users userFoundById = userRepository.getReferenceById(id);
        userFoundById.setUsername(UpdatedUserData.getString("username"));
        userFoundById.setPassword(encryption.encryptPassword(UpdatedUserData.getString("password")));
        userFoundById.setFirstName(UpdatedUserData.getString("firstName"));
        userFoundById.setLastName(UpdatedUserData.getString("lastName"));
        return userRepository.save(userFoundById);
    }

    public void deleteUser(Long id, UserRepository userRepository) {
        userRepository.deleteById(id);
    }

    public void bulkDeleteUsers(Iterable<Long> ids, UserRepository userRepository) {
        userRepository.deleteAllById(ids);
    }

}