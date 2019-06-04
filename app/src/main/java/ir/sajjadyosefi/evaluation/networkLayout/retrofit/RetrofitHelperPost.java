package ir.sajjadyosefi.evaluation.networkLayout.retrofit;


import ir.sajjadyosefi.evaluation.classes.model.request.SearchRequest;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sajjad on 11/7/2018.
 */

public class RetrofitHelperPost {

    private static ApiServicePost service;
    private static RetrofitHelperPost apiManager;

    private RetrofitHelperPost() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://postyafteh.post.ir/r/Handlers/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiServicePost.class);
    }

    public static RetrofitHelperPost getInstance() {
        if (apiManager == null) {
            apiManager = new RetrofitHelperPost();
        }
        return apiManager;
    }

    public void createUser(SearchRequest searchRequest, PostRetrofitCallback<Object> callback) {
        Call<Object> userCall = service.search(searchRequest);
        userCall.enqueue(callback);
    }
//    public void createUser(SearchRequest searchRequest, Callback<ServerResponse> callback) {
//        Call<ServerResponse> userCall = service.search(searchRequest);
//        userCall.enqueue(callback);
//    }
}
