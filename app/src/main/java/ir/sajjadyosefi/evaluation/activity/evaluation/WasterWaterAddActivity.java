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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import cn.refactor.kmpautotextview.ItemData;
import cn.refactor.kmpautotextview.KMPAutoComplTextView;
import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.AbfaxSelectsObject;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.OldSubscribeListItem;
import ir.sajjadyosefi.evaluation.model.business.WasterWater;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.WASTER_WATER;

public class WasterWaterAddActivity extends TubelessActivity {


    private static final String TAG = WasterWaterAddActivity.class.getSimpleName();

    public Button submit;

//    LinearLayoutManager             mLayoutManager;
//    private RecyclerView            mRecyclerViewTimeline;
//    private View                    emptyView;



    KMPAutoComplTextView KMPAutoComplTextView2,KMPAutoComplTextViewSubscribe,complTextView;
    EditText editTextCount,editTextTool;
    LinearLayout linearLayoutCount,linearLayoutGhotr,linearLayoutSubscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wastewater);
        ArrayList<ItemData> list = new ArrayList<>();

        linearLayoutSubscribe = findViewById(R.id.linearLayoutSubscribe);
        linearLayoutGhotr = findViewById(R.id.linearLayoutGhotr);
        linearLayoutCount = findViewById(R.id.linearLayoutCount);
        complTextView = (KMPAutoComplTextView) findViewById(R.id.tvAutoCompl);
        editTextCount =  findViewById(R.id.editTextCount);
        editTextTool =  findViewById(R.id.editTextTool);


//        setRootActivity((ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (complTextView.getText().toString().equals(list.get(0).getText().toString())) {
                    //دارد
                    WasterWater aaaaaa2 = new WasterWater();
                    ((WasterWater) aaaaaa2).setLength(Integer.parseInt(editTextTool.getText().toString()));
                    ((WasterWater) aaaaaa2).setSiphon(true);
                    ((WasterWater) aaaaaa2).setSubscribeCode(KMPAutoComplTextViewSubscribe.getText().toString());
                    ((WasterWater) aaaaaa2).setType(WASTER_WATER);


                    Gson gson = new Gson();
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("result",gson.toJson(aaaaaa2));
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();


                }else {
                    //ندارد


                    WasterWater aaaaaa = new WasterWater();
                    ((WasterWater) aaaaaa).setCount(Integer.parseInt(editTextCount.getText().toString()));
                    ((WasterWater) aaaaaa).setLength(Integer.parseInt(editTextTool.getText().toString()));
                    ((WasterWater) aaaaaa).setSiphon(false);

                    for (ItemData item : list) {
                        if (item.getText().equals(KMPAutoComplTextView2.getText().toString().substring(2,KMPAutoComplTextView2.getText().length()))){
                            //((WasterWater) aaaaaa).setDiameter(Integer.parseInt(item.getMeta()));
                            ((WasterWater) aaaaaa).setDiameter(1);
                        }
                    }
                    ((WasterWater) aaaaaa).setType(WASTER_WATER);

                    Gson gson = new Gson();
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("result",gson.toJson(aaaaaa));
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();

                }




            }
        });



        //type دارد/ ندارد
        if (Global.CurrentTask == null ){

        }else {

            ItemData sss = new ItemData("- دارد",  "1","");
            list.add(sss);

            ItemData sss1 = new ItemData("- ندارد",  "2","");
            list.add(sss1);

            complTextView.setDatas(list);

            complTextView.setOnPopupItemClickListener(new KMPAutoComplTextView.OnPopupItemClickListener() {
                @Override
                public void onPopupItemClick(CharSequence charSequence) {
                    Toast.makeText(getBaseContext(), charSequence.toString(), Toast.LENGTH_SHORT).show();

                    if (charSequence.equals(list.get(0).getText())){
                        //دارد

                        linearLayoutSubscribe.setVisibility(View.VISIBLE);
                        linearLayoutGhotr.setVisibility(View.GONE);
                        linearLayoutCount.setVisibility(View.GONE);

                    }else if (charSequence.equals(list.get(1).getText())){
                        //ندارد

                        linearLayoutSubscribe.setVisibility(View.GONE);
                        linearLayoutGhotr.setVisibility(View.VISIBLE);
                        linearLayoutCount.setVisibility(View.VISIBLE);
                    }else {

                    }

                }
            });
        }



        //type Subscribe
        KMPAutoComplTextViewSubscribe = (KMPAutoComplTextView) findViewById(R.id.KMPAutoComplTextViewSubscribe);
        ArrayList<ItemData> listSubscribe = new ArrayList<>();

        for (OldSubscribeListItem item: Global.CurrentTask.getOldSubscribeList()) {
            ItemData sss = new ItemData("- " + item.getSubscriberCode() + " - " + item.getTblRequestSubscriberId()  , item.getTblRequestSubscriberId() + "", item.getType() + "");
            listSubscribe.add(sss);
        }
        KMPAutoComplTextViewSubscribe.setDatas(listSubscribe);
        KMPAutoComplTextViewSubscribe.setOnPopupItemClickListener(new KMPAutoComplTextView.OnPopupItemClickListener() {
            @Override
            public void onPopupItemClick(CharSequence charSequence) {
                Toast.makeText(getBaseContext(), charSequence.toString(), Toast.LENGTH_SHORT).show();
            }
        });



        //type 2
        KMPAutoComplTextView2 = (KMPAutoComplTextView) findViewById(R.id.KMPAutoComplTextView2);
        ArrayList<ItemData> list2 = new ArrayList<>();

        for (AbfaxSelectsObject item: Global.allSelects.getObject()) {
            if (item.getType() == 2) {
                ItemData sss = new ItemData("- " + item.getTextValue(), item.getKeyValue() + "", item.getType() + "");
                list2.add(sss);
            }
        }
        KMPAutoComplTextView2.setDatas(list2);
        KMPAutoComplTextView2.setOnPopupItemClickListener(new KMPAutoComplTextView.OnPopupItemClickListener() {
            @Override
            public void onPopupItemClick(CharSequence charSequence) {
                Toast.makeText(getBaseContext(), charSequence.toString(), Toast.LENGTH_SHORT).show();
            }
        });


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
