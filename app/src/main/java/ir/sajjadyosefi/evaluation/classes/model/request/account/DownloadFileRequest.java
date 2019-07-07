package ir.sajjadyosefi.evaluation.classes.model.request.account;

import static ir.sajjadyosefi.evaluation.networkLayout.retrofit.RetrofitHelperService.androidId;
import static ir.sajjadyosefi.evaluation.networkLayout.retrofit.RetrofitHelperService.systemPassword;
import static ir.sajjadyosefi.evaluation.networkLayout.retrofit.RetrofitHelperService.systemUserName;

public class DownloadFileRequest {

    private String UserName;
    private String Password;
    private String AndroidId;
    private String ContentId;
    private String frame;

    public DownloadFileRequest() {
        UserName = systemUserName;
        Password = systemPassword;
        AndroidId = androidId;
    }


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAndroidId() {
        return AndroidId;
    }

    public void setAndroidId(String androidId) {
        AndroidId = androidId;
    }

    public String getContentId() {
        return ContentId;
    }

    public void setContentId(String contentId) {
        ContentId = contentId;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }




}
