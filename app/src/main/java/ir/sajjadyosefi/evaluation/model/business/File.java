package ir.sajjadyosefi.evaluation.model.business;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.squareup.picasso.Transformation;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.activity.business.DetailsActivity;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.classes.model.request.account.DownloadFileRequest;
import ir.sajjadyosefi.evaluation.classes.model.request.account.LoginRequest;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.DownloadDocument;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.DownloadObject;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.ListTasks;
import ir.sajjadyosefi.evaluation.classes.utility.RoundedCornersTransformation;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;
import ir.sajjadyosefi.evaluation.networkLayout.retrofit.TubelessRetrofitCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.yalantis.ucrop.util.BitmapLoadUtils.calculateInSampleSize;

public class File extends TubelessObject {

    public static int MAP_K = 1000 ;
    public static int MAP_1 = 1001 ;
    public static int MAP_2 = 1002 ;
    public static int MAP_3 = 1003 ;

    private String uri;
    private String title;
    private int fileType;
    private int requestContentId;
    private int frame;

    public int getRequestContentId() {
        return requestContentId;
    }

    public void setRequestContentId(int requestContentId) {
        this.requestContentId = requestContentId;
    }

    public int getFrame() {
        return frame;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }


    public void prepareYafteItem(Context mContext, EndlessList_Adapter.FileViewHolder holder, List<TubelessObject> mTimelineItemList, int position, EndlessList_Adapter adapter, boolean deletable) {

        File file = (File) mTimelineItemList.get(position);

        StringBuilder text = new StringBuilder();
        text.append(file.getTitle());

        holder.textView.setText(text.toString());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadFileRequest loginRequest = new DownloadFileRequest();
                loginRequest.setContentId(file.getRequestContentId() + "");
                loginRequest.setFrame(file.getFrame() + "");
                Global.apiManagerTubeless.getDocument(loginRequest,new TubelessRetrofitCallback<Object>(mContext, holder.rootView, true, null, new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        Gson gson = new Gson();
                        JsonElement jsonElement = gson.toJsonTree(response.body());
                        DownloadDocument downloadObject = gson.fromJson(jsonElement , DownloadDocument.class);

                        Bitmap bmp = BitmapFactory.decodeByteArray(downloadObject.getObject().getContent().getBytes(), 0, downloadObject.getObject().getContent().length());
//                        DetailsActivity.ImageView.setImageBitmap(bmp);


                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {

                    }
                }));
            }
        });

        holder.buttonDelete.setEnabled(deletable);
        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTimelineItemList.remove(position);

                if (mTimelineItemList.size() == 0 )
                    holder.textView.setText(R.string.not_any_file);

                adapter.notifyDataSetChanged();
            }
        });

    }


}
