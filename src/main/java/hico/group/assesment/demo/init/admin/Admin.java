package hico.group.assesment.demo.init.admin;

import org.json.JSONObject;

public class Admin {
    public JSONObject adminUser() {
        return new JSONObject()
                .put("id", 1)
                .put("username", "admin")
                .put("password", "password")
                .put("firstName", "Sylvester")
                .put("lastName", "Stephenson")
                .put("email", "sylvester@redcore.co.za")
                .put("roleId", 1)
                .put("isEnabled", true);
    }
}