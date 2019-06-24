package ir.sajjadyosefi.evaluation.activity.evaluation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.COUNT_REQUEST_EDITED;


public class drillingListActivity extends TubelessActivity {


    private static final String TAG = "sssssssssssssss";
    private int RC_SIGN_IN = 1000;


    RecyclerView                    mRecyclerViewTimeline;
    EndlessList_Adapter             adapter_Posts;
    LinearLayoutManager             mLayoutManager;
    List<TubelessObject>            taskItemList = new ArrayList<TubelessObject>();
    List<TubelessObject>            requestCountItemList = new ArrayList<TubelessObject>();


    Button ButtonSms,ButtonCall,buttonk, buttonBack, buttonNext;
    TextView textViewNameFamily1,TextViewSerial,textViewDate,textViewNameFamily2,textViewMobile,TextViewCodePosti,TextViewAddress;

    Activity activity ;
    String LastFileSelected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_drilling_list);
        setRootActivity((ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));

        buttonNext = findViewById(R.id.buttonNext);
        buttonBack = findViewById(R.id.buttonBack);




//        for (UsageListItem usageListItem : Global.CurrentTask.getUsageList()) {
//            usageListItem.type = COUNT_REQUEST_EDITED;
//            requestCountItemList.add(usageListItem);
//        }
        prepareList(getRootActivity());





        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent i = new Intent(getContext(),  .class);
//                (getActivity()).startActivity(i);

                Toast.makeText(getContext(),"to do activity" ,Toast.LENGTH_LONG).show();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getContext(), WasterWaterListActivity.class);
                (getActivity()).startActivity(i);
            }
        });

        if (true){
            Intent i = new Intent(getContext(), AddNetworkActivity.class);
            (getActivity()).startActivityForResult(i, 1);
        }
    }


    private void prepareList(View rootview) {
        mRecyclerViewTimeline           = (RecyclerView) rootview.findViewById(R.id.recyclerView);
        mRecyclerViewTimeline.setHasFixedSize(true);
        mRecyclerViewTimeline.setItemAnimator(new DefaultItemAnimator());
        mLayoutManager = new LinearLayoutManager(getContext());
        adapter_Posts = new EndlessList_Adapter(
                getContext(),
                mLayoutManager,
                rootview,
                requestCountItemList);
        adapter_Posts.listType = COUNT_REQUEST_EDITED;
        mRecyclerViewTimeline.setLayoutManager(mLayoutManager);
        mRecyclerViewTimeline.setAdapter(adapter_Posts);

    }

}
