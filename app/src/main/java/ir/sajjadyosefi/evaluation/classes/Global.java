package ir.sajjadyosefi.evaluation.classes;

import android.app.Application;
import android.content.Context;

import com.activeandroid.ActiveAndroid;

import ir.sajjadyosefi.evaluation.model.main.User;
import ir.sajjadyosefi.evaluation.networkLayout.retrofit.RetrofitHelperPost;
import ir.sajjadyosefi.evaluation.networkLayout.retrofit.RetrofitHelperTubeless;


/**
 * Created by Sajad on 2/11/2017.
 */
public class Global extends Application {

    public static final int IDApplicationVersion = 101;
    public static int IDUser = 20053 ;
    public static User user = null;

    private static Context mContext;
    public static String token;
    public static RetrofitHelperPost apiManagerPost;
    public static RetrofitHelperTubeless apiManagerTubeless;



//    __________ global _______
//    selects
//    task Item
//    user
//
//    ________ database _________
//    selects
//    task Item list




    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);

        mContext = this;
        apiManagerPost = RetrofitHelperPost.getInstance();
        apiManagerTubeless = RetrofitHelperTubeless.getInstance(getApplicationContext());

    }




}