package ir.sajjadyosefi.evaluation.classes.model.responses.Abfax;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;

import java.util.List;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.DRILLING_A;
import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.DRILLING_F;

/**
 * Created by sajjad on 10/31/2016.
 */
public class DrillingListItem extends TubelessObject {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String id;
    private String value;
    private String Text;


    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }


    public void prepareYafteItem(Context mContext, EndlessList_Adapter.DrillingViewHolder holder, List<TubelessObject> mTimelineItemList, int position, EndlessList_Adapter adapter) {

        DrillingListItem request = (DrillingListItem) mTimelineItemList.get(position);
        holder.textViewText.setText(request.getText());
        holder.textViewValue.setText(request.getValue());

        if (request.getType() == DRILLING_A)
            holder.textViewType.setText("شبکه");
        if (request.getType() == DRILLING_F)
            holder.textViewType.setText("فاضلاب");


        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTimelineItemList.remove(position);

                if (mTimelineItemList.size() == 0 )
                    holder.textViewText.setText("موردی برای حفاری وارد نشده است");

                adapter.notifyDataSetChanged();
            }
        });
    }
}
