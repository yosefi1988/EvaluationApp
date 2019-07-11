package ir.sajjadyosefi.evaluation.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.UsageListItem;
import ir.sajjadyosefi.evaluation.model.business.WasterWater;
import ir.sajjadyosefi.evaluation.model.main.TimelineItem;

import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.WASTER_WATER;

/**
 * Created by sajjad on 2/11/2018.
 */

public class EditUsageCountActivity extends TubelessActivity {

    Context mContext = null;

    TextView textViewTitle;
    TextView textViewCount;
    TextView textViewSep;

    CheckBox checkBox;
    EditText editText;
    Button submit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_edit_count);
        mContext = this;

        Gson gson = new Gson();
        String objectString = getIntent().getStringExtra("Object");
        int index = getIntent().getIntExtra("index",0);
        UsageListItem item = gson.fromJson(objectString, UsageListItem.class);

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewCount = findViewById(R.id.textViewCount);
        textViewSep = findViewById(R.id.textViewSep);

        checkBox = findViewById(R.id.checkBox);
        editText = findViewById(R.id.editText);
        submit = findViewById(R.id.submit);


        textViewTitle.setText(item.getUsageDesc());
        textViewCount.setText(item.getWaterMainUnitQtyReq() + "");
        textViewSep.setText(item.getNeedSeparationReq() == 1 ? "بلی" : "خیر");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().length() >= 1){

                    item.setNeedSeparationReq2(checkBox.isChecked());
                    item.setEdited(true);
                    item.setWaterMainUnitQtyReq2(Integer.parseInt(editText.getText().toString()));

                    Gson gson = new Gson();
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("result",gson.toJson(item));
                    returnIntent.putExtra("index",index);
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();
                }else {
                    Toast.makeText(getContext(),"مقداری وارد نکرده اید",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
