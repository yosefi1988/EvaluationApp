package ir.sajjadyosefi.evaluation.activity.evaluation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import cn.refactor.kmpautotextview.ItemData;
import cn.refactor.kmpautotextview.KMPAutoComplTextView;
import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.AbfaxSelectsObject;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.OldSubscribeListItem;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.UsageListItem;
import ir.sajjadyosefi.evaluation.model.business.WasterWater;

import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.WASTER_WATER;

public class AddNetworkActivity extends TubelessActivity {


    KMPAutoComplTextView KMPAutoComplTextView10 , KMPAutoComplTextView4 , KMPAutoComplTextView8 , KMPAutoComplTextView9 , KMPAutoComplTextView3, KMPAutoComplTextView1,KMPAutoComplTextViewSubscribe;
    Button buttonSave , buttonCancel ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_network);
        setRootActivity((ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));
        buttonSave = findViewById(R.id.buttonSave);
        buttonCancel = findViewById(R.id.buttonCancel);


        if (Global.CurrentTask == null ){

        }else {

            //type 10
            KMPAutoComplTextView10 = (KMPAutoComplTextView) findViewById(R.id.KMPAutoComplTextView10);
            ArrayList<ItemData> list10 = new ArrayList<>();
            for (AbfaxSelectsObject item: Global.allSelects.getObject()) {
                if (item.getType() == 10) {
                    ItemData sss = new ItemData("- " + item.getTextValue(), item.getKeyValue() + "", item.getType() + "");
                    list10.add(sss);
                }
            }
            KMPAutoComplTextView10.setDatas(list10);
            KMPAutoComplTextView10.setOnPopupItemClickListener(new KMPAutoComplTextView.OnPopupItemClickListener() {
                @Override
                public void onPopupItemClick(CharSequence charSequence) {
                    Toast.makeText(getBaseContext(), charSequence.toString(), Toast.LENGTH_SHORT).show();
                }
            });

            //type 4
            KMPAutoComplTextView4 = (KMPAutoComplTextView) findViewById(R.id.KMPAutoComplTextView4);
            ArrayList<ItemData> list4 = new ArrayList<>();

            for (AbfaxSelectsObject item: Global.allSelects.getObject()) {
                if (item.getType() == 4) {
                    ItemData sss = new ItemData("- " + item.getTextValue(), item.getKeyValue() + "", item.getType() + "");
                    list4.add(sss);
                }
            }
            KMPAutoComplTextView4.setDatas(list4);
            KMPAutoComplTextView4.setOnPopupItemClickListener(new KMPAutoComplTextView.OnPopupItemClickListener() {
                @Override
                public void onPopupItemClick(CharSequence charSequence) {
                    Toast.makeText(getBaseContext(), charSequence.toString(), Toast.LENGTH_SHORT).show();
                }
            });


            //type 8
            KMPAutoComplTextView8 = (KMPAutoComplTextView) findViewById(R.id.KMPAutoComplTextView8);
            ArrayList<ItemData> list8 = new ArrayList<>();

            for (AbfaxSelectsObject item: Global.allSelects.getObject()) {
                if (item.getType() == 8) {
                    ItemData sss = new ItemData("- " + item.getTextValue(), item.getKeyValue() + "", item.getType() + "");
                    list8.add(sss);
                }
            }
            KMPAutoComplTextView8.setDatas(list8);
            KMPAutoComplTextView8.setOnPopupItemClickListener(new KMPAutoComplTextView.OnPopupItemClickListener() {
                @Override
                public void onPopupItemClick(CharSequence charSequence) {
                    Toast.makeText(getBaseContext(), charSequence.toString(), Toast.LENGTH_SHORT).show();
                }
            });

            //type 2
            KMPAutoComplTextView9 = (KMPAutoComplTextView) findViewById(R.id.KMPAutoComplTextView9);
            ArrayList<ItemData> list2 = new ArrayList<>();

            for (AbfaxSelectsObject item: Global.allSelects.getObject()) {
                if (item.getType() == 9) {
                    ItemData sss = new ItemData("- " + item.getTextValue(), item.getKeyValue() + "", item.getType() + "");
                    list2.add(sss);
                }
            }
            KMPAutoComplTextView9.setDatas(list2);
            KMPAutoComplTextView9.setOnPopupItemClickListener(new KMPAutoComplTextView.OnPopupItemClickListener() {
                @Override
                public void onPopupItemClick(CharSequence charSequence) {
                    Toast.makeText(getBaseContext(), charSequence.toString(), Toast.LENGTH_SHORT).show();
                }
            });

            //type 3
            KMPAutoComplTextView3 = (KMPAutoComplTextView) findViewById(R.id.KMPAutoComplTextView3);
            ArrayList<ItemData> list3 = new ArrayList<>();

            for (AbfaxSelectsObject item: Global.allSelects.getObject()) {
                if (item.getType() == 3) {
                    ItemData sss = new ItemData("- " + item.getTextValue(), item.getKeyValue() + "", item.getType() + "");
                    list3.add(sss);
                }
            }
            KMPAutoComplTextView3.setDatas(list3);
            KMPAutoComplTextView3.setOnPopupItemClickListener(new KMPAutoComplTextView.OnPopupItemClickListener() {
                @Override
                public void onPopupItemClick(CharSequence charSequence) {
                    Toast.makeText(getBaseContext(), charSequence.toString(), Toast.LENGTH_SHORT).show();
                }
            });


            //type 1
            KMPAutoComplTextView1 = (KMPAutoComplTextView) findViewById(R.id.KMPAutoComplTextView1);
            ArrayList<ItemData> list1 = new ArrayList<>();

            for (AbfaxSelectsObject item: Global.allSelects.getObject()) {
                if (item.getType() == 1) {
                    ItemData sss = new ItemData("- " + item.getTextValue(), item.getKeyValue() + "", item.getType() + "");
                    list1.add(sss);
                }
            }
            KMPAutoComplTextView1.setDatas(list1);
            KMPAutoComplTextView1.setOnPopupItemClickListener(new KMPAutoComplTextView.OnPopupItemClickListener() {
                @Override
                public void onPopupItemClick(CharSequence charSequence) {
                    Toast.makeText(getBaseContext(), charSequence.toString(), Toast.LENGTH_SHORT).show();
                }
            });

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



        }


        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WasterWater aaaaaa = new WasterWater();
                ((WasterWater) aaaaaa).setCount(5);
                ((WasterWater) aaaaaa).setLength(10);
                ((WasterWater) aaaaaa).setSiphon(true);
                ((WasterWater) aaaaaa).setDiameter(10);
                ((WasterWater) aaaaaa).setType(WASTER_WATER);

                Gson gson = new Gson();
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",gson.toJson(aaaaaa));
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result = data.getStringExtra("result");

                if (result != null){

                    Gson gson = new Gson();
                    WasterWater wasterWaterItem = gson.fromJson(result,WasterWater.class);
//                    WasterWaterList.add(wasterWaterItem);
//                    adapter_Posts.notifyItemInserted(WasterWaterList.size());
                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_CANCELED, returnIntent);
        finish();
    }
}
