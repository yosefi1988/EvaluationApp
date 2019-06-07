package ir.sajjadyosefi.evaluation.model.business;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Transformation;

import java.util.Date;
import java.util.List;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.activity.ReadBlogActivity;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.JsonDateDeserializer;
import ir.sajjadyosefi.evaluation.classes.utility.DateConverterSjd;
import ir.sajjadyosefi.evaluation.classes.utility.RoundedCornersTransformation;
import ir.sajjadyosefi.evaluation.model.main.TimelineItem;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

public class WasterWater extends TubelessObject {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSiphon() {
        return Siphon;
    }

    public void setSiphon(boolean siphon) {
        Siphon = siphon;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSubscribeCode() {
        return subscribeCode;
    }

    public void setSubscribeCode(String subscribeCode) {
        this.subscribeCode = subscribeCode;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    private int id;
    private boolean Siphon;
    private int count;
    private int length;
    private int diameter;
    private String subscribeCode;

    final int radius = 5;
    final int margin = 5;
    final Transformation transformation = new RoundedCornersTransformation(radius, margin);

    public void prepareYafteItem(Context mContext, EndlessList_Adapter.WasterWaterViewHolder holder, List<TubelessObject> mTimelineItemList, int position, EndlessList_Adapter adapter) {
        WasterWater wasterWater = (WasterWater) mTimelineItemList.get(position);

        StringBuilder text = new StringBuilder();
        if (wasterWater.isSiphon()){
            text.append("دارای سیفون");
            text.append(" ");
            text.append("به طول");
            text.append(" ");
            text.append(wasterWater.length);
            text.append("متر");
            holder.textView.setText(text.toString());
        }else {
            text.append("بدون سیفون");
            text.append(" ");
            text.append("کد اشتراک");
            text.append(" ");
            text.append(wasterWater.subscribeCode);
            holder.textView.setText(text.toString());
        }

        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTimelineItemList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
