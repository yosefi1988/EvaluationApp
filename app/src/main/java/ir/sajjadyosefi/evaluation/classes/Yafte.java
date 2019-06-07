package ir.sajjadyosefi.evaluation.classes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.activity.ReadBlogActivity;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.model.main.TimelineItem;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;
import ir.sajjadyosefi.evaluation.classes.utility.DateConverterSjd;
import ir.sajjadyosefi.evaluation.classes.utility.RoundedCornersTransformation;

import java.util.Date;
import java.util.List;

/**
 * Created by sajjad on 9/19/2018.
 */

public class Yafte {

    final int radius = 5;
    final int margin = 5;
    final Transformation transformation = new RoundedCornersTransformation(radius, margin);

}
