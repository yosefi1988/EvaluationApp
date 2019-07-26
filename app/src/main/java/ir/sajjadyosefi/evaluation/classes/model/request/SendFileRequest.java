package ir.sajjadyosefi.evaluation.classes.model.request;

import ir.sajjadyosefi.evaluation.classes.model.request.account.LoginRequest;

import static ir.sajjadyosefi.evaluation.networkLayout.retrofit.RetrofitHelperService.androidId;
import static ir.sajjadyosefi.evaluation.networkLayout.retrofit.RetrofitHelperService.systemPassword;
import static ir.sajjadyosefi.evaluation.networkLayout.retrofit.RetrofitHelperService.systemUserName;

public class SendFileRequest extends LoginRequest {

    private String serialRequestCode;
    private String fileType;
    private String senderType;


    public String getSerialRequestCode() {
        return serialRequestCode;
    }

    public void setSerialRequestCode(String serialRequestCode) {
        this.serialRequestCode = serialRequestCode;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getSenderType() {
        return senderType;
    }

    public void setSenderType(String senderType) {
        this.senderType = senderType;
    }

}
