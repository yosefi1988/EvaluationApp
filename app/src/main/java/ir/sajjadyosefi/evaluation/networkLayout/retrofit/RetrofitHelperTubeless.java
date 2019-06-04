package ir.sajjadyosefi.evaluation.networkLayout.retrofit;


import ir.sajjadyosefi.evaluation.classes.model.request.SearchRequest;
import ir.sajjadyosefi.evaluation.classes.model.request.account.DeviceRequest;
import ir.sajjadyosefi.evaluation.classes.model.request.account.LoginRequest;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sajjad on 11/7/2018.
 */

public class RetrofitHelperTubeless {

    private static ApiServiceTubeless service;
    private static RetrofitHelperTubeless apiManager;

    private RetrofitHelperTubeless() {

        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://10.0.2.2:3000/")
                .baseUrl("http://192.168.43.140/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiServiceTubeless.class);
    }

    public static RetrofitHelperTubeless getInstance() {
        if (apiManager == null) {
            apiManager = new RetrofitHelperTubeless();
        }
        return apiManager;
    }

    public void deviceRregister(DeviceRequest request, TubelessRetrofitCallback<Object> callback) {
        Call<Object> userCall = service.deviceRegister(request);
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
