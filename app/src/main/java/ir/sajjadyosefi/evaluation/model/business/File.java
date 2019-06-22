package ir.sajjadyosefi.evaluation.model.business;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Transformation;

import java.util.List;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.utility.RoundedCornersTransformation;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

public class File extends TubelessObject {

    public static int MAP_K = 1000 ;
    public static int MAP_1 = 1001 ;
    public static int MAP_2 = 1002 ;
    public static int MAP_3 = 1003 ;

    private String name;
    private String uri;
    private String url;
    private String title;
    private int fileType;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        text.append(file.getName());

        holder.textView.setText(text.toString());

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
