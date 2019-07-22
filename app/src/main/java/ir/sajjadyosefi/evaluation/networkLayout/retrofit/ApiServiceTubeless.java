package ir.sajjadyosefi.evaluation.networkLayout.retrofit;

import android.graphics.Movie;

import com.squareup.okhttp.RequestBody;

import ir.sajjadyosefi.evaluation.classes.model.request.SearchRequest;
import ir.sajjadyosefi.evaluation.classes.model.request.SendTaskToServerObject;
import ir.sajjadyosefi.evaluation.classes.model.request.account.DeviceRequest;
import ir.sajjadyosefi.evaluation.classes.model.request.account.DownloadFileRequest;
import ir.sajjadyosefi.evaluation.classes.model.request.account.LoginRequest;
import ir.sajjadyosefi.evaluation.model.business.Task;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

import java.util.List;

/**
 * Created by sajjad on 11/7/2018.
 */

public interface ApiServiceTubeless {
//    @GET("questions")
//    Call<Question> getQuestionsService(@Query("page") int page,
//                                       @Query("pagesize") int pagesize,
//                                       @Query("order") String order,
//                                       @Query("sort") String sort,
//                                       @Query("tagged") String tagged,
//                                       @Query("site") String site);

//    @POST("api/CheckLoginUser")
//    Call<Object> login(@Query("UserName") String systemUserName,
//                       @Query("UserName") String Password,
//                       @Query("AndroidId") String AndroidId,
//                       @Query("LoginUser") String LoginUser,
//                       @Query("LoginPass") String LoginPass,
//                       @Body LoginRequest request);

//    @GET("movies.json")
//    Call<List<Movie>> getMoviesService();

//    @POST("/data/2.1")
//    Call < T > postMovieDetails(
//            @Field("userId") String userID,
//            @Field("token") String token);



    @POST("api/GetAllEvaluationRequest")
    Call<Object> GetAllEvaluationRequest(@Body LoginRequest request);


    @POST("api/GetAllSelect")
    Call<Object> selectValues(@Body LoginRequest request);

    @POST("api/CheckLoginUser")
    Call<Object> login(@Body LoginRequest request);


    @POST("api/DownloadFile")
    Call<Object> documents(@Body DownloadFileRequest request);


    @POST("api/send")
    Call<Object> sendData(@Body SendTaskToServerObject request);

    @Multipart
    @POST("api/send")
    Call<java.lang.Object> upload(
            @Part("description") RequestBody description,
            @Part MultipartBody.Part file,
            @Part("UserID") RequestBody s,
            @Part("ip") RequestBody ip,
            @Part("ub1e6d0e_00d5_4934_bbc1_0de5de92725d") RequestBody u,
            @Part("pa369647_2eb2_469d_b894_09ad85a0e347") RequestBody p);
}
