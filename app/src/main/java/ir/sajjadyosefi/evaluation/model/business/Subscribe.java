package ir.sajjadyosefi.evaluation.model.business;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Transformation;

import java.util.List;

import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.utility.RoundedCornersTransformation;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

public class Subscribe extends TubelessObject {


    public int getSubscriberCode() {
        return subscriberCode;
    }

    public void setSubscriberCode(int subscriberCode) {
        this.subscriberCode = subscriberCode;
    }

    public int getTblRequestSubscriberId() {
        return tblRequestSubscriberId;
    }

    public void setTblRequestSubscriberId(int tblRequestSubscriberId) {
        this.tblRequestSubscriberId = tblRequestSubscriberId;
    }

    private int subscriberCode;
    private int tblRequestSubscriberId;

    final int radius = 5;
    final int margin = 5;
    final Transformation transformation = new RoundedCornersTransformation(radius, margin);


}
