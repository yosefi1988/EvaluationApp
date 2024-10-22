package ir.sajjadyosefi.evaluation.networkLayout.retrofit;

import android.content.Context;
import android.os.Handler;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;
import android.widget.ProgressBar;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import ir.sajjadyosefi.evaluation.model.exception.TubelessException;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.model.responses.basic.ServerResponseBase;
import ir.sajjadyosefi.evaluation.classes.model.responses.post.ServerResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRetrofitCallback<Object> implements Callback<java.lang.Object> {
    @SuppressWarnings("unused")
    private static final String TAG = "RetrofitCallback";
    private final Context mContext;
    private final View buttonSubmit;
    private final boolean showResult;
    private View rootView;
    private final Callback<java.lang.Object> mCallback;

    public PostRetrofitCallback(Context context, View rootView, boolean showResult, View buttonSubmit, Callback<java.lang.Object> callback) {
        this.mContext = context;
        this.rootView = rootView;
        this.buttonSubmit = buttonSubmit;
        this.mCallback = callback;
        this.showResult = showResult;
        preRequest();
    }

    private void preRequest() {
        if (buttonSubmit != null)
            buttonSubmit.setEnabled(false);

        ((TubelessActivity)mContext).dialog.show();
    }

    private void afterResponse() {
        if (buttonSubmit != null)
            buttonSubmit.setEnabled(true);


        ((TubelessActivity)mContext).dialog.hide();
        if (rootView != null) {
//            final View progress = rootView.findViewById(R.id.circleProgress);
//            if (progress != null) {
//                Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        progress.setVisibility(View.INVISIBLE);

//                    }
//                }, 800);
//            }
        }
    }

    @Override
    public void onResponse(Call<java.lang.Object> call, Response<java.lang.Object> response) {
        afterResponse();

        int a =0 ;
        a++;

//        ServerResponse responseX = (ServerResponse) response.body();

        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(response.body());
        ServerResponse responseX = gson.fromJson(jsonElement, ServerResponse.class);

        try {
            if (response.body() != null ) {
//                if (responseX.getCode() != 0) {
                    if (responseX.getCode() == 200 || responseX.getCode() == 0) {
                        if (call != null && response != null)
                            mCallback.onResponse(call, response);
                    } else {
                        throw new TubelessException(responseX.getCode());
                    }
//                }else {
//                    throw new TubelessException();
//                }
            }else {
                throw new TubelessException();
            }
        } catch (TubelessException sException) {
            sException.printStackTrace();
            if (showResult) {
                ServerResponseBase responseX2 = new ServerResponseBase();
                TubelessException serverstatus = new TubelessException();
                serverstatus.setCode(responseX.getCode());
                serverstatus.setMessage(responseX.getMessage());
//                responseX2.setTubelessException(serverstatus);
                sException.handleServerMessage(mContext, rootView, responseX2);
            }
        }catch (Exception sException) {
            sException.printStackTrace();
        }

    }

//    @Override
//    public void onFailure(Call<java.lang.Object> call, Throwable t) {
//        if (rootView != null) {
//            View progress = (ProgressBar) rootView.findViewById(R.id.progress);
//            progress.setVisibility(View.INVISIBLE);
//        }
//        //mCallback.onFailure(call, t);
//    }

    @Override
    public void onFailure(final Call<java.lang.Object> call, Throwable t) {
        int a =0 ;
        a++;

        try {
            showConnectionLostDialog(mContext, null , new Runnable() {
                @Override
                public void run() {
                    retry(call);
                }
            });
        }catch (Exception ex){
            int aX =0 ;
            aX  ++;

        }
    }


    public static void showConnectionLostDialog(Context context, final ProgressBar progressBar, final Runnable runnable) {
        final BottomSheetDialog dialog = new BottomSheetDialog(context);
        TubelessException.ShowSheetDialog(context,dialog ,new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(runnable,5);
                dialog.dismiss();
                if (progressBar != null)
                    progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    private void retry(Call<java.lang.Object> call) {
        call.clone().enqueue(this);
    }



    public void retry(Call<java.lang.Object> call, Throwable t) {

    }
}