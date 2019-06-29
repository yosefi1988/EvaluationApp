package ir.sajjadyosefi.evaluation.classes.model.responses.Abfax;

import android.content.Context;
import android.widget.CompoundButton;

import java.util.List;

import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

/**
 * Created by sajjad on 10/31/2016.
 */
public class Network extends TubelessObject {

    private int keyValue;
    private String textValue;

    public Network(String text, int key) {
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

    public void prepareYafteItem(Context mContext, EndlessList_Adapter.NetworkViewHolder holder, List<TubelessObject> mTimelineItemList, int position, EndlessList_Adapter adapter) {

        Network request = (Network) mTimelineItemList.get(position);


        holder.textView.setText(request.getTextValue() + "");




    }
}
