package ir.sajjadyosefi.evaluation.networkLayout.retrofit;


import android.content.Context;

import ir.sajjadyosefi.evaluation.classes.model.request.SendTaskToServerObject;
import ir.sajjadyosefi.evaluation.classes.model.request.account.DownloadFileRequest;
import ir.sajjadyosefi.evaluation.classes.model.request.account.LoginRequest;
import ir.sajjadyosefi.evaluation.classes.utility.DeviceUtil;
import ir.sajjadyosefi.evaluation.model.business.Task;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sajjad on 11/7/2018.
 */

public class RetrofitHelperService {

    private static ApiServiceTubeless service;
    private static RetrofitHelperService apiManager;

    public static final String systemUserName = "ApiService";
    public static final String systemPassword = "BandarAndroid";
    public static String androidId ;


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
        androidId = DeviceUtil.GetAndroidId(applicationContext);
//        androidId = "123";
        return apiManager;
    }


//    public void createUser(SearchRequest searchRequest, Callback<ServerResponse> callback) {
//        Call<ServerResponse> userCall = service.search(searchRequest);
//        userCall.enqueue(callback);
//    }

    ///MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM

    public void getSelects(LoginRequest request,TubelessRetrofitCallback<Object> callback) {
        Call<Object> userCall = service.selectValues(request);
        userCall.enqueue(callback);
    }
    public void loginOrRregister(LoginRequest request, TubelessRetrofitCallback<Object> callback) {
        Call<Object> userCall = service.login(request);
        userCall.enqueue(callback);
    }

    public void getDocument(DownloadFileRequest request, TubelessRetrofitCallback<Object> callback) {
        Call<Object> userCall = service.documents(request);
        userCall.enqueue(callback);
    }

    public void getTasks(LoginRequest request, TubelessRetrofitCallback<Object> callback) {
        Call<Object> userCall = service.GetAllEvaluationRequest(request);
        userCall.enqueue(callback);
    }


    public void sendData(SendTaskToServerObject request, TubelessRetrofitCallback<Object> callback) {
        Call<Object> userCall = service.sendData(request);
        userCall.enqueue(callback);
    }

    ///MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM


}
