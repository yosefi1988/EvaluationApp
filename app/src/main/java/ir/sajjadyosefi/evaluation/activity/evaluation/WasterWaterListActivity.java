package ir.sajjadyosefi.evaluation.activity.evaluation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.solver.widgets.Rectangle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.tuyenmonkey.mkloader.model.Circle;

import java.util.ArrayList;
import java.util.List;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.model.business.WasterWater;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.WASTER_WATER;

public class WasterWaterListActivity extends TubelessActivity {


    private static final String TAG = WasterWaterListActivity.class.getSimpleName();


    LinearLayoutManager             mLayoutManager;
    private RecyclerView            mRecyclerViewTimeline;
    private View                    emptyView;

    List<TubelessObject> WasterWaterList = new ArrayList<TubelessObject>();
    EndlessList_Adapter adapter_Posts;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result = data.getStringExtra("result");

                if (result != null){


                    Gson gson = new Gson();
                    WasterWater wasterWaterItem = gson.fromJson(result,WasterWater.class);
                    WasterWaterList.add(wasterWaterItem);
                    adapter_Posts.notifyItemInserted(WasterWaterList.size());
                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wastewater_list);
        setRootActivity((ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));

        TubelessObject aaaaaa = new WasterWater();
        ((WasterWater) aaaaaa).setCount(5);
        ((WasterWater) aaaaaa).setLength(10);
        ((WasterWater) aaaaaa).setSiphon(true);
        ((WasterWater) aaaaaa).setDiameter(10);
        ((WasterWater) aaaaaa).setType(WASTER_WATER);
        WasterWaterList.add(aaaaaa);

        TubelessObject aaaaaa2 = new WasterWater();
        ((WasterWater) aaaaaa2).setLength(100);
        ((WasterWater) aaaaaa2).setSiphon(false);
        ((WasterWater) aaaaaa2).setSubscribeCode("54514");
        ((WasterWater) aaaaaa2).setType(WASTER_WATER);
        WasterWaterList.add(aaaaaa2);

        prepareList(getRootActivity());


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
                WasterWaterList);
        adapter_Posts.listType = WASTER_WATER;
        mRecyclerViewTimeline.setLayoutManager(mLayoutManager);
        mRecyclerViewTimeline.setAdapter(adapter_Posts);

    }


}