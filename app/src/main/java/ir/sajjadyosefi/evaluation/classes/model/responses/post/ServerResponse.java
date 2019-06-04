package ir.sajjadyosefi.evaluation.classes.model.responses.post;

import ir.sajjadyosefi.evaluation.model.main.PostSearchResponseItem;
import ir.sajjadyosefi.evaluation.classes.model.responses.basic.ServerStatus;

import java.util.List;

/**
 * Created by sajjad on 3/1/2017.
 */
public class ServerResponse {
    private int code;
    private String message;
    private String type;

    private ServerStatus serverStatus;

    private List<PostSearchResponseItem> data ;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public List<PostSearchResponseItem> getData() {
        return data;
    }

    public void setData(List<PostSearchResponseItem> data) {
        this.data = data;
    }

    public ServerStatus getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(ServerStatus serverStatus) {
        this.serverStatus = serverStatus;
    }


}
