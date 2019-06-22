package ir.sajjadyosefi.evaluation.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.activeandroid.query.Select;
import com.activeandroid.query.Update;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.activity.evaluation.WasterWaterAddActivity;
import ir.sajjadyosefi.evaluation.classes.model.request.account.LoginRequest;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.ListTasks;
import ir.sajjadyosefi.evaluation.classes.utility.CommonClass;
import ir.sajjadyosefi.evaluation.model.business.File;
import ir.sajjadyosefi.evaluation.model.business.Task;
import ir.sajjadyosefi.evaluation.model.business.WasterWater;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;
import ir.sajjadyosefi.evaluation.networkLayout.retrofit.TubelessRetrofitCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class EndlessList_Adapter extends RecyclerView.Adapter<EndlessList_Adapter.ParentViewHolder> {

    //val
    public static  final int LAST_ITEM = 99;
    public static final int WASTER_WATER = 1;
    public static final int TASKS = 2;
    public static final int FILES = 3;
    private boolean deletable;

    public int listType = 0;


    private Context mContext;
    private RecyclerView mRecyclerView;
    private List<TubelessObject> mTimelineItemList;

    EndlessList_Adapter adapter;
    public LinearLayoutManager mLayoutManager = null ;

    private int lastPosition = -1;




    //Task
    public EndlessList_Adapter(
            final Context context,
            LinearLayoutManager mLayoutManager,
            View rootview,
            List<TubelessObject> timelineItemList,
            int type) {
        if (type == TASKS) {
            this.mContext = context;
            this.mLayoutManager = mLayoutManager;
            this.mRecyclerView = rootview.findViewById(R.id.recyclerView);
            this.mTimelineItemList = timelineItemList;
            this.adapter = this;

            if (CommonClass.isNetworkConnected(context)) {
                loadFromServer(context, rootview);
            }else {
                Gson gson = new Gson();
                loadTasksFromDatabaseAndShowInRecyclerView(gson);
            }
        }

    }


    //WasterWater
    public EndlessList_Adapter(Context context, LinearLayoutManager mLayoutManager, View rootview, List<TubelessObject> wasterWaterList) {
        this.mContext = context ;
        this.mLayoutManager = mLayoutManager;
        this.mRecyclerView = rootview.findViewById(R.id.recyclerView);
        this.mTimelineItemList = wasterWaterList;
        this.adapter = this ;
    }

    //FILES
    public EndlessList_Adapter(Context context, LinearLayoutManager mLayoutManager, View rootview, List<TubelessObject> fileItemList, int type, boolean deletable) {
        if (type == FILES) {
            this.mContext = context;
            this.mLayoutManager = mLayoutManager;
            this.mRecyclerView = rootview.findViewById(R.id.recyclerView);
            this.mTimelineItemList = fileItemList;
            this.adapter = this;
            this.deletable = deletable ;
        }


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

    public class TaskViewHolder extends ParentViewHolder {
        public View rootView;
        public TextView textViewName,textViewFamily,textViewRequestType,textViewServicesType,textViewDate,textViewState;
        public Button buttonMenu,buttonEdit,buttonSend;

        public TaskViewHolder(View itemView) {
            super(itemView);

            rootView                    = (View) itemView.findViewById(R.id.rootView);
            textViewName                = (TextView) itemView.findViewById(R.id.textViewName);
            textViewFamily                = (TextView) itemView.findViewById(R.id.textViewFamily);
            textViewRequestType                = (TextView) itemView.findViewById(R.id.textViewRequestType);
            textViewServicesType                = (TextView) itemView.findViewById(R.id.textViewServicesType);
            textViewDate                = (TextView) itemView.findViewById(R.id.textViewDate);
            textViewState                = (TextView) itemView.findViewById(R.id.textViewState);

            buttonMenu            = (Button) itemView.findViewById(R.id.buttonMenu);
            buttonEdit            = (Button) itemView.findViewById(R.id.buttonEdit);
            buttonSend            = (Button) itemView.findViewById(R.id.buttonSend);
        }
    }
    public class EndOfListHolder extends ParentViewHolder {
        public TextView textView;
        public EndOfListHolder (View itemView) {
            super(itemView);
            textView                = (TextView) itemView.findViewById(R.id.textView);
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
    public class FileViewHolder extends ParentViewHolder {
        public TextView textView;
        public Button buttonDelete;

        public FileViewHolder(View itemView) {
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
        if (listType == TASKS) {
            if (viewType == LAST_ITEM) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_last_item_tasks, parent, false);
                return new EndOfListHolder(view);
            }
            if (viewType == TASKS) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_task, parent, false);
                TaskViewHolder yafteItemViewHolder = new TaskViewHolder(view);
                return yafteItemViewHolder;
            }
            if (viewType == 0) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_progress, parent, false);
                ProgressViewHolder holder = new ProgressViewHolder(view);
                return holder;
            }
        }
        if (listType == FILES){
            if (viewType == LAST_ITEM) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_last_item_files, parent, false);
                return new EndOfListHolder(view);
            }
            if (viewType == FILES) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_file, parent, false);
                FileViewHolder viewHolder = new FileViewHolder(view);
                return viewHolder;
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
        if (listType == TASKS) {
            if (mTimelineItemList.size() > 0 && mTimelineItemList.size() != position && mTimelineItemList.get(position).getType() == TASKS) {
                ((Task)mTimelineItemList.get(position)).prepareYafteItem(mContext, (TaskViewHolder) holder, mTimelineItemList, position,adapter);
            }else {
                //LAST ITEM
//
//                if (mTimelineItemList.size() == 0 )
//                    ((EndOfListHolder)holder).textView.setText(R.string.not_any_file);
            }
        }
        if (listType == FILES) {
            if (mTimelineItemList.size() > 0 && mTimelineItemList.size() != position && mTimelineItemList.get(position).getType() == FILES) {
                ((File)mTimelineItemList.get(position)).prepareYafteItem(mContext, (FileViewHolder) holder, mTimelineItemList, position,adapter,deletable);
            }else {
                //LAST ITEM

                if (mTimelineItemList.size() == 0 )
                    ((EndOfListHolder)holder).textView.setText(R.string.not_any_file);
            }
        }
