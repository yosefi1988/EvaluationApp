package ir.sajjadyosefi.evaluation.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.*;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.model.business.Task;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

import java.util.ArrayList;
import java.util.List;

import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.TASKS;

public class MainActivity extends TubelessActivity {


    private static final String TAG = MainActivity.class.getSimpleName();

    LinearLayoutManager             mLayoutManager;
    private RecyclerView            mRecyclerViewTimeline;
    private View                    emptyView;

    EndlessList_Adapter adapter_Posts;
    List<TubelessObject> taskItemList = new ArrayList<TubelessObject>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRootActivity((ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));


//        TubelessObject aaaaaa = new Task();
//        ((Task) aaaaaa).setCount(5);
//        ((Task) aaaaaa).setLength(10);
//        ((Task) aaaaaa).setSiphon(true);
//        ((Task) aaaaaa).setDiameter(10);
//        ((Task) aaaaaa).setType(TASKS);
//        taskItemList.add(aaaaaa);
//
//        TubelessObject aaaaaa2 = new Task();
//        ((Task) aaaaaa2).setLength(100);
//        ((Task) aaaaaa2).setSiphon(false);
//        ((Task) aaaaaa2).setSubscribeCode("54514");
//        ((Task) aaaaaa2).setType(TASKS);
//        taskItemList.add(aaaaaa2);

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
                taskItemList,
                TASKS);
        adapter_Posts.listType = TASKS;
        mRecyclerViewTimeline.setLayoutManager(mLayoutManager);
        mRecyclerViewTimeline.setAdapter(adapter_Posts);
    }


}
