package ir.sajjadyosefi.evaluation.classes;

import android.content.Context;
import android.os.Handler;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;
import android.widget.ProgressBar;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import ir.sajjadyosefi.evaluation.model.exception.TubelessException;
import ir.sajjadyosefi.evaluation.classes.model.responses.ServerResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SRetrofitCallback<Object> implements Callback<java.lang.Object> {
    @SuppressWarnings("unused")
    private static final String TAG = "RetrofitCallback";
    private final Context mContext;
    private final View buttonSubmit;
    private final boolean showResult;
    private View rootView;
    private final Callback<java.lang.Object> mCallback;

    public SRetrofitCallback(Context context, View rootView, boolean showResult, View buttonSubmit, Callback<java.lang.Object> callback) {
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
    }

    private void afterResponse() {
        if (buttonSubmit != null)
            buttonSubmit.setEnabled(true);

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



//        ServerResponse responseX = (ServerResponse) response.body();

        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(response.body());
        ServerResponse responseX = gson.fromJson(jsonElement, ServerResponse.class);

        try {
            if (response.body() != null ) {
                if (responseX.getException() != null) {
                    if (responseX.getException().getCode() == 1001 || responseX.getException().getCode() == 1026) {
                        //otpValueValidateResponseComplete(response.body().getResponse());
                        if (call != null && response != null)
                            mCallback.onResponse(call, response);
                    } else {
                        throw new TubelessException(responseX.getException().getCode());
                    }
                }else {
                    throw new TubelessException();
                }
            }else {
                throw new TubelessException();
            }
        } catch (TubelessException samanException) {
//            if (showResult)
//                samanException.handleServerMessage(mContext,rootView,responseX);
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
        try {
//            showConnectionLostDialog(mContext, (ProgressBar) rootView.findViewById(R.id.circleProgress), new Runnable() {
//                @Override
//                public void run() {
//                    retry(call);
//                }
//            });
        }catch (Exception ex){

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