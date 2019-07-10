package ir.sajjadyosefi.evaluation.classes.model.responses.Abfax;

import android.content.Context;
import android.widget.CompoundButton;

import java.util.List;

import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

/**
 * Created by sajjad on 10/31/2016.
 */
public class AbfaxSelectsObjectSelectable extends AbfaxSelectsObject {

    private boolean isSelected;

    public AbfaxSelectsObjectSelectable(String text, int key , boolean isSelected) {
        super(text, key);
        this.isSelected = isSelected;
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public void prepareYafteItem(Context mContext, boolean enable, EndlessList_Adapter.ToDotViewHolder holder, List<TubelessObject> mTimelineItemList, int position, EndlessList_Adapter adapter) {

        AbfaxSelectsObjectSelectable request = (AbfaxSelectsObjectSelectable) mTimelineItemList.get(position);
        holder.textView.setText(request.getTextValue() + "");
        //holder.checkBox.setText(request.getKeyValue());

        if (enable){
            holder.checkBox.setEnabled(enable);
            if (request.isSelected()){
                holder.checkBox.setChecked(request.isSelected());
            }
            holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    request.setSelected(b);
                }
            });
        }else {
            holder.checkBox.setEnabled(enable);
        }

    }
}
