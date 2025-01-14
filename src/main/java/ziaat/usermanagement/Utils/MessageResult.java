package ziaat.usermanagement.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MessageResult {
    public ResponseEntity<Map<String, Object>> getMessage(String message){
        String code = "5001";
        if(message.equals("Successfully")){
            code = "5000";
        }
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("code", code);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

