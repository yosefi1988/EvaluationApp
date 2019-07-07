package ir.sajjadyosefi.evaluation.classes.model.responses.Abfax;

import ir.sajjadyosefi.evaluation.model.exception.TubelessException;

/**
 * Created by sajjad on 10/31/2016.
 */
public class DownloadDocument {


    private TubelessException exception;
    private DownloadObject object;

    public DownloadObject getObject() {
        return object;
    }

    public void setObject(DownloadObject object) {
        this.object = object;
    }

    public TubelessException getException() {
        return exception;
    }

    public void setException(TubelessException exception) {
        this.exception = exception;
    }






}
