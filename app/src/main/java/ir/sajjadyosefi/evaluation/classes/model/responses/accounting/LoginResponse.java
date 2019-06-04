package ir.sajjadyosefi.evaluation.classes.model.responses.accounting;

import ir.sajjadyosefi.evaluation.model.exception.TubelessException;
import ir.sajjadyosefi.evaluation.model.main.User;

/**
 * Created by sajjad on 10/31/2016.
 */
public class LoginResponse extends User {
    private TubelessException tubelessException;

    public TubelessException getTubelessException() {
        return tubelessException;
    }

    public void setTubelessException(TubelessException tubelessException) {
        this.tubelessException = tubelessException;
    }
}
