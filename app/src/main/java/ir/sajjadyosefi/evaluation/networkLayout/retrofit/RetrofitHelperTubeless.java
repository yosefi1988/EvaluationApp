package ir.sajjadyosefi.evaluation.networkLayout.retrofit;


import android.content.Context;

import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.classes.model.request.account.DeviceRequest;
import ir.sajjadyosefi.evaluation.classes.model.request.account.LoginRequest;
import ir.sajjadyosefi.evaluation.classes.utility.DeviceUtil;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sajjad on 11/7/2018.
 */

public class RetrofitHelperTubeless {

    private static ApiServiceTubeless service;
    private static RetrofitHelperTubeless apiManager;

    private static final String userName = "ApiService";
    private static final String password = "BandarAndroid";
    private static String androidId ;


    private RetrofitHelperTubeless() {

        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://10.0.2.2:3000/")
                .baseUrl("http://shop.atiafkar.ir/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiServiceTubeless.class);
    }

    public static RetrofitHelperTubeless getInstance(Context applicationContext) {
        if (apiManager == null) {
            apiManager = new RetrofitHelperTubeless();
        }
        androidId = DeviceUtil.GetAndroidId(applicationContext);
        return apiManager;
    }

    public void getSelects(TubelessRetrofitCallback<Object> callback) {
        Call<Object> userCall = service.selectValues(userName,password, androidId);
        userCall.enqueue(callback);
    }
    public void loginOrRregister(LoginRequest request, TubelessRetrofitCallback<Object> callback) {
        Call<Object> userCall = service.login(request);
        userCall.enqueue(callback);
    }
    public void getTimeline(int index, TubelessRetrofitCallback<Object> callback) {
        Call<Object> userCall = service.getTimeline(index,15);
        userCall.enqueue(callback);
    }
//    public void createUser(SearchRequest searchRequest, Callback<ServerResponse> callback) {
//        Call<ServerResponse> userCall = service.search(searchRequest);
//        userCall.enqueue(callback);
//    }
}
