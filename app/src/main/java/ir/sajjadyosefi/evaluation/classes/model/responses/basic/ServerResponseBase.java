package ir.sajjadyosefi.evaluation.classes.model.responses.basic;

import ir.sajjadyosefi.evaluation.model.exception.TubelessException;

/**
 * Created by sajjad on 10/31/2016.
 */
public class ServerResponseBase {
    private TubelessException tubelessException;

    public TubelessException getTubelessException() {
        return tubelessException;
    }

    public void setTubelessException(TubelessException tubelessException) {
        this.tubelessException = tubelessException;
    }
}
