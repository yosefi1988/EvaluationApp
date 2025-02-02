package ir.sajjadyosefi.evaluation.classes;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Bundle;

public class SAccounts {

    //var
    private AccountManager mAccountManager;

    //val
    public final static String SAMANIUM_AUTH_TYPE = "AUTH_TYPE";
    public static final String AUTHTOKEN_TYPE_NORMAL_ACCESS = "Normal access";
    public static final String AUTHTOKEN_TYPE_ADMIN_ACCESS = "Admin access";
    public static final String ACCOUNT_TYPE = "ir.sajjadyosefi.evaluation";
    public final static String SAMANIUM_ACCOUNT_TYPE = "ACCOUNT_TYPE";
    public final static String SAMANIUM_ACCOUNT_NAME = "ACCOUNT_NAME";






    public SAccounts(Context context) {
        mAccountManager = AccountManager.get(context);
    }


    public Account getUserAccount() {
        Account availableAccounts[] = mAccountManager.getAccountsByType(ACCOUNT_TYPE);
        if (availableAccounts.length != 0)
            return availableAccounts[0];
        else
            return null;
    }



    public String getUserAccountID() {
        if (hasUserAccount()) {
            return mAccountManager.getUserData(getUserAccount(), "UserID");
        }else {
            return "20053";
        }
    }

    public boolean hasUserAccount() {
        if (getUserAccount() == null) {
            return false;
        } else {
            return true;
        }
    }

    public AccountManager getAccountManager() {
        return mAccountManager;
    }

    public void createAccount(String name,String UserID) {
        final Account account = new Account(name, ACCOUNT_TYPE) ;
        Bundle data = new Bundle();
        data.putString("UserID", String.valueOf(UserID));
        this.getAccountManager().addAccountExplicitly(account, "tubeless",data);

    }
}
