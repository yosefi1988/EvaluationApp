package ir.sajjadyosefi.evaluation.classes.model.responses.Abfax;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;

import java.util.List;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.model.business.File;
import ir.sajjadyosefi.evaluation.model.business.Task;
import ir.sajjadyosefi.evaluation.model.exception.TubelessException;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

/**
 * Created by sajjad on 10/31/2016.
 */
public class AbfaxSelectsObject  extends TubelessObject {

    private int keyValue;
    private String textValue;

    public AbfaxSelectsObject(String text, int key) {
        keyValue = key;
        textValue = text;
    }

    public int getKeyValue() {
        return keyValue;
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

    public void prepareYafteItem(Context mContext, boolean enable, EndlessList_Adapter.ToDotViewHolder holder, List<TubelessObject> mTimelineItemList, int position, EndlessList_Adapter adapter) {

        AbfaxSelectsObject request = (AbfaxSelectsObject) mTimelineItemList.get(position);
        holder.textView.setText(request.getTextValue() + "");
        //holder.checkBox.setText(request.getKeyValue());

        if (enable){
            holder.checkBox.setEnabled(enable);
        }else {
            holder.checkBox.setEnabled(enable);
        }
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //tooooooooooooooooast

                int a = 4 ;
                a++;
            }
        });
    }
}
