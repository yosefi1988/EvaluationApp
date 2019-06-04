package ir.sajjadyosefi.evaluation.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.google.gson.Gson;
import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.model.main.TimelineItem;

/**
 * Created by sajjad on 2/11/2018.
 */

public class ReadBlogActivity extends AppCompatActivity {

    Context mContext = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_blog);
        mContext = this;

        Gson gson = new Gson();
        String objectString = getIntent().getStringExtra("Object");
        TimelineItem blogItem = gson.fromJson(objectString, TimelineItem.class);

//        AsyncLoadBlogItem asyncLoadBlogItem = new AsyncLoadBlogItem(
//                mContext,
//                ((DilatingDotsProgressBar)findViewById(R.id.PBSjd)),
//                ((ImageView)findViewById(R.id.iv_menuCover)),
//                ((TextView)(findViewById(R.id.tvPersian0))),
//                ((TextView)(findViewById(R.id.tvPersian))),
//                ((TextView)(findViewById(R.id.nothing_text))),
//                blogItem.getID());
//        asyncLoadBlogItem.execute();

        getSupportActionBar().setTitle(getString(R.string.pleaseWait));

    }
}
