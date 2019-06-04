package ir.sajjadyosefi.evaluation.model.main;

public class User extends TubelessObject{
    public long userId;
    public String userName;
    public String email;
    public String mobileNumber;
    public String userImage;
    public String profileImage;
    public long balanse;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public long getBalanse() {
        return balanse;
    }

    public void setBalanse(long balanse) {
        this.balanse = balanse;
    }


}
