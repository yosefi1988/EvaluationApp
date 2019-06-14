package ir.sajjadyosefi.evaluation.model.business;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.squareup.picasso.Transformation;

import java.util.List;

import ir.sajjadyosefi.evaluation.activity.account.DetailsActivity;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.utility.RoundedCornersTransformation;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

public class Task extends TubelessObject {

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public String getSubscribeCode() {
        return subscribeCode;
    }

    public void setSubscribeCode(String subscribeCode) {
        this.subscribeCode = subscribeCode;
    }

    private String id;
    private boolean Siphon;
    private int count;
    private int length;
    private int diameter;
    private String subscribeCode;

    final int radius = 5;
    final int margin = 5;
    final Transformation transformation = new RoundedCornersTransformation(radius, margin);

    public void prepareYafteItem(Context mContext, EndlessList_Adapter.TaskViewHolder holder, List<TubelessObject> mTimelineItemList, int position, EndlessList_Adapter adapter) {
        Task wasterWater = (Task) mTimelineItemList.get(position);

        StringBuilder text = new StringBuilder();
        text.append("بدون سیفون");
        text.append(" ");
        text.append("کد اشتراک");
        text.append(" ");
        text.append(wasterWater.subscribeCode);
        holder.textViewName.setText(text.toString());


        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                //mTimelineItemList.get(position)
                ((Activity)mContext).startActivity(intent);
            }
        });
    }
}
