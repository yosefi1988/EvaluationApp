package ir.sajjadyosefi.evaluation.networkLayout.retrofit;


import android.content.Context;

import ir.sajjadyosefi.evaluation.classes.model.request.account.LoginRequest;
import ir.sajjadyosefi.evaluation.classes.utility.DeviceUtil;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sajjad on 11/7/2018.
 */

public class RetrofitHelperService {

    private static ApiServiceTubeless service;
    private static RetrofitHelperService apiManager;

    private static final String userName = "ApiService";
    private static final String password = "BandarAndroid";
    private static String androidId ;


    private RetrofitHelperService() {

        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://10.0.2.2:3000/")
                .baseUrl("http://shop.atiafkar.ir/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiServiceTubeless.class);
    }

    public static RetrofitHelperService getInstance(Context applicationContext) {
        if (apiManager == null) {
            apiManager = new RetrofitHelperService();
        }
        // TODO: 6/15/2019 uncomment
        //androidId = DeviceUtil.GetAndroidId(applicationContext);
        androidId = "123";
        return apiManager;
    }


//    public void createUser(SearchRequest searchRequest, Callback<ServerResponse> callback) {
//        Call<ServerResponse> userCall = service.search(searchRequest);
//        userCall.enqueue(callback);
//    }

    ///MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM

    public void getSelects(TubelessRetrofitCallback<Object> callback) {
        Call<Object> userCall = service.selectValues(userName,password, androidId);
        userCall.enqueue(callback);
    }
    public void loginOrRregister(LoginRequest request, TubelessRetrofitCallback<java.lang.Object> callback) {
        Call<java.lang.Object> userCall = service.login(userName,password, androidId,request.getLoginUser(),request.getLoginPass());
        userCall.enqueue(callback);
    }

    public void getTasks(int index, TubelessRetrofitCallback<Object> callback) {
        Call<Object> userCall = service.getAllTasks(index,150);
        userCall.enqueue(callback);
    }
    ///MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM


}
