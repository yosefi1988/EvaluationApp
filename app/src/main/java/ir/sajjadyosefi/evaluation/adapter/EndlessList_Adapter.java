package ir.sajjadyosefi.evaluation.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.hlab.fabrevealmenu.enums.Direction;
import com.hlab.fabrevealmenu.listeners.OnFABMenuSelectedListener;
import com.hlab.fabrevealmenu.view.FABRevealMenu;
import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.model.main.TimelineItem;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.classes.Yafte;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;
import ir.sajjadyosefi.evaluation.classes.model.responses.blog.TimelineListResponse;
import ir.sajjadyosefi.evaluation.classes.wiget.EndlessRecyclerOnScrollListener;
import ir.sajjadyosefi.evaluation.networkLayout.retrofit.TubelessRetrofitCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class EndlessList_Adapter extends RecyclerView.Adapter<EndlessList_Adapter.ParentViewHolder> {

    //val
    final int POST_ITEM_TYPE = 0;
    final int Tubeless_ITEM_TYPE = 1;
    final int PROGRESS_TYPE = 2;

    private String term;
    private Context mContext;
    private TextView mTextViewNoting;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerViewTimeline;
    private List<TubelessObject> mTimelineItemList;


    EndlessList_Adapter adapter;
    public FloatingActionButton floatingActionButton;
    EndlessRecyclerOnScrollListener onScrollListener;


    //User Profile
    String userId;
    private String path;
    public static ImageView btPosterPic, coverPic;
    private TextView fullName;
    private TextView location;
    public LinearLayoutManager mLayoutManager = null ;

    private int lastPosition = -1;


    public EndlessList_Adapter(Context context, LinearLayoutManager mLinearLayoutManager, View rootview, List<TubelessObject> timelineItemList) {
        this.mContext = context ;
        this.mLayoutManager = mLayoutManager;
        this.mTextViewNoting = rootview.findViewById(R.id.textViewNoting);
        this.mSwipeRefreshLayout = rootview.findViewById(R.id.swipeRefreshLayout);
        this.mRecyclerViewTimeline = rootview.findViewById(R.id.recyclerView);
        this.mTextViewNoting = rootview.findViewById(R.id.textViewNoting);
        this.mTimelineItemList =  timelineItemList;
        this.adapter = this ;
    }


    public EndlessList_Adapter(
            final Context context,
            LinearLayoutManager mLayoutManager,
            View rootview,
            List<TubelessObject> timelineItemList,
            final int idHeader) {
        this.mContext = context ;
        this.mLayoutManager = mLayoutManager;
        this.mTextViewNoting = rootview.findViewById(R.id.textViewNoting);
        this.mSwipeRefreshLayout = rootview.findViewById(R.id.swipeRefreshLayout);
        this.mRecyclerViewTimeline = rootview.findViewById(R.id.recyclerView);
        this.mTextViewNoting = rootview.findViewById(R.id.textViewNoting);
        this.mTimelineItemList =  timelineItemList;
        this.adapter = this ;


        this.floatingActionButton = rootview.findViewById(R.id.fab);
        FABRevealMenu fabMenu = rootview.findViewById(R.id.fabMenu);

        onScrollListener = new EndlessRecyclerOnScrollListener(mLayoutManager) {
            @Override
            protected void onScrollUp() {
                if (!floatingActionButton.isShown()) {
                    floatingActionButton.show();
                }
            }

            @Override
            protected void onScrollDown() {
                if (floatingActionButton.isShown()) {
                    floatingActionButton.hide();
                }
            }

            @Override
            public void onLoadMore(int current_page) {
                loadTimeline(context,current_page,false);
            }
        };
        mRecyclerViewTimeline.addOnScrollListener(onScrollListener);

        this.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idHeader == 16 || idHeader == 17 || idHeader == 18) {
//                    Intent intent = new Intent(context,NewYafteActivity.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putInt(ContactUsActivity.Type,16);
//                    intent.putExtras(bundle);
//                    startActivity(intent);
//                    getActivity().overridePendingTransition(R.anim.fadeout, R.anim.fadein);
                }else {
//                    context.startActivity(new Intent(context, UploadPictureActivity.class));
//                    getContext().startActivity(new Intent(getContext(), NewBlogActivity.class));
                }
            }
        });
        if (floatingActionButton != null && fabMenu != null) {
//                fabMenu = fabMenu;
            //attach menu to fab
            fabMenu.bindAnchorView(floatingActionButton);
            //set menu selection listener
            fabMenu.setOnFABMenuSelectedListener(new OnFABMenuSelectedListener() {
                @Override
                public void onMenuItemSelected(View view, int id) {
                    if (id == R.id.menu_attachment) {
                        Toast.makeText(mContext, "Attachment Selected", Toast.LENGTH_SHORT).show();
                    } else if (id == R.id.menu_image) {
                        Toast.makeText(mContext, "Image Selected", Toast.LENGTH_SHORT).show();
                    } else if (id == R.id.menu_place) {
                        Toast.makeText(mContext, "Place Selected", Toast.LENGTH_SHORT).show();
                    } else if (id == R.id.menu_emoticon) {
                        Toast.makeText(mContext, "Emoticon Selected", Toast.LENGTH_SHORT).show();
                    }else {
                        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }
            });
        }
        fabMenu.setMenuDirection(Direction.UP);
        firstLoadAndRefresh(this.mContext);
    }


