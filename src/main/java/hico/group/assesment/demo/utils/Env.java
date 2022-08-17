package hico.group.assesment.demo.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class Env {

    private final Dotenv dotenv = Dotenv.configure()
            .directory(new Utils().dirname() + "/")
            .filename(".env")
            .load();

    public String getEnv(String key) {
        return dotenv.get(key);
    }
}
