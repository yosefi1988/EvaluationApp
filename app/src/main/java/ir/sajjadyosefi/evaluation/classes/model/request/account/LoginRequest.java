package ir.sajjadyosefi.evaluation.classes.model.request.account;

import ir.sajjadyosefi.evaluation.classes.Global;

public class LoginRequest {


    private String UserName;
    private String Password;
    private String LoginUser;
    private String LoginPass;
    private String AndroidId;

    public LoginRequest(String loginUser, String loginPass) {
        LoginUser = loginUser;
        LoginPass = loginPass;
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
