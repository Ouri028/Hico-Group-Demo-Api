package hico.group.assesment.demo.response;

import org.json.JSONObject;

public class JwtToken {

    public String decodedTokenData(String tokenData) {
        return new JSONObject()
                .put("status", "valid")
                .put("message", new JSONObject(tokenData))
                .put("validated", true)
                .toString();
    }
}