//        setAnimation(holder.itemView, position);
    }


    private void loadFromServer(Context context, View rootview) {
        Global.apiManagerTubeless.getTasks(new LoginRequest(),new TubelessRetrofitCallback<Object>(context, rootview, true, null, new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Gson gson = new Gson();
                JsonElement jsonElement = gson.toJsonTree(response.body());
                ListTasks serverTaskList = gson.fromJson(jsonElement , ListTasks.class);

                for (Task serverTask : serverTaskList.getObject()) {

                    List<ir.sajjadyosefi.evaluation.model.db.Task> databaseTaskList = new Select()
                            .from(ir.sajjadyosefi.evaluation.model.db.Task.class)
                            .where("taskID = ?", serverTask.getSerialRequestCode()
                            )
                            .execute();



                    if (databaseTaskList.size() == 0){
                        //insert
                        ir.sajjadyosefi.evaluation.model.db.Task ttttt = new ir.sajjadyosefi.evaluation.model.db.Task();
                        ttttt.editedTask = gson.toJson(serverTask) ;
                        ttttt.taskID = serverTask.getSerialRequestCode();
                        ttttt.orginalTask = gson.toJson(serverTask);
                        ttttt.save();


                    }else if (databaseTaskList.size() == 1){
                        //update
                        new Update(ir.sajjadyosefi.evaluation.model.db.Task.class)
                                .set("orginalTask = ?" , gson.toJson(serverTask))
                                .where("taskID = ?", serverTask.getSerialRequestCode())
                                .execute();

                    }else {

                    }
                }
                loadTasksFromDatabaseAndShowInRecyclerView(gson);
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {


            }
        }));
    }

    private void loadTasksFromDatabaseAndShowInRecyclerView(Gson gson) {
        //show Items in recyclerView
        List<ir.sajjadyosefi.evaluation.model.db.Task> databaseTaskList = new Select()
                .from(ir.sajjadyosefi.evaluation.model.db.Task.class)
                .where("taskID <> ?", ""
                )
                .execute();

        mTimelineItemList.clear();

        for (ir.sajjadyosefi.evaluation.model.db.Task item : databaseTaskList) {
            Task dbTask = gson.fromJson(item.editedTask, Task.class);
            dbTask.type = TASKS;
            mTimelineItemList.add(dbTask);
        }
        adapter.notifyDataSetChanged();
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

        if (listType == TASKS)
            return position == mTimelineItemList.size() ? LAST_ITEM : mTimelineItemList.get(position).getType();

        if (listType == FILES)
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