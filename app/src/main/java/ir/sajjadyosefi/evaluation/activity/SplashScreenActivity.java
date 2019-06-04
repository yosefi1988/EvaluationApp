package ir.sajjadyosefi.evaluation.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;

import com.activeandroid.Model;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.List;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.classes.SAccounts;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.model.request.account.DeviceRequest;
import ir.sajjadyosefi.evaluation.classes.model.responses.basic.ServerResponseBase;
import ir.sajjadyosefi.evaluation.classes.utility.DateConverterSjd;
import ir.sajjadyosefi.evaluation.model.db.Category;
import ir.sajjadyosefi.evaluation.model.db.Config;
import ir.sajjadyosefi.evaluation.model.db.Task;
import ir.sajjadyosefi.evaluation.networkLayout.retrofit.TubelessRetrofitCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreenActivity extends TubelessActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);
        setRootActivity(((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));

        init(getContext());

        initDb(getContext());


//        DeviceRequest loginRequest = new DeviceRequest(
//                DeviceUtil.GetAndroidId(getContext()),
//                Build.SERIAL,
//                Build.MODEL,
//                Build.ID,
//                Build.VERSION.RELEASE,
//                Build.VERSION.SDK_INT,
//                Build.MANUFACTURER,
//                Build.BRAND,
//                Build.BOARD,
//                Build.DISPLAY);
//        DeviceRegister(loginRequest);

        dialog.show();

//        Category restaurants = new Category();
//        restaurants.name = "Restaurants";
//        restaurants.save();
//
//        Task item = new Task();
//        item.category = restaurants;
//        item.name = "Outback Steakhouse";
//        item.save();
//
//


        ///Bulk insert
//        ActiveAndroid.beginTransaction();
//        try {
//            for (int i = 0; i < 100; i++) {
//                Task item2 = new Task();
//                item2.name = "Example " + i;
//                item2.save();
//            }
//            ActiveAndroid.setTransactionSuccessful();
//        }
//        finally {
//            ActiveAndroid.endTransaction();
//        }


        //delete
//        Task item3 = Task.load(Task.class, 1);
//        item3.delete();
        //or
//        item3.delete(Task.class, 1);
        //or
//        new Delete().from(Task.class).where("Id = ?", 1).execute();


        //update
//        new Update(Task.class)
//                .set("Enabled = 0")
//                .where("Account = ?", 5)
//                .execute();
    }

    private void initDb(Context context) {

        //Persian Date // shamsi date
        DateConverterSjd dateConverterSjd = new DateConverterSjd();
        DateConverterSjd.SolarCalendar todayDate = new DateConverterSjd.SolarCalendar();
        String sssssssssss = dateConverterSjd.getCurrentShamsidate();



        List<Config> configList = new Select()
                .from(Config.class)
                .where("Day = ?", todayDate.getDay()
                        )
                .execute();

        if (configList.size() == 0){
            //clear db config
            new Delete().from(Config.class).execute();

            //get from server
            Config configNew = new Config();
            configNew.ServerConfig = "server json string";
            configNew.Day = todayDate.getDay();


            //save to db
            configNew.save();

            //init model in GLobal
            Gson gson = new Gson();
            //XMODEL model = gson.toJson(configNew.ServerConfig ,XMODEL.class);
            startMainActivity();
        }else {
            //init model in GLobal
            Gson gson = new Gson();
            //XMODEL model = gson.toJson(configList.get(0).ServerConfig ,XMODEL.class);
            startMainActivity();
        }

    }

    private void init(Context context) {
        SAccounts sAccounts = new SAccounts(context);
        Global.IDUser = sAccounts.getUserAccountID();

    }


    private void DeviceRegister(DeviceRequest deviceRequest) {
        Global.apiManagerTubeless.deviceRregister(deviceRequest,new TubelessRetrofitCallback<Object>(getContext(), getRootActivity(), true, null, new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Gson gson = new Gson();
                JsonElement jsonElement = gson.toJsonTree(response.body());
                ServerResponseBase responseX = gson.fromJson(jsonElement.getAsString(), ServerResponseBase.class);

                startMainActivity();
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        }));
    }

    private void startMainActivity() {
        Intent autoActivityIntent =  new Intent(getContext(), MainActivity.class);
//                Bundle bundleAuto = new Bundle();
//                bundleAuto.putString("type","NEW_Auto");
//                bundleAuto.putString("BankNumber" , phoneNumber );
//                bundleAuto.putString("Message" , message );
//                autoActivityIntent.putExtras(bundleAuto);
//        getContext().startActivity(autoActivityIntent);
//        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        dialog.dismiss();
    }
}
