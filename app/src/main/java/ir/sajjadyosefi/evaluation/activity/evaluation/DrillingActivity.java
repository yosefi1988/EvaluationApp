package ir.sajjadyosefi.evaluation.activity.evaluation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.activity.business.NetworkActivity;
import ir.sajjadyosefi.evaluation.model.main.TimelineItem;

/**
 * Created by sajjad on 2/11/2018.
 */

public class DrillingActivity extends AppCompatActivity {

    Context mContext = null;
    Button button1 , button2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drilling);
        mContext = this;


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, DrillingListActivity.class);
                (mContext).startActivity(i);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext,  NetworkActivity.class);
                (mContext).startActivity(i);
            }
        });
    }
}
