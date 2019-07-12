package ir.sajjadyosefi.evaluation.classes.model.request;

import ir.sajjadyosefi.evaluation.classes.model.request.account.LoginRequest;
import ir.sajjadyosefi.evaluation.model.business.Task;

public class SendTaskToServerObject extends LoginRequest {
    public Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
