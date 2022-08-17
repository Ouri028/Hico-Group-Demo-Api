package hico.group.assessment.demo.exceptions;

import org.json.JSONObject;

public class CustomJwtExceptions {

    public String JwtTokenException(String message) {
        return new JSONObject()
                .put("error", "JWT_EXCEPTION")
                .put("message", message)
                .put("validated", false)
                .toString();
    }
}