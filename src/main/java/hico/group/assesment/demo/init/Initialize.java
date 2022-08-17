package hico.group.assesment.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import hico.group.assesment.demo.entities.users.repository.UserRepository;
import hico.group.assesment.demo.entities.users.services.UserServices;
import hico.group.assesment.demo.init.admin.Admin;
import hico.group.assesment.demo.utils.Env;

import java.util.Objects;

@Component
public class Initialize implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    Env env = new Env();
    Admin admin = new Admin();
    UserServices userServices = new UserServices();

    @Override
    public void run(String... args) throws Exception {
        if (Objects.equals(env.getEnv("FRESH_INITIALIZE"), "TRUE")) {
            System.out.println("[Initialize User Accounts]");
            userServices.addUser(admin.adminUser(), userRepository);
        }
    }
}
