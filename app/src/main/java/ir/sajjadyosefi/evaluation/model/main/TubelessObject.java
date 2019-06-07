package ir.sajjadyosefi.evaluation.model.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.Date;
import java.util.List;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.activity.ReadBlogActivity;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.JsonDateDeserializer;
import ir.sajjadyosefi.evaluation.classes.utility.DateConverterSjd;
import ir.sajjadyosefi.evaluation.classes.utility.RoundedCornersTransformation;

public class TubelessObject extends Object{
    public int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


}