//    boolean animationAvalable = false;
//    public void notifyDataSetChanged(boolean animationAvalable) {
//        this.animationAvalable = animationAvalable ;
//        notifyDataSetChanged();
//    }

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

    public class TimelineItemViewHolder extends ParentViewHolder {

        public LinearLayout linearLayoutTop;
        public LinearLayout linearLayoutCenter;
        public LinearLayout linearLayoutBottom;

        public ImageView imageViewShare;
        public TextView textViewShare;

        public ImageView imageViewUserAvatar;
        public ImageView imageviewPicture;
        public TextView textViewUserName;

        public TextView textViewTitle;
        public TextView textViewLocation;
        public TextView textViewDate;
        public TextView textViewCount;

        public TimelineItemViewHolder(View itemView) {
            super(itemView);

            linearLayoutTop               = (LinearLayout) itemView.findViewById(R.id.linearLayoutTop);
            linearLayoutCenter            = (LinearLayout) itemView.findViewById(R.id.linearLayoutCenter);
            linearLayoutBottom            = (LinearLayout) itemView.findViewById(R.id.linearLayoutCenter);

            imageViewShare               = (ImageView) itemView.findViewById(R.id.imageViewShare);
            textViewShare                = (TextView) itemView.findViewById(R.id.textViewShare);


            imageViewUserAvatar           = (ImageView) itemView.findViewById(R.id.imageViewUserAvatar);
            imageviewPicture           = (ImageView) itemView.findViewById(R.id.textViewDate);
            textViewUserName              = (TextView) itemView.findViewById(R.id.textViewUserName);

            textViewTitle                 = (TextView) itemView.findViewById(R.id.textViewDate);
            textViewLocation              = (TextView) itemView.findViewById(R.id.textViewDate);
            textViewDate                  = (TextView) itemView.findViewById(R.id.textViewDate);
            textViewCount                 = (TextView) itemView.findViewById(R.id.textViewCount);
        }
    }
    ///////////////////////  ViewHolder   /////////////////////////


    public static void prepareToShare(Context mContext, String filePath, String statement, boolean loadedImage) {
//        //String FileName = SaveScreenshot();
//
//        String FileName = null;
//        if(loadedImage)
//            FileName = SaveImage(mContext,filePath,null);
//
//        Intent intent4 = new Intent(Intent.ACTION_SEND);
////        intent4.setType("image/*");
////        intent4.setType("image/jpeg");
//        intent4.setType("*/*");
//
//        if(loadedImage)
//            intent4.putExtra(Intent.EXTRA_STREAM, Uri.parse(FileName));
//
//        intent4.putExtra(Intent.EXTRA_TEXT,statement + "" + "");
//        mContext.startActivity(Intent.createChooser(intent4, ""));
    }

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            //Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.slide_in_left_timeline);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    ///////////////////////  ok   /////////////////////////
    @Override
    public int getItemCount() {
        return mTimelineItemList.size() + 1;
    }

    @Override
    public ParentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == PROGRESS_TYPE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_progress, parent, false);
            return new ProgressViewHolder(view);
        }
        if (viewType == Tubeless_ITEM_TYPE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout._row_task_item, parent, false);
            TimelineItemViewHolder yafteItemViewHolder = new TimelineItemViewHolder(view);
            return yafteItemViewHolder;
        }
        return  null;
    }

    @Override
    public void onBindViewHolder(final ParentViewHolder holder, final int position) {
        if (position != mTimelineItemList.size()) {
            if (mTimelineItemList.get(position) instanceof TimelineItem && mTimelineItemList.get(position).getType() == Tubeless_ITEM_TYPE) {
                if ((((TimelineItem) mTimelineItemList.get(position)).getCategoryID() == 16) ||
                        (((TimelineItem) mTimelineItemList.get(position)).getCategoryID() == 17) ||
                        (((TimelineItem) mTimelineItemList.get(position)).getCategoryID() == 18)) {
                    Yafte yafte = new Yafte();
                    yafte.prepareYafteItem(mContext, (TimelineItemViewHolder) holder, mTimelineItemList, position); //سرقتی / گمشده / پیدا شده
                }
            }
            setAnimation(holder.itemView, position);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position == mTimelineItemList.size() ? PROGRESS_TYPE : mTimelineItemList.get(position).getType();
    }

    @Override
    public void onViewDetachedFromWindow(final ParentViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
        ((ParentViewHolder)holder).clearAnimation();
    }

    void firstLoadAndRefresh(final Context context){
        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            mTimelineItemList.clear();
            onScrollListener.resetCounter();
            Handler mHandler = new Handler();
            mHandler.postDelayed(() -> mSwipeRefreshLayout.setRefreshing(false), 500);
            loadTimeline(context,1,true);
        });
        loadTimeline(context,1,false);
    }

    private void loadTimeline(Context context,int current_page,boolean isRefresh) {
        Global.apiManagerTubeless.getTimeline(current_page - 1,new TubelessRetrofitCallback<Object>(context, null, true, null, new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Gson gson = new Gson();
                JsonElement jsonElement = gson.toJsonTree(response.body());
                TimelineListResponse responseX = gson.fromJson(jsonElement.getAsString(), TimelineListResponse.class);


                for (TimelineItem item : responseX.getTimelineList()){
                    item.setType(Tubeless_ITEM_TYPE);
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
}