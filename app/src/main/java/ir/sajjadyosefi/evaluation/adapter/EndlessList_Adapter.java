package ir.sajjadyosefi.evaluation.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.activity.evaluation.WasterWaterAddActivity;
import ir.sajjadyosefi.evaluation.model.business.WasterWater;
import ir.sajjadyosefi.evaluation.model.main.TimelineItem;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;
import ir.sajjadyosefi.evaluation.classes.model.responses.blog.TimelineListResponse;
import ir.sajjadyosefi.evaluation.networkLayout.retrofit.TubelessRetrofitCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class EndlessList_Adapter extends RecyclerView.Adapter<EndlessList_Adapter.ParentViewHolder> {

    //val
    public static  final int LAST_ITEM = 99;
    public static final int WASTER_WATER = 1;

    public int listType = 0;


    private Context mContext;
    private RecyclerView mRecyclerView;
    private List<TubelessObject> mTimelineItemList;

    EndlessList_Adapter adapter;
    public LinearLayoutManager mLayoutManager = null ;

    private int lastPosition = -1;




    public EndlessList_Adapter(
            final Context context,
            LinearLayoutManager mLayoutManager,
            View rootview,
            List<TubelessObject> timelineItemList,
            final int idHeader) {
        this.mContext = context ;
        this.mLayoutManager = mLayoutManager;
        this.mRecyclerView = rootview.findViewById(R.id.recyclerView);
        this.mTimelineItemList =  timelineItemList;
        this.adapter = this ;

        loadTimeline(context,1,false);
    }


    //WasterWater
    public EndlessList_Adapter(Context context, LinearLayoutManager mLayoutManager, View rootview, List<TubelessObject> wasterWaterList) {
        this.mContext = context ;
        this.mLayoutManager = mLayoutManager;
        this.mRecyclerView = rootview.findViewById(R.id.recyclerView);
        this.mTimelineItemList = wasterWaterList;
        this.adapter = this ;
    }



    ///////////////////////  ViewHolder   /////////////////////////
    public class ParentViewHolder extends RecyclerView.ViewHolder {

        public ParentViewHolder(View itemView) {
            super(itemView);
        }

        public void clearAnimation() {
            itemView.clearAnimation();
        }
    }

    public class ProgressViewHolder extends ParentViewHolder {
        public ProgressViewHolder(View itemView) {
            super(itemView);
//            linearLayoutCenter            = (LinearLayout) itemView.findViewById(R.id.linearLayoutCenter);
        }
    }

    public class WasterWaterViewHolder extends ParentViewHolder {
        public TextView textView;
        public Button buttonDelete;

        public WasterWaterViewHolder(View itemView) {
            super(itemView);
            textView                = (TextView) itemView.findViewById(R.id.textView);
            buttonDelete            = (Button) itemView.findViewById(R.id.buttonDelete);
        }
    }
    public class AddViewHolder extends ParentViewHolder {
        public Button buttonSubmit;

        public AddViewHolder(View itemView) {
            super(itemView);
            buttonSubmit            = (Button) itemView.findViewById(R.id.submit);
        }
    }
    //////////////////// End ViewHolder   /////////////////////////

    @Override
    public ParentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (listType == WASTER_WATER) {
            if (viewType == LAST_ITEM) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_last_item_waster_water, parent, false);
                return new AddViewHolder(view);
            }
            if (viewType == WASTER_WATER) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_waster_water, parent, false);
                WasterWaterViewHolder yafteItemViewHolder = new WasterWaterViewHolder(view);
                return yafteItemViewHolder;
            }
            if (viewType == 0) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_progress, parent, false);
                ProgressViewHolder holder = new ProgressViewHolder(view);
                return holder;
            }
        }

        return  null;
    }

    @Override
    public void onBindViewHolder(final ParentViewHolder holder, final int position) {
        if (listType == WASTER_WATER) {
            if (mTimelineItemList.size() > 0 && mTimelineItemList.size() != position && mTimelineItemList.get(position).getType() == WASTER_WATER) {
                ((WasterWater)mTimelineItemList.get(position)).prepareYafteItem(mContext, (WasterWaterViewHolder) holder, mTimelineItemList, position,adapter);
            }else {
                //LAST ITEM
                ((AddViewHolder)holder).buttonSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(mContext, WasterWaterAddActivity.class);
                        ((Activity)mContext).startActivityForResult(i, 1);
                    }
                });

            }
        }
//        setAnimation(holder.itemView, position);
    }


    private void loadTimeline(Context context,int current_page,boolean isRefresh) {
        Global.apiManagerTubeless.getTimeline(current_page - 1,new TubelessRetrofitCallback<Object>(context, null, true, null, new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Gson gson = new Gson();
                JsonElement jsonElement = gson.toJsonTree(response.body());
                TimelineListResponse responseX = gson.fromJson(jsonElement.getAsString(), TimelineListResponse.class);


                for (TimelineItem item : responseX.getTimelineList()){
                    item.setType(WASTER_WATER);
                    mTimelineItemList.add(item);
                    if (isRefresh) {
                        adapter.notifyDataSetChanged();
                    }else {
                        adapter.notifyItemInserted(mTimelineItemList.size());
                    }
                }
//                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        }));
    }



    ///////////////////////  ok   /////////////////////////
    @Override
    public int getItemCount() {
        return mTimelineItemList.size() + 1;
    }

    @Override
    public void onViewDetachedFromWindow(final ParentViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
        ((ParentViewHolder)holder).clearAnimation();
    }

    @Override
    public int getItemViewType(int position) {
        if (listType == WASTER_WATER)
            return position == mTimelineItemList.size() ? LAST_ITEM : mTimelineItemList.get(position).getType();
        else return 0;
    }

//    private void setAnimation(View viewToAnimate, int position) {
//        // If the bound view wasn't previously displayed on screen, it's animated
//        if (position > lastPosition)
//        {
//            //Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
//            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.slide_in_left_timeline);
//            viewToAnimate.startAnimation(animation);
//            lastPosition = position;
//        }
//    }
}