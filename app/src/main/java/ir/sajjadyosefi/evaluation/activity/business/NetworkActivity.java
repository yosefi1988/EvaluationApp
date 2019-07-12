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
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import cn.refactor.kmpautotextview.ItemData;
import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.activity.evaluation.AddNetworkActivity;
import ir.sajjadyosefi.evaluation.activity.evaluation.DrillingActivity;
import ir.sajjadyosefi.evaluation.activity.evaluation.WasterWaterListActivity;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.AbfaxSelectsUsageTypeInfoDetail;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.NetworkAndBranch.WaterBranch;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.NetworkAndBranch.WaterMeter;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.NetworkAndBranch.WaterNetwork;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.UsageListItem;
import ir.sajjadyosefi.evaluation.model.business.WasterWater;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.WATER_METER;


public class NetworkActivity extends TubelessActivity {


    private static final String TAG = "sssssssssssssss";
    private int RC_SIGN_IN = 1000;


    RecyclerView                    mRecyclerViewTimeline;
    EndlessList_Adapter             adapter_Posts;
    LinearLayoutManager             mLayoutManager;

    Button ButtonSms,ButtonCall,buttonBack, battonNo, battonYes;
    TextView textViewNameFamily1,TextViewSerial,textViewDate,textViewNameFamily2,textViewMobile,TextViewCodePosti,TextViewAddress;

    Activity activity ;
    String LastFileSelected = null;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_network);
        setRootActivity((ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));

        battonYes = findViewById(R.id.battonYes);
        battonNo = findViewById(R.id.battonNo);
        buttonBack = findViewById(R.id.buttonBack);


        for (WaterNetwork waterNetworkItem :Global.CurrentTask.waterNetworks) {
            for (WaterBranch waterBranchItem : waterNetworkItem.getWaterBranches() ) {
                for (WaterMeter waterMeterItem : waterBranchItem.getWaterMeters()) {
                    waterMeterItem.setWaterNetwork(waterNetworkItem);
                    waterMeterItem.setWaterBranch(waterBranchItem);
                    waterMeters.add(waterMeterItem);
                }
            }
        }


//        for (UsageListItem usageListItem : Global.CurrentTask.getUsageList()) {
//            usageListItem.type = COUNT_REQUEST_EDITED;
//            NetworkAndBranch.add(usageListItem);
//        }
        prepareList(getRootActivity());



        ArrayList<ItemData> listSub = new ArrayList<>();
        for (TubelessObject usageItem: Global.CurrentTask.getUsageList()) {
            if (((UsageListItem)usageItem).isEdited() == true){
                if (((UsageListItem)usageItem).getWaterMainUnitQtyReq2() >= 1){

                    count = count + ((UsageListItem)usageItem).getWaterMainUnitQtyReq2()  ;
//                            for (AbfaxSelectsUsageTypeInfoDetail xItem:Global.allSelects.getUsageTypeInfoDetail()) {
//                                if (xItem.getUsageTypeId() == ((UsageListItem)usageItem).getUsageTypeIdReq()){
//
//                                    ItemData sss = new ItemData("- " + xItem.getUsageInfoDetailDesc(), xItem.getUsageTypeInfoDetailId() + "", xItem.getUsageTypeInfoDetailId() + "");
//                                    listSub.add(sss);
//
//                                }
//                            }
                }
                continue;
            }else {
                if (((UsageListItem)usageItem).getWaterMainUnitQtyReq() >= 1){
                    //کاربری درخواستی
                    //usageItem.getUsageTypeIdReq()

                    count = count + ((UsageListItem)usageItem).getWaterMainUnitQtyReq();

//                            for (AbfaxSelectsUsageTypeInfoDetail xItem:Global.allSelects.getUsageTypeInfoDetail()) {
//                                if (xItem.getUsageTypeId() == ((UsageListItem)usageItem).getUsageTypeIdReq()){
//
//                                    ItemData sss = new ItemData("- " + xItem.getUsageInfoDetailDesc(), xItem.getUsageTypeInfoDetailId() + "", xItem.getUsageTypeInfoDetailId() + "");
//                                    listSub.add(sss);
//
//                                }
//                            }
                }
            }
        }

        battonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int interedCount = 0 ;
                for (TubelessObject item : waterMeters) {
                    int a = ((WaterMeter)item).getCountWaterMeter();
                    int b = ((WaterMeter)item).getCountUnit();
                    interedCount = interedCount + (a * b);
                }
                if (count == interedCount) {
                    Intent i = new Intent(getContext(), WasterWaterListActivity.class);
                    (getActivity()).startActivity(i);
                    finish();
                }else {
                    Toast.makeText(getContext(), "تعداد در لیست بالا ؛ با تعداد تقاضا متناسب نیست , تعداد تقاضا = " + count , Toast.LENGTH_LONG).show();
                }
            }
        });

        battonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int interedCount = 0 ;
                for (TubelessObject item : waterMeters) {
                    int a = ((WaterMeter)item).getCountWaterMeter();
                    int b = ((WaterMeter)item).getCountUnit();
                    interedCount = interedCount + (a * b);
                }

                if (count == interedCount) {
                    Intent i = new Intent(getContext(), DrillingActivity.class);
                    (getActivity()).startActivity(i);
                    finish();
                }else {
                    Toast.makeText(getContext(), "تعداد در لیست بالا ؛ با تعداد تقاضا متناسب نیست , تعداد تقاضا = " + count , Toast.LENGTH_LONG).show();
                }

            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(getContext(), RequestCountActivity.class));
                finish();
            }
        });

        if (Global.CurrentTask.waterNetworks.size() == 0) {
            Intent i = new Intent(getContext(), AddNetworkActivity.class);
            (getActivity()).startActivityForResult(i, 1);
        }else {
            //only show


        }
    }


    List<TubelessObject> waterMeters = new ArrayList<>();

    private void prepareList(View rootview) {
//        if (Global.CurrentTask.waterNetworks == null){
//            Global.CurrentTask.waterNetworks = new ArrayList<>();
//            WaterNetwork emptyNetwork = new WaterNetwork();
//            emptyNetwork.setWaterBranches(new ArrayList<>());
//            WaterBranch emptyWatherBranch = new WaterBranch();
//            emptyWatherBranch.setWaterMeters(new ArrayList<>());
//            emptyNetwork.getWaterBranches().add(emptyWatherBranch);
//            Global.CurrentTask.waterNetworks.add(emptyNetwork);
//        }

        mRecyclerViewTimeline           = (RecyclerView) rootview.findViewById(R.id.recyclerView);
        mRecyclerViewTimeline.setHasFixedSize(true);
        mRecyclerViewTimeline.setItemAnimator(new DefaultItemAnimator());
        mLayoutManager = new LinearLayoutManager(getContext());
        adapter_Posts = new EndlessList_Adapter(
                getContext(),
                mLayoutManager,
                rootview,
                true,
                waterMeters);
        adapter_Posts.listType = WATER_METER;
        mRecyclerViewTimeline.setLayoutManager(mLayoutManager);
        mRecyclerViewTimeline.setAdapter(adapter_Posts);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result = data.getStringExtra("result");

                if (result != null){

                    Gson gson = new Gson();
                    WaterMeter kontor = gson.fromJson(result, WaterMeter.class);

//                    WaterMeter waterMeterItem;
//                    waterMeterItem.setWaterNetwork(waterNetworkItem);
//                    waterMeterItem.setWaterBranch(waterBranchItem);
                    waterMeters.add(kontor);
//                    Global.CurrentTask.NetworkAndBranch.add(kontor);
                    adapter_Posts.notifyDataSetChanged();


//                    for (WaterNetwork waterNetworkItem :Global.CurrentTask.waterNetworks) {
//                        for (WaterBranch waterBranchItem : waterNetworkItem.getWaterBranches() ) {
//                            for (WaterMeter waterMeterItem : waterBranchItem.getWaterMeters()) {
//                                waterMeterItem.setWaterNetwork(waterNetworkItem);
//                                waterMeterItem.setWaterBranch(waterBranchItem);
//                                waterMeters.add(waterMeterItem);
//                            }
//                        }
//                    }
                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult

}
