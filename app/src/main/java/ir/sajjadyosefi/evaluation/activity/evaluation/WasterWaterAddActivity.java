package ir.sajjadyosefi.evaluation.activity.evaluation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.model.business.WasterWater;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.WASTER_WATER;

public class WasterWaterAddActivity extends TubelessActivity {


    private static final String TAG = WasterWaterAddActivity.class.getSimpleName();

//    public Button submit;
//
//    LinearLayoutManager             mLayoutManager;
//    private RecyclerView            mRecyclerViewTimeline;
//    private View                    emptyView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wastewater);
//        setRootActivity((ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));
//        submit = (Button) findViewById(R.id.submit);
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                WasterWater aaaaaa = new WasterWater();
////                ((WasterWater) aaaaaa).setCount(5);
////                ((WasterWater) aaaaaa).setLength(10);
////                ((WasterWater) aaaaaa).setSiphon(true);
////                ((WasterWater) aaaaaa).setDiameter(10);
////                ((WasterWater) aaaaaa).setType(WASTER_WATER);
////
////                WasterWater aaaaaa2 = new WasterWater();
////                ((WasterWater) aaaaaa2).setLength(100);
////                ((WasterWater) aaaaaa2).setSiphon(false);
////                ((WasterWater) aaaaaa2).setSubscribeCode("54514");
////                ((WasterWater) aaaaaa2).setType(WASTER_WATER);
////
////
////                Gson gson = new Gson();
////                Intent returnIntent = new Intent();
////                returnIntent.putExtra("result",gson.toJson(aaaaaa));
////                setResult(Activity.RESULT_OK,returnIntent);
////                finish();
//            }
//        });




    }


//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//
//        Intent returnIntent = new Intent();
//        setResult(Activity.RESULT_CANCELED, returnIntent);
//        finish();
//    }
}
