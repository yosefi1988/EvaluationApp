package ir.sajjadyosefi.evaluation.classes.model.responses.Abfax;

import android.content.Context;
import android.view.View;

import java.util.List;

import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

/**
 * Created by sajjad on 10/31/2016.
 */
public class OldSubscribeListItem  extends TubelessObject {

    private int subscriberCode;
    private int tblRequestSubscriberId;

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

    public void prepareYafteItem(Context mContext, EndlessList_Adapter.SubscribeViewHolder holder, List<TubelessObject> mTimelineItemList, int position, EndlessList_Adapter adapter) {
        OldSubscribeListItem subscribe = (OldSubscribeListItem) mTimelineItemList.get(position);

        StringBuilder text = new StringBuilder();

        holder.textViewCode.setText(  "کد:"  +subscribe.getSubscriberCode() + "");
        holder.textViewValue.setText("مصرف" + subscribe.getTblRequestSubscriberId() + "");

        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTimelineItemList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
