package ir.sajjadyosefi.evaluation.networkLayout.retrofit;

import android.graphics.Movie;
import ir.sajjadyosefi.evaluation.classes.model.request.SearchRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

/**
 * Created by sajjad on 11/7/2018.
 */

public interface ApiServicePost {
//    @GET("questions")
//    Call<Question> getQuestionsService(@Query("page") int page,
//                                       @Query("pagesize") int pagesize,
//                                       @Query("order") String order,
//                                       @Query("sort") String sort,
//                                       @Query("tagged") String tagged,
//                                       @Query("site") String site);

    @GET("movies.json")
    Call<List<Movie>> getMoviesService();

//    @POST("/data/2.1")
//    Call < T > postMovieDetails(
//            @Field("userId") String userID,
//            @Field("token") String token);


    @POST("SearchAllHandler.ashx")
    Call<Object> search(@Body SearchRequest searchRequest);
}
