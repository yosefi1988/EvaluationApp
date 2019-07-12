package ir.sajjadyosefi.evaluation.activity.evaluation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import cn.refactor.kmpautotextview.ItemData;
import cn.refactor.kmpautotextview.KMPAutoComplTextView;
import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.activity.business.NetworkActivity;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.AbfaxSelectsObject;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.AbfaxSelectsUsageTypeInfoDetail;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.NetworkAndBranch.WaterBranch;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.NetworkAndBranch.WaterMeter;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.NetworkAndBranch.OldSubscribe;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.NetworkAndBranch.WaterNetwork;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.UsageListItem;
import ir.sajjadyosefi.evaluation.model.business.WasterWater;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.WATER_METER;

public class AddNetworkActivity extends TubelessActivity {


    KMPAutoComplTextView KMPAutoComplTextViewSubUsage, KMPAutoComplTextView10 , KMPAutoComplTextView4 , KMPAutoComplTextView8 , KMPAutoComplTextView9 , KMPAutoComplTextView3, KMPAutoComplTextView1,KMPAutoComplTextViewSubscribe;
    KMPAutoComplTextView KMPAutoComplTextViewnetwork , KMPAutoComplTextViewBranch;
    Button buttonSave , buttonCancel ;
    CheckBox checkBoxCleanOldLine;

    Button buttonNetworkReg , buttonNewNetwork;
    Button buttonBranchReg , buttonNewBranch;

    LinearLayout linearLayoutSubscribe ,linearLayoutNewNetwork,linearLayoutNetwork;
    LinearLayout linearLayoutBranch ,linearLayoutNewBranch;
    EditText editTextTool ,editTextCount,editTextCount2;

    ArrayList<ItemData> list10;


