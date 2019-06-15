package ir.sajjadyosefi.evaluation.classes.model.responses.accounting;

import ir.sajjadyosefi.evaluation.classes.model.responses.basic.ServerResponseBase;
import ir.sajjadyosefi.evaluation.model.exception.TubelessException;
import ir.sajjadyosefi.evaluation.model.main.User;

/**
 * Created by sajjad on 10/31/2016.
 */
public class LoginResponse extends ServerResponseBase {

    private String object;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

}
