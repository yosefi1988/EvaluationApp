package ir.sajjadyosefi.evaluation.activity.business;

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

import java.util.ArrayList;
import java.util.List;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.activity.evaluation.AddNetworkActivity;
import ir.sajjadyosefi.evaluation.activity.evaluation.DrillingActivity;
import ir.sajjadyosefi.evaluation.activity.evaluation.WasterWaterListActivity;
import ir.sajjadyosefi.evaluation.activity.evaluation.DrillingListActivity;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.COUNT_REQUEST_EDITED;
import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.NETWORK;
import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.SUBSCRIPTIONS;


public class NetworkActivity extends TubelessActivity {


    private static final String TAG = "sssssssssssssss";
    private int RC_SIGN_IN = 1000;


    RecyclerView                    mRecyclerViewTimeline;
    EndlessList_Adapter             adapter_Posts;
    LinearLayoutManager             mLayoutManager;
    List<TubelessObject>            taskItemList = new ArrayList<TubelessObject>();
    List<TubelessObject>            requestCountItemList = new ArrayList<TubelessObject>();


    Button ButtonSms,ButtonCall,buttonBack, battonNo, battonYes;
    TextView textViewNameFamily1,TextViewSerial,textViewDate,textViewNameFamily2,textViewMobile,TextViewCodePosti,TextViewAddress;

    Activity activity ;
    String LastFileSelected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_network);
        setRootActivity((ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));

        battonYes = findViewById(R.id.battonYes);
        battonNo = findViewById(R.id.battonNo);
        buttonBack = findViewById(R.id.buttonBack);




//        for (UsageListItem usageListItem : Global.CurrentTask.getUsageList()) {
//            usageListItem.type = COUNT_REQUEST_EDITED;
//            requestCountItemList.add(usageListItem);
//        }
        prepareList(getRootActivity());





        battonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), WasterWaterListActivity.class);
                (getActivity()).startActivity(i);
                finish();
            }
        });

        battonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getContext(), DrillingActivity.class);
                (getActivity()).startActivity(i);
                finish();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(getContext(), RequestCountActivity.class));
                finish();
            }
        });

        if (true){
            Intent i = new Intent(getContext(), AddNetworkActivity.class);
            (getActivity()).startActivityForResult(i, 1);
        }else {
            //only show


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
        adapter_Posts.listType = NETWORK;
        mRecyclerViewTimeline.setLayoutManager(mLayoutManager);
        mRecyclerViewTimeline.setAdapter(adapter_Posts);

    }

}