    WaterNetwork selectedWaterNetwork = new WaterNetwork();
    WaterBranch selectedWaterBranch = new WaterBranch();
    WaterMeter newWaterMeter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_network);
        setRootActivity((ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));
        buttonSave = findViewById(R.id.buttonSave);
        buttonCancel = findViewById(R.id.buttonCancel);
        editTextTool = findViewById(R.id.editTextTool);
        editTextCount = findViewById(R.id.editTextCount);
        editTextCount2 = findViewById(R.id.editTextCount2);
        buttonNetworkReg = findViewById(R.id.buttonNetworkReg);
        checkBoxCleanOldLine = findViewById(R.id.checkBoxCleanOldLine);
        buttonBranchReg = findViewById(R.id.buttonBranchReg);
        buttonNewBranch = findViewById(R.id.buttonNewBranch);
        buttonNewNetwork = findViewById(R.id.buttonNewNetwork);
        linearLayoutNetwork = findViewById(R.id.linearLayoutNetwork);
        linearLayoutNewNetwork = findViewById(R.id.linearLayoutNewNetwork);
        linearLayoutBranch = findViewById(R.id.linearLayoutBranch);
        linearLayoutNewBranch = findViewById(R.id.linearLayoutNewBranch);
        KMPAutoComplTextViewBranch = (KMPAutoComplTextView) findViewById(R.id.KMPAutoComplTextViewBranch);

        buttonNewNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                linearLayoutNewNetwork.setVisibility(View.VISIBLE);
                linearLayoutNetwork.setVisibility(View.GONE);
            }
        });

        buttonNewBranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                linearLayoutNewBranch.setVisibility(View.VISIBLE);
                linearLayoutBranch.setVisibility(View.GONE);
            }
        });

        buttonBranchReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean valid = true;
                AbfaxSelectsObject item9 = null;
                AbfaxSelectsObject item3 = null;

                if (KMPAutoComplTextView9.getText().length() == 0){
                    valid = false;
                }else {
                    boolean xv = false;
                    for (AbfaxSelectsObject item : Global.allSelects.getObject()) {
                        if (item.getTextValue().equals(KMPAutoComplTextView9.getText().subSequence(2,KMPAutoComplTextView9.getText().length()).toString())){
                            xv = true;
                            item9 = item;
                            break;
                        }
                    }
                    if (xv == false) {
                        valid = xv;
                    }
                }

                if (KMPAutoComplTextView3.getText().length() == 0){
                    valid = false;
                }else {
                    boolean xv = false;
                    for (AbfaxSelectsObject item : Global.allSelects.getObject()) {
                        if (item.getTextValue().equals(KMPAutoComplTextView3.getText().subSequence(2,KMPAutoComplTextView3.getText().length()).toString())){
                            xv = true;
                            item3 = item;
                            break;
                        }
                    }
                    if (xv == false) {
                        valid = xv;
                    }
                }

                if (KMPAutoComplTextViewnetwork.getText().length() == 0){
                    valid = false;
                }else {
                    boolean xv = false;
                    for (WaterNetwork item : Global.listNetwork) {
                        if (item.getTitle().equals(KMPAutoComplTextViewnetwork.getText().toString())){
                            xv = true;
                            break;
                        }
                    }
                    if (xv == false) {
                        valid = xv;
                    }
                }


                if (editTextTool.getText().toString().length() == 0) {
                    valid = false;
                }

                if (valid) {

//                    WaterNetwork itemNetwork = null;
//                    for (WaterNetwork item : Global.listNetwork) {
//                        if (item.getTitle().equals(KMPAutoComplTextViewnetwork.getText().toString())){
//                            itemNetwork = item;
//                            break;
//                        }
//                    }

                    WaterBranch waterBranch = new WaterBranch();
                    waterBranch.setTitle("- انشعاب شماره " + (Global.listBranchs.size() + 1));
                    waterBranch.setId(Global.listBranchs.size() + 1);
                    waterBranch.setWaterNetwork(selectedWaterNetwork);
                    waterBranch.setDiameterWaterPipeBranch(item3);
                    waterBranch.setWaterPipeBranchStatus(item9);
                    selectedWaterBranch = waterBranch;
                    Global.listBranchs.add(waterBranch);

                    KMPAutoComplTextView9.setText("");
                    KMPAutoComplTextView3.setText("");
                    editTextTool.setText("");

                    linearLayoutBranch.setVisibility(View.VISIBLE);
                    linearLayoutNewBranch.setVisibility(View.GONE);


                    if (Global.CurrentTask == null ){

                    }else {
                        List<ItemData> tmpListNetwork = new ArrayList<>();
                        for (WaterBranch waterBranchx : Global.listBranchs) {
                            ItemData newItem = new ItemData(waterBranchx.getTitle(),waterBranchx.getId() + "");
                            tmpListNetwork.add(newItem);
                        }
                        KMPAutoComplTextViewBranch.setDatas(tmpListNetwork);
                        KMPAutoComplTextViewBranch.setOnPopupItemClickListener(new KMPAutoComplTextView.OnPopupItemClickListener() {
                            @Override
                            public void onPopupItemClick(ItemData itemData) {
                                Toast.makeText(getBaseContext(), itemData.getText(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }else {
                    Toast.makeText(getContext(),"مقادیر انشعاب را به درستی وارد نکرده اید",Toast.LENGTH_LONG).show();
                }



            }
        });

        buttonNetworkReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean valid = true;
                AbfaxSelectsObject item4 = null;
                AbfaxSelectsObject item8 = null;

                if (KMPAutoComplTextView4.getText().length() == 0){
                    valid = false;
                }else {
                    boolean xv = false;
                    for (AbfaxSelectsObject item : Global.allSelects.getObject()) {
                        if (item.getTextValue().equals(KMPAutoComplTextView4.getText().subSequence(2,KMPAutoComplTextView4.getText().length()).toString())){
                            xv = true;
                            item4 = item;
                            break;
                        }
                    }
                    if (xv == false) {
                        valid = xv;
                    }
                }

                if (KMPAutoComplTextView8.getText().length() == 0){
                    valid = false;
                }else {
                    boolean xv = false;
                    for (AbfaxSelectsObject item : Global.allSelects.getObject()) {
                        if (item.getTextValue().equals(KMPAutoComplTextView8.getText().subSequence(2,KMPAutoComplTextView8.getText().length()).toString())){
                            xv = true;
                            item8 = item;
                            break;
                        }
                    }
                    if (xv == false) {
                        valid = xv;
                    }
                }

                if (valid) {
                    WaterNetwork waterNetwork = new WaterNetwork();

                    waterNetwork.setTitle("- شبکه شماره " + (Global.listNetwork.size() + 1) + "");
                    waterNetwork.setWaterPipeNetworkMaterial(item8);
                    waterNetwork.setDiameterWaterPipeNetwork(item4);
                    waterNetwork.setId(Global.listNetwork.size() + 1);

                    selectedWaterNetwork = waterNetwork ;
                    Global.listNetwork.add(waterNetwork);

                    KMPAutoComplTextView4.setText("");
                    KMPAutoComplTextView8.setText("");

                    linearLayoutNewNetwork.setVisibility(View.GONE);
                    linearLayoutNetwork.setVisibility(View.VISIBLE);
                    fillNetwork();


                }else {
                    Toast.makeText(getContext(),"مقادیر شبکه را به درستی وارد نکرده اید",Toast.LENGTH_LONG).show();
                }
            }
        });


        if (Global.CurrentTask == null ){

        }else {

            //type 10
            KMPAutoComplTextView10 = (KMPAutoComplTextView) findViewById(R.id.KMPAutoComplTextView10);
            linearLayoutSubscribe = (LinearLayout) findViewById(R.id.linearLayoutSubscribe);
            list10 = new ArrayList<>();
            for (AbfaxSelectsObject item: Global.allSelects.getObject()) {
                if (item.getType() == 10) {
                    ItemData sss = new ItemData("- " + item.getTextValue(), item.getKeyValue() + "", item.getType() + "");
                    list10.add(sss);
                }
            }
            KMPAutoComplTextView10.setDatas(list10);
            KMPAutoComplTextView10.setOnPopupItemClickListener(new KMPAutoComplTextView.OnPopupItemClickListener() {
                @Override
                public void onPopupItemClick(ItemData itemData) {
                    //
                    for (ItemData item : list10) {
                        if (item.getText().equals(itemData.getText()))
                            if (item.getMeta().equals("0")){
                                linearLayoutSubscribe.setVisibility(View.VISIBLE);
                            }else {
                                linearLayoutSubscribe.setVisibility(View.GONE);
                            }
                    }


                    Toast.makeText(getBaseContext(), itemData.getText(), Toast.LENGTH_SHORT).show();
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
                public void onPopupItemClick(ItemData itemData) {
                    Toast.makeText(getBaseContext(), itemData.getText(), Toast.LENGTH_SHORT).show();
                }
            });

            //type subUsage
            KMPAutoComplTextViewSubUsage = (KMPAutoComplTextView) findViewById(R.id.KMPAutoComplTextViewSubUsage);
            ArrayList<ItemData> listSub = new ArrayList<>();
            for (TubelessObject usageItem: Global.CurrentTask.getUsageList()) {
                if (((UsageListItem)usageItem).isEdited() == true){
                    if (((UsageListItem)usageItem).getWaterMainUnitQtyReq2() >= 1){
                        for (AbfaxSelectsUsageTypeInfoDetail xItem:Global.allSelects.getUsageTypeInfoDetail()) {
                            if (xItem.getUsageTypeId() == ((UsageListItem)usageItem).getUsageTypeIdReq()){

                                ItemData sss = new ItemData("- " + xItem.getUsageInfoDetailDesc(), xItem.getUsageTypeInfoDetailId() + "", xItem.getUsageTypeInfoDetailId() + "");
                                listSub.add(sss);

                            }
                        }
                    }
                    continue;
                }else {
                    if (((UsageListItem)usageItem).getWaterMainUnitQtyReq() >= 1){
                        //کاربری درخواستی
                        //usageItem.getUsageTypeIdReq()
                        for (AbfaxSelectsUsageTypeInfoDetail xItem:Global.allSelects.getUsageTypeInfoDetail()) {
                            if (xItem.getUsageTypeId() == ((UsageListItem)usageItem).getUsageTypeIdReq()){

                                ItemData sss = new ItemData("- " + xItem.getUsageInfoDetailDesc(), xItem.getUsageTypeInfoDetailId() + "", xItem.getUsageTypeInfoDetailId() + "");
                                listSub.add(sss);

                            }
                        }
                    }
                }
            }
            KMPAutoComplTextViewSubUsage.setDatas(listSub);
            KMPAutoComplTextViewSubUsage.setOnPopupItemClickListener(new KMPAutoComplTextView.OnPopupItemClickListener() {
                @Override
                public void onPopupItemClick(ItemData itemData) {
                    Toast.makeText(getBaseContext(), itemData.getText(), Toast.LENGTH_SHORT).show();
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
                public void onPopupItemClick(ItemData itemData) {
                    Toast.makeText(getBaseContext(), itemData.getText(), Toast.LENGTH_SHORT).show();
                }
            });

            //type 9
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
                public void onPopupItemClick(ItemData itemData) {
                    Toast.makeText(getBaseContext(), itemData.getText(), Toast.LENGTH_SHORT).show();
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
                public void onPopupItemClick(ItemData itemData) {
                    Toast.makeText(getBaseContext(), itemData.getText(), Toast.LENGTH_SHORT).show();
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
                public void onPopupItemClick(ItemData itemData) {
                    Toast.makeText(getBaseContext(), itemData.getText(), Toast.LENGTH_SHORT).show();
                }
            });

            //type Subscribe
            KMPAutoComplTextViewSubscribe = (KMPAutoComplTextView) findViewById(R.id.KMPAutoComplTextViewSubscribe);
            ArrayList<ItemData> listSubscribe = new ArrayList<>();

            for (OldSubscribe item: Global.CurrentTask.getOldSubscribeList()) {
                ItemData sss = new ItemData("- " + item.getSubscriberCode() + " - " + item.getTblRequestSubscriberId()  , item.getTblRequestSubscriberId() + "", item.getType() + "");
                listSubscribe.add(sss);
            }
            KMPAutoComplTextViewSubscribe.setDatas(listSubscribe);
            KMPAutoComplTextViewSubscribe.setOnPopupItemClickListener(new KMPAutoComplTextView.OnPopupItemClickListener() {
                @Override
                public void onPopupItemClick(ItemData itemData) {
                    Toast.makeText(getBaseContext(), itemData.getText(), Toast.LENGTH_SHORT).show();
                }
            });


            ///Global.CurrentTask

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
                boolean valid = true;
                AbfaxSelectsObject item1 = null;
                AbfaxSelectsObject item10 = null;
                OldSubscribe itemSubscribe = null;
                AbfaxSelectsUsageTypeInfoDetail itemSubUsage = null;


                try {

                    if (KMPAutoComplTextViewBranch.getText().length() == 0) {
                        valid = false;
                    } else {
                        boolean xv = false;
                        for (WaterBranch item : Global.listBranchs) {
                            if (item.getTitle().equals(KMPAutoComplTextViewBranch.getText().toString())) {
                                xv = true;


                                selectedWaterBranch = item;
                                break;
                            }
                        }
                        if (xv == false) {
                            valid = xv;
                        }
                    }

                    if (KMPAutoComplTextView1.getText().length() == 0) {
                        valid = false;
                    } else {
                        boolean xv = false;
                        for (AbfaxSelectsObject item : Global.allSelects.getObject()) {
                            if (item.getTextValue().equals(KMPAutoComplTextView1.getText().subSequence(2, KMPAutoComplTextView1.getText().length()).toString())) {
                                xv = true;
                                item1 = item;
                                break;
                            }
                        }
                        if (xv == false) {
                            valid = xv;
                        }
                    }
                    if (KMPAutoComplTextViewSubUsage.getText().length() == 0) {
                        valid = false;
                    } else {
                        boolean xv = false;
                        for (AbfaxSelectsUsageTypeInfoDetail item : Global.allSelects.getUsageTypeInfoDetail()) {
                            if (item.getUsageInfoDetailDesc().equals(KMPAutoComplTextViewSubUsage.getText().subSequence(2, KMPAutoComplTextViewSubUsage.getText().length()).toString())) {
                                xv = true;
                                itemSubUsage = item;
                                break;
                            }
                        }
                        if (xv == false) {
                            valid = xv;
                        }
                    }
                    if (KMPAutoComplTextView10.getText().length() == 0) {
                        valid = false;
                    } else {
                        boolean xv = false;
                        for (AbfaxSelectsObject item : Global.allSelects.getObject()) {
                            if (item.getTextValue().equals(KMPAutoComplTextView10.getText().subSequence(2, KMPAutoComplTextView10.getText().length()).toString())) {
                                xv = true;
                                item10 = item;
                                break;
                            }
                        }
                        if (xv == false) {
                            valid = xv;
                        }
                    }


                    for (ItemData itemx : list10) {
                        if (itemx.getText().equals(KMPAutoComplTextView10.getText().toString()))
                            if (itemx.getMeta().equals("0")) {
                                //انتشعاب باید چک بشه
                                if (KMPAutoComplTextViewSubscribe.getText().length() == 0) {
                                    valid = false;
                                } else {
                                    boolean xv = false;
                                    for (OldSubscribe item : Global.CurrentTask.getOldSubscribeList()) {

                                        String sVal = item.getSubscriberCode() + " - " + item.getTblRequestSubscriberId();
                                        if (sVal.equals(KMPAutoComplTextViewSubscribe.getText().subSequence(2, KMPAutoComplTextViewSubscribe.getText().length()).toString())) {
                                            xv = true;
                                            itemSubscribe = item;
                                            break;
                                        }
                                    }
                                    if (xv == false) {
                                        valid = xv;
                                    }
                                }
                            } else {
                                linearLayoutSubscribe.setVisibility(View.GONE);
                            }
                    }


                    if (editTextCount.getText().toString().length() == 0) {
                        valid = false;
                    }
                    if (editTextCount2.getText().toString().length() == 0) {
                        valid = false;
                    }

                    if (valid) {

                        StringBuilder stringBuilder = new StringBuilder();
                        if (KMPAutoComplTextViewSubscribe.getText().length()>2) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder.append(" ");
                            stringBuilder.append("اشتراک قبلی :");
                            stringBuilder.append(" ");
                            stringBuilder.append(KMPAutoComplTextViewSubscribe.getText());

                            newWaterMeter = new WaterMeter(stringBuilder.toString(), stringBuilder2.toString(), 1);
                            ((WaterMeter) newWaterMeter).setType(WATER_METER);
                        }else {
                            newWaterMeter = new WaterMeter(stringBuilder.toString(),"", 1);
                            ((WaterMeter) newWaterMeter).setType(WATER_METER);
                        }



                        if (selectedWaterNetwork.getId() == 0){
                            selectedWaterNetwork = selectedWaterBranch.getWaterNetwork();
                        }
                        newWaterMeter.setWaterNetwork(selectedWaterNetwork);
                        newWaterMeter.setWaterBranch(selectedWaterBranch);

                        newWaterMeter.setCleanOldLine(checkBoxCleanOldLine.isChecked());
                        newWaterMeter.setDiameterWaterMeter(item1);
                        newWaterMeter.setSubUsage(itemSubUsage);
                        newWaterMeter.setCountWaterMeter(Integer.parseInt(editTextCount.getText().toString()));
                        newWaterMeter.setCountUnit(Integer.parseInt(editTextCount2.getText().toString()));
                        newWaterMeter.setInstallStatus(item10);

                        if (itemSubscribe != null)
                            newWaterMeter.setOldSubscribe(itemSubscribe);


                        stringBuilder.append(newWaterMeter.getWaterNetwork().getDiameterWaterPipeNetwork().getTextValue());
                        stringBuilder.append("/");
                        stringBuilder.append(newWaterMeter.getWaterBranch().getDiameterWaterPipeBranch().getTextValue());
                        stringBuilder.append("/");
                        stringBuilder.append(newWaterMeter.getSubUsage().getUsageInfoDetailDesc());




                        Gson gson = new Gson();
                        Intent returnIntent = new Intent();
                        returnIntent.putExtra("result", gson.toJson(newWaterMeter));
                        setResult(Activity.RESULT_OK, returnIntent);

                        Toast.makeText(getContext(), "OK", Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        Toast.makeText(getContext(), "مقادیر را به درستی وارد نکرده اید", Toast.LENGTH_LONG).show();
                    }
                }catch (Exception ex){
                    Toast.makeText(getContext(), "مقادیر را به درستی وارد نکرده اید", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();

        if (Global.listNetwork.size() != 0){
            fillNetwork();

            linearLayoutNewNetwork.setVisibility(View.GONE);
            linearLayoutNetwork.setVisibility(View.VISIBLE);

            linearLayoutBranch.setVisibility(View.VISIBLE);
            linearLayoutNewBranch.setVisibility(View.GONE);

            try {

                List<ItemData> tmpListNetwork = new ArrayList<>();
                for (WaterBranch waterBranch : Global.listBranchs) {
                    ItemData newItem = new ItemData(waterBranch.getTitle(),waterBranch.getId() + "");
                    tmpListNetwork.add(newItem);
                }
                KMPAutoComplTextViewBranch.setDatas(tmpListNetwork);

            }catch (Exception ex){

            }
        }
    }

    private void fillNetwork() {
        ///////////////////////////network////////////////////////
        if (Global.CurrentTask == null ){

        }else {
            KMPAutoComplTextViewnetwork = (KMPAutoComplTextView) findViewById(R.id.KMPAutoComplTextViewnetwork);

            List<ItemData> tmpListNetwork = new ArrayList<>();
            for (WaterNetwork waterNetwork : Global.listNetwork) {
                ItemData newItem = new ItemData(waterNetwork.getTitle(),waterNetwork.getId() + "" , "");
                tmpListNetwork.add(newItem);
            }
            KMPAutoComplTextViewnetwork.setDatas(tmpListNetwork);
            KMPAutoComplTextViewnetwork.setOnPopupItemClickListener(new KMPAutoComplTextView.OnPopupItemClickListener() {
                @Override
                public void onPopupItemClick(ItemData itemData) {
                    Toast.makeText(getBaseContext(), itemData.getText(), Toast.LENGTH_SHORT).show();

                    for (WaterNetwork waterNetwork : Global.listNetwork) {
                        if (waterNetwork.getId() == Integer.parseInt(itemData.getMeta())){
                            selectedWaterNetwork = waterNetwork;
                        }
                    }
                }
            });
        }
        ////////////////////////////////////////////////////
    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_CANCELED, returnIntent);
        finish();
    }
}
