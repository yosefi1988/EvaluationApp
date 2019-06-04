package ir.sajjadyosefi.evaluation.classes.model.responses.basic;

import java.io.Serializable;

/**
 * Created by sajjad on 2/27/2017.
 */
public class ServerStatus implements Serializable {

    int Code ;
    String Message ;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

}
