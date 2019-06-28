package ir.sajjadyosefi.evaluation.classes.model.responses.Abfax;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.google.gson.Gson;

import java.util.List;

import ir.sajjadyosefi.evaluation.activity.EditUsageCountActivity;
import ir.sajjadyosefi.evaluation.activity.account.LoginActivity;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.model.business.WasterWater;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

import static com.activeandroid.Cache.getContext;

/**
 * Created by sajjad on 10/31/2016.
 */
public class UsageListItem  extends TubelessObject {


    private int usageTypeIdReq;
    private int waterMainUnitQtyReq;
    private int needSeparationReq;
    private String usageDesc;
    private boolean edited = false;
    private int waterMainUnitQtyReq2;
    private int needSeparationReq2;

    public int getUsageTypeIdReq() {
        return usageTypeIdReq;
    }

    public void setUsageTypeIdReq(int usageTypeIdReq) {
        this.usageTypeIdReq = usageTypeIdReq;
    }

    public int getWaterMainUnitQtyReq() {
        return waterMainUnitQtyReq;
    }

    public void setWaterMainUnitQtyReq(int waterMainUnitQtyReq) {
        this.waterMainUnitQtyReq = waterMainUnitQtyReq;
    }

    public int getNeedSeparationReq() {
        return needSeparationReq;
    }

    public void setNeedSeparationReq(int needSeparationReq) {
        this.needSeparationReq = needSeparationReq;
    }


    public int getWaterMainUnitQtyReq2() {
        return waterMainUnitQtyReq2;
    }

    public void setWaterMainUnitQtyReq2(int waterMainUnitQtyReq2) {
        this.waterMainUnitQtyReq2 = waterMainUnitQtyReq2;
    }

    public int getNeedSeparationReq2() {
        return needSeparationReq2;
    }

    public void setNeedSeparationReq2(int needSeparationReq2) {
        this.needSeparationReq2 = needSeparationReq2;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }


    public String getUsageDesc() {
        return usageDesc;
    }

    public void setUsageDesc(String usageDesc) {
        this.usageDesc = usageDesc;
    }

    public void prepareYafteItem(Context mContext, EndlessList_Adapter.UsageViewHolder holder, List<TubelessObject> mTimelineItemList, int position, EndlessList_Adapter adapter) {

        UsageListItem usageListItem = (UsageListItem) mTimelineItemList.get(position);

        StringBuilder text = new StringBuilder();

        holder.textViewUsageDesc.setText(usageListItem.getUsageDesc().toString());

        holder.textViewCount.setText(usageListItem.getWaterMainUnitQtyReq() + "");
        holder.checkBoxNeedSeparationReq.setChecked(usageListItem.needSeparationReq == 1 ? true : false);

        if (usageListItem.isEdited()){
            holder.textViewCount2.setText(usageListItem.getWaterMainUnitQtyReq2() + "");
            holder.checkBoxNeedSeparationReq2.setChecked(usageListItem.needSeparationReq2 == 1 ? true : false);
        }

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                Intent i = new Intent(mContext, EditUsageCountActivity.class);
                i.putExtra("Object" ,  gson.toJson(usageListItem));
                i.putExtra("index" ,  position);
                ((Activity)mContext).startActivityForResult(i, 1);
            }
        });
    }
}
