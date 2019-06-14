package ir.sajjadyosefi.evaluation.classes.model.responses.Abfax;

import java.util.List;

import ir.sajjadyosefi.evaluation.model.business.Task;
import ir.sajjadyosefi.evaluation.model.exception.TubelessException;

/**
 * Created by sajjad on 10/31/2016.
 */
public class ListTasks {

    private List<Task> object;
    private TubelessException exception;

    public List<Task> getObject() {
        return object;
    }

    public void setObject(List<Task> object) {
        this.object = object;
    }

    public TubelessException getException() {
        return exception;
    }

    public void setException(TubelessException exception) {
        this.exception = exception;
    }



}
