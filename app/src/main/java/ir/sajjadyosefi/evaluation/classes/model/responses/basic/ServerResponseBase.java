package ir.sajjadyosefi.evaluation.classes.model.responses.basic;

import ir.sajjadyosefi.evaluation.model.exception.TubelessException;

/**
 * Created by sajjad on 10/31/2016.
 */
public class ServerResponseBase {
    private TubelessException exception;

    public TubelessException getTubelessException() {
        return exception;
    }

    public void setTubelessException(TubelessException tubelessException) {
        this.exception = tubelessException;
    }
}
