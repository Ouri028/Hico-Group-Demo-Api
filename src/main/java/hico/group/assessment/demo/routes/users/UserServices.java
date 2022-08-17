package hico.group.assessment.demo.routes.users;

import org.json.JSONObject;

import hico.group.assessment.demo.utils.Encryption;

public class UserServices {

    private final Encryption encryption = new Encryption();

    public Users addUser(JSONObject userData, UserRepository userRepository) {
        Users users = new Users();
        users.setUsername(userData.getString("username"));
        users.setPassword(encryption.encryptPassword(userData.getString("password")));
        users.setFirstName(userData.getString("firstName"));
        users.setLastName(userData.getString("lastName"));
        return userRepository.save(users);
    }

    public Users updateUser(Long id, JSONObject updatedUserData, UserRepository userRepository) {
        Users userFoundById = userRepository.getReferenceById(id);
        userFoundById.setUsername(updatedUserData.getString("username"));
        userFoundById.setFirstName(updatedUserData.getString("firstName"));
        userFoundById.setLastName(updatedUserData.getString("lastName"));
        return userRepository.save(userFoundById);
    }

    public void deleteUser(Long id, UserRepository userRepository) {
        userRepository.deleteById(id);
    }

    public void updatePassword(Long id, JSONObject updatedPassword, UserRepository userRepository) {
        Users userFoundById = userRepository.getReferenceById(id);
        userFoundById.setPassword(encryption.encryptPassword(updatedPassword.getString("password")));
        userRepository.save(userFoundById);
    }

    public void bulkDeleteUsers(Iterable<Long> ids, UserRepository userRepository) {
        userRepository.deleteAllById(ids);
    }

}