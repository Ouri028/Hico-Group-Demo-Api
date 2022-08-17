package hico.group.assesment.demo.entities.users.services;

import org.json.JSONObject;

import hico.group.assesment.demo.entities.users.Users;
import hico.group.assesment.demo.entities.users.repository.UserRepository;
import hico.group.assesment.demo.utils.Encryption;

public class UserServices {

    private final Encryption encryption = new Encryption();

    public Users addUser(JSONObject UserData, UserRepository userRepository) {
        Users users = new Users();
        users.setEmail(UserData.getString("email"));
        users.setEnabled(UserData.getBoolean("isEnabled"));
        users.setUsername(UserData.getString("username"));
        users.setPassword(encryption.encryptPassword(UserData.getString("password")));
        users.setFirstName(UserData.getString("firstName"));
        users.setLastName(UserData.getString("lastName"));
        users.setRoleId(UserData.getInt("roleId"));
        return userRepository.save(users);
    }

    public Users updateUser(Long id, JSONObject UpdatedUserData, UserRepository userRepository) {
        Users userFoundById = userRepository.getReferenceById(id);
        userFoundById.setEmail(UpdatedUserData.getString("email"));
        userFoundById.setEnabled(UpdatedUserData.getBoolean("isEnabled"));
        userFoundById.setUsername(UpdatedUserData.getString("username"));
        userFoundById.setPassword(encryption.encryptPassword(UpdatedUserData.getString("password")));
        userFoundById.setFirstName(UpdatedUserData.getString("firstName"));
        userFoundById.setLastName(UpdatedUserData.getString("lastName"));
        userFoundById.setRoleId(UpdatedUserData.getInt("roleId"));
        return userRepository.save(userFoundById);
    }

    public void deleteUser(Long id, UserRepository userRepository) {
        userRepository.deleteById(id);
    }

    public void bulkDeleteUsers(Iterable<Long> ids, UserRepository userRepository) {
        userRepository.deleteAllById(ids);
    }

}