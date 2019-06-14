package ir.sajjadyosefi.evaluation.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.List;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.activity.account.LoginActivity;
import ir.sajjadyosefi.evaluation.activity.evaluation.WasterWaterAddActivity;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.classes.SAccounts;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.model.request.account.DeviceRequest;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.AbfaxSelects;
import ir.sajjadyosefi.evaluation.classes.model.responses.basic.ServerResponseBase;
import ir.sajjadyosefi.evaluation.classes.utility.DateConverterSjd;
import ir.sajjadyosefi.evaluation.model.business.WasterWater;
import ir.sajjadyosefi.evaluation.model.db.Config;
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

        SAccounts sAccounts = new SAccounts(getContext());

        // TODO: 6/14/2019 unComment this
//        if (sAccounts.hasUserAccount()) {
        if (true) {
            Global.IDUser = sAccounts.getUserAccountID();
            initDb();
        }else {
            //redirect ro login
            //start activity for result
            Intent i = new Intent(getContext(), LoginActivity.class);
            i.putExtra("From" , "SplashScreen");
            getActivity().startActivityForResult(i, 1);
        }




       // dialog.show();

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


        TextView textView = findViewById(R.id.textViewVersion);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //creating a popup menu
                PopupMenu popup = new PopupMenu(getContext(),findViewById(R.id.textViewVersion));
                //inflating menu from xml resource
                popup.inflate(R.menu.main_fab);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_image:
                                //handle menu1 click
                                break;
                            case R.id.menu_place:
                                //handle menu2 click
                                break;
                            case R.id.menu_emoticon:
                                //handle menu3 click
                                break;
                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result = data.getStringExtra("result");

                if (result != null && result.equals("ok")){
                    initDb();
                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
                finish();
            }
        }
    }//onActivityResult


    private void initDb() {

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
            Global.apiManagerTubeless.getSelects(new TubelessRetrofitCallback<java.lang.Object>(getContext(), getRootActivity(), true, null, new Callback<java.lang.Object>() {
                @Override
                public void onResponse(Call<java.lang.Object> call, Response<Object> response) {
                    Gson gson = new Gson();
                    JsonElement jsonElement = gson.toJsonTree(response.body());
                    AbfaxSelects responseX = gson.fromJson(jsonElement, AbfaxSelects.class);


                    Config configNew = new Config();
                    configNew.ServerConfig = jsonElement.toString();
                    configNew.Day = todayDate.getDay();


                    //save to db
                    configNew.save();

                    //init model in GLobal
                    AbfaxSelects model = gson.fromJson(configList.get(0).ServerConfig ,AbfaxSelects.class);
                    startMainActivity();
                }

                @Override
                public void onFailure(Call<java.lang.Object> call, Throwable t) {

                    int a = 5 ;
                    a++;
                }
            }));


        }else {
            //init model in GLobal
            Gson gson = new Gson();
            AbfaxSelects model = gson.fromJson(configList.get(0).ServerConfig ,AbfaxSelects.class);
            startMainActivity();
        }

    }




    private void startMainActivity() {
        Intent autoActivityIntent =  new Intent(getContext(), MainActivity.class);
//                Bundle bundleAuto = new Bundle();
//                bundleAuto.putString("type","NEW_Auto");
//                bundleAuto.putString("BankNumber" , phoneNumber );
//                bundleAuto.putString("Message" , message );
//                autoActivityIntent.putExtras(bundleAuto);
        getContext().startActivity(autoActivityIntent);
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        dialog.dismiss();
    }
}
