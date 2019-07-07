package ir.sajjadyosefi.evaluation.classes;

import android.app.Application;
import android.content.Context;

import com.activeandroid.ActiveAndroid;

import java.util.ArrayList;
import java.util.List;

import cn.refactor.kmpautotextview.ItemData;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.AbfaxSelects;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.NetworkAndBranch.WaterBranch;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.NetworkAndBranch.WaterNetwork;
import ir.sajjadyosefi.evaluation.model.business.Task;
import ir.sajjadyosefi.evaluation.model.main.User;
import ir.sajjadyosefi.evaluation.networkLayout.retrofit.RetrofitHelperPost;
import ir.sajjadyosefi.evaluation.networkLayout.retrofit.RetrofitHelperService;


/**
 * Created by Sajad on 2/11/2017.
 */
public class Global extends Application {

    public static final int IDApplicationVersion = 101;

    private static Context mContext;
    public static String token;
    //public static RetrofitHelperPost apiManagerPost;
    public static RetrofitHelperService apiManagerTubeless;




//    __________ global _______
//    selects
//    task Item
    public static String user = null;
    public static AbfaxSelects allSelects;
    public static Task CurrentTask = null;

//
//    ________ database _________
//    selects
//    task Item list


    //اضافه شده توسط ارزیاب در هنگام بازدید از محل
    public static List<WaterNetwork> listNetwork = new ArrayList<>();
    public static List<WaterBranch> listBranchs = new ArrayList<>();


    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);

        mContext = this;
        //apiManagerPost = RetrofitHelperPost.getInstance();
        apiManagerTubeless = RetrofitHelperService.getInstance(getApplicationContext());

    }




}