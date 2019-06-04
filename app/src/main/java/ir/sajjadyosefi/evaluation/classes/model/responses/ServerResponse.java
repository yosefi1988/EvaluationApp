package ir.sajjadyosefi.evaluation.classes.model.responses;

import ir.sajjadyosefi.evaluation.classes.model.responses.basic.ServerStatus;
import ir.sajjadyosefi.evaluation.model.exception.TubelessException;

/**
 * Created by sajjad on 3/1/2017.
 */
public class ServerResponse {
    public ServerStatus serverStatus;
    public TubelessException exception;

    public TubelessException getException() {
        return exception;
    }

    public void setException(TubelessException exception) {
        this.exception = exception;
    }


    public ServerStatus getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(ServerStatus serverStatus) {
        this.serverStatus = serverStatus;
    }
}
