package ir.sajjadyosefi.evaluation.classes.model.request.account;

import static ir.sajjadyosefi.evaluation.networkLayout.retrofit.RetrofitHelperService.androidId;
import static ir.sajjadyosefi.evaluation.networkLayout.retrofit.RetrofitHelperService.systemPassword;
import static ir.sajjadyosefi.evaluation.networkLayout.retrofit.RetrofitHelperService.systemUserName;

public class LoginRequest {

    private String UserName;
    private String Password;
    private String LoginUser;
    private String LoginPass;
    private String AndroidId;

    public LoginRequest() {
        UserName = systemUserName;
        Password = systemPassword;
        AndroidId = androidId;
    }

    public LoginRequest(String userPhone, String userPassword) {
        UserName = systemUserName;
        Password = systemPassword;

        LoginUser = userPhone;
        LoginPass = userPassword;
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

    public String getLoginUser() {
        return LoginUser;
    }

    public void setLoginUser(String loginUser) {
        LoginUser = loginUser;
    }

    public String getLoginPass() {
        return LoginPass;
    }

    public void setLoginPass(String loginPass) {
        LoginPass = loginPass;
    }

    public String getAndroidId() {
        return AndroidId;
    }

    public void setAndroidId(String androidId) {
        AndroidId = androidId;
    }


}
