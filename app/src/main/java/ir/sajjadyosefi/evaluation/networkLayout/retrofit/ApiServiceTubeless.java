package ir.sajjadyosefi.evaluation.networkLayout.retrofit;

import android.graphics.Movie;
import ir.sajjadyosefi.evaluation.classes.model.request.SearchRequest;
import ir.sajjadyosefi.evaluation.classes.model.request.account.DeviceRequest;
import ir.sajjadyosefi.evaluation.classes.model.request.account.LoginRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
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
//    Call<Object> login(@Query("UserName") String userName,
//                       @Query("UserName") String Password,
//                       @Query("AndroidId") String AndroidId,
//                       @Query("LoginUser") String LoginUser,
//                       @Query("LoginPass") String LoginPass,
//                       @Body LoginRequest request);

    @GET("movies.json")
    Call<List<Movie>> getMoviesService();

//    @POST("/data/2.1")
//    Call < T > postMovieDetails(
//            @Field("userId") String userID,
//            @Field("token") String token);



    @GET("Api/TimeLine/getTasks")
    Call<Object> getAllTasks(@Query("index") int index,
                             @Query("count") int count);


    @GET("api/GetAllSelect")
    Call<Object> selectValues(@Query("UserName") String UserName ,
                              @Query("Password") String Password,
                              @Query("AndroidId") String AndroidId);

    @POST("api/CheckLoginUser")
    Call<Object> login(@Query("UserName") String userName,
                       @Query("UserName") String Password,
                       @Query("AndroidId") String AndroidId,
                       @Query("LoginUser") String LoginUser,
                       @Query("LoginPass") String LoginPass);




}
