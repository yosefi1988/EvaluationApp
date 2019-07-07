package ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.NetworkAndBranch;

import android.content.Context;
import android.view.View;

import java.util.List;

import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.AbfaxSelectsObject;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

/**
 * Created by sajjad on 10/31/2016.
 */
public class WaterMeter extends TubelessObject {

    //1
    private AbfaxSelectsObject diameterWaterMeter;
    private AbfaxSelectsObject subUsage;
    private int countWaterMeter;
    private int countUnit;
    private AbfaxSelectsObject installStatus;
    private OldSubscribe oldSubscribe ;


    //2
    private WaterBranch waterBranch ;
    private WaterNetwork waterNetwork;



    private int keyValue;
    private String textValue;
    private String text2Value;

    public WaterMeter(String text, String text2, int key) {
        keyValue = key;
        textValue = text;
        text2Value = text2;
    }

    public int getKeyValue() {
        return keyValue;
    }


    public String getText2Value() {
        return text2Value;
    }

    public void setText2Value(String text2Value) {
        this.text2Value = text2Value;
    }


    public void setKeyValue(int keyValue) {
        this.keyValue = keyValue;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }



    public AbfaxSelectsObject getDiameterWaterMeter() {
        return diameterWaterMeter;
    }

    public void setDiameterWaterMeter(AbfaxSelectsObject diameterWaterMeter) {
        this.diameterWaterMeter = diameterWaterMeter;
    }

    public AbfaxSelectsObject getSubUsage() {
        return subUsage;
    }

    public void setSubUsage(AbfaxSelectsObject subUsage) {
        this.subUsage = subUsage;
    }

    public int getCountWaterMeter() {
        return countWaterMeter;
    }

    public void setCountWaterMeter(int countWaterMeter) {
        this.countWaterMeter = countWaterMeter;
    }

    public int getCountUnit() {
        return countUnit;
    }

    public void setCountUnit(int countUnit) {
        this.countUnit = countUnit;
    }

    public AbfaxSelectsObject getInstallStatus() {
        return installStatus;
    }

    public void setInstallStatus(AbfaxSelectsObject installStatus) {
        this.installStatus = installStatus;
    }

    public OldSubscribe getOldSubscribe() {
        return oldSubscribe;
    }

    public void setOldSubscribe(OldSubscribe oldSubscribe) {
        this.oldSubscribe = oldSubscribe;
    }

    public WaterBranch getWaterBranch() {
        return waterBranch;
    }

    public void setWaterBranch(WaterBranch waterBranch) {
        this.waterBranch = waterBranch;
    }

    public WaterNetwork getWaterNetwork() {
        return waterNetwork;
    }

    public void setWaterNetwork(WaterNetwork waterNetwork) {
        this.waterNetwork = waterNetwork;
    }


    public void prepareYafteItem(Context mContext, EndlessList_Adapter.NetworkViewHolder holder, List<TubelessObject> mTimelineItemList, int position, EndlessList_Adapter adapter) {

        WaterMeter waterMeter = (WaterMeter) mTimelineItemList.get(position);


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("شبکه شماره");
        stringBuilder.append(" ");
        stringBuilder.append(waterMeter.waterNetwork.getId());
        stringBuilder.append("/");

        stringBuilder.append("قطر شبکه");
        stringBuilder.append(" ");
        stringBuilder.append(waterMeter.waterNetwork.getDiameterWaterPipeNetwork().getTextValue());
        stringBuilder.append("/");

        stringBuilder.append("قطر انشعاب");
        stringBuilder.append(" ");
        stringBuilder.append(waterMeter.getWaterBranch().getDiameterWaterPipeBranch().getTextValue());

        holder.textView.setText(stringBuilder.toString());

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("کاربری");
        stringBuilder2.append(" ");
        stringBuilder2.append(waterMeter.getSubUsage().getTextValue());


        if (waterMeter.getOldSubscribe() != null){
            stringBuilder2.append("-");
            stringBuilder2.append("اشتراک قدیمی");
            stringBuilder2.append(":");
            stringBuilder2.append(waterMeter.getOldSubscribe().getTblRequestSubscriberId());
        }

        holder.textView2.setText(stringBuilder2.toString());
        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTimelineItemList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });




    }
}
