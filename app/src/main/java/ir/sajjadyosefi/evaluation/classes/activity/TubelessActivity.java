package ir.sajjadyosefi.evaluation.classes.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ir.sajjadyosefi.evaluation.R;

import static ir.sajjadyosefi.evaluation.classes.utility.CommonClass.convertPixelsToDp;

public class TubelessActivity extends AppCompatActivity {


    private Context context;
    private Activity activity;
    private View rootActivity;
    public Dialog dialog ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        activity = this;
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.main_progress);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        int width  = Resources.getSystem().getDisplayMetrics().widthPixels;

//        dialog.getWindow().setLayout(convertPixelsToDp(width ,getContext()), ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog.getWindow().setLayout(200, ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        dialog.getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL); // set title and message direction to RTL

        dialog.setCancelable(false);

//        getSupportActionBar().hide();

    }



    public void setRootActivity(View rootActivity) {
        this.rootActivity = rootActivity;
    }

    public View getRootActivity() {
        return rootActivity;
    }


    public Context getContext(){
        return context;
    }
    public Activity getActivity(){
        return activity;
    }


    private void setProgressDialog() {

        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.main_progress);
        dialog.setCancelable(true);
        //there are a lot of settings, for dialog, check them all out!

//        dialog.getWindow().getDecorView().getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0x00ffffff));

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.show();
    }

}
