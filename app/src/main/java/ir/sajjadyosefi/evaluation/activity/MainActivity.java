package ir.sajjadyosefi.evaluation.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.*;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends TubelessActivity {


    private static final String TAG = MainActivity.class.getSimpleName();


    LinearLayoutManager             mLayoutManager;
    private RecyclerView            mRecyclerViewTimeline;
    private TextView                mTextViewNoting;
    List<TubelessObject> timelineItemList = new ArrayList<TubelessObject>();
    EndlessList_Adapter adapter_Posts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRootActivity((ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));
        loadTasksFromServer(getRootActivity());
    }


    private void loadTasksFromServer(View rootview) {
        mRecyclerViewTimeline           = (RecyclerView) rootview.findViewById(R.id.recyclerView);
        mRecyclerViewTimeline.setHasFixedSize(true);
        mRecyclerViewTimeline.setItemAnimator(new DefaultItemAnimator());
        mLayoutManager = new LinearLayoutManager(getContext());
        adapter_Posts = new EndlessList_Adapter(
                getContext(),
                mLayoutManager,
                rootview,
                timelineItemList,
                55);
        mRecyclerViewTimeline.setLayoutManager(mLayoutManager);
        mRecyclerViewTimeline.setAdapter(adapter_Posts);

    }


}
