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

import java.util.ArrayList;
import java.util.List;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.AbfaxSelectsObject;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.AbfaxSelectsObjectSelectable;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.TODO;


public class ToDoListActivity extends TubelessActivity {


    private static final String TAG = "sssssssssssssss";
    private int RC_SIGN_IN = 1000;


    RecyclerView                    mRecyclerViewTimeline;
    EndlessList_Adapter             adapter_Posts;
    LinearLayoutManager             mLayoutManager;
    List<TubelessObject>            requestCountItemList = new ArrayList<TubelessObject>();


    Button ButtonSms,ButtonCall,buttonk, buttonBack, buttonNext;
    TextView textViewNameFamily1,TextViewSerial,textViewDate,textViewNameFamily2,textViewMobile,TextViewCodePosti,TextViewAddress;

    Activity activity ;
    String LastFileSelected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_to_do);
        setRootActivity((ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));

        buttonNext = findViewById(R.id.buttonNext);
        buttonBack = findViewById(R.id.buttonBack);





        //type 4
        if (Global.allSelects != null) {
            for (AbfaxSelectsObject item : Global.allSelects.getObject()) {
                if (item.getType() == 6) {
                    AbfaxSelectsObjectSelectable sss = new AbfaxSelectsObjectSelectable("- " + item.getTextValue(), item.getKeyValue(),false);
                    sss.setType(TODO);
                    requestCountItemList.add(sss);
                }
            }


            if (Global.CurrentTask.todoList != null) {
                for (AbfaxSelectsObjectSelectable item : Global.CurrentTask.todoList) {
                    if (item.isSelected()) {
                        for (TubelessObject item2 : requestCountItemList) {
                            if (item.getKeyValue() == ((AbfaxSelectsObjectSelectable) item2).getKeyValue()) {
                                ((AbfaxSelectsObjectSelectable) item2).setSelected(true);
                            }
                        }
                    }
                }
            }



            prepareList(getRootActivity());
        }





        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Global.CurrentTask.todoList.clear();
                for (TubelessObject item2 : requestCountItemList) {
                    if (((AbfaxSelectsObjectSelectable)item2).isSelected()){
                        Global.CurrentTask.todoList.add((AbfaxSelectsObjectSelectable)item2);
                    }
                }


                Intent i = new Intent(getContext(),SignatureActivity.class);
                (getActivity()).startActivity(i);
                finish();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent i = new Intent(getContext(), WasterWaterListActivity.class);
//                (getActivity()).startActivity(i);

                getActivity().startActivity(new Intent(getContext(), DrillingActivity.class));


                finish();
            }
        });

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
                true,
                requestCountItemList);
        adapter_Posts.listType = TODO;
        mRecyclerViewTimeline.setLayoutManager(mLayoutManager);
        mRecyclerViewTimeline.setAdapter(adapter_Posts);

    }

}
