package ir.sajjadyosefi.evaluation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.activity.business.SearchResultActivity;
import ir.sajjadyosefi.evaluation.classes.model.responses.SearchResult;
import ir.sajjadyosefi.evaluation.classes.utility.CommonClass;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.RecyclerView.Adapter;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.BlogItemViewHolder> {


    private final View mRootView;
    private final Context mContext;
    public int lastPosition;

//    //scroll
//    private int previousTotal = 0;
//    private boolean loading = true;
//    private int visibleThreshold = 5;
//    int firstVisibleItem, visibleItemCount, totalItemCount;

    public SearchResultAdapter(final Context context, View rootView) {
        mContext = context;
        mRootView = rootView;
    }


    void sssss(final RecyclerView recyclerViewTimeline, final Context context){

        /////////////////////////////////////////////// Scroll //////////////////////////////////////
//        recyclerViewTimeline.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//
//                if(mLayoutManager != null) {
//                    visibleItemCount = recyclerViewTimeline.getChildCount();
//                    totalItemCount = mLayoutManager.getItemCount();
//                    firstVisibleItem = mLayoutManager.findFirstVisibleItemPosition();
//
//                    if (loading) {
//                        if (totalItemCount > previousTotal) {
//                            loading = false;
//                            previousTotal = totalItemCount;
//                        }
//                    }
//                    if (!loading && (totalItemCount - visibleItemCount)
//                            <= (firstVisibleItem + visibleThreshold)) {
//                        // End has been reached
//
//                        Log.i("Yaeye!", "end called");
//
//                        // Do something
//
//                        new AsyncLoadBlogItemList(
//                                context,
//                                mProgressBar,
//                                mTextViewNoting,
//                                mSwipeRefreshLayout,
//                                mRecyclerViewTimeline,
//                                mTimelineItemList,
//                                adapter,
//                                listType,
//                                idHeader
//                                ).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//                        loading = true;
//
//                    }
//
//                    Log.e("Sjd","  visibleItemCount :  " + visibleItemCount  );
//                    Log.e("Sjd","  totalItemCount :  " + totalItemCount  );
//                    Log.e("Sjd","  firstVisibleItem :  " + firstVisibleItem  );
//                    Log.e("Sjd","  previousTotal :  " + previousTotal  );
//                    Log.e("Sjd","  visibleThreshold :  " + visibleThreshold  );
//                    Log.e("Sjd","  loading :  " + loading  );
//                    Log.e("Sjd"," ___________________________________________ " );
//                }
//            }
//        });
        ///////////////////////////////////////////////End Scroll //////////////////////////////////////

        if (CommonClass.isNetworkConnected(context)) {
//            new AsyncLoadBlogItemList(
//                    context,
//                    mProgressBar,
//                    mTextViewNoting,
//                    mSwipeRefreshLayout,
//                    mRecyclerViewTimeline,
//                    mTimelineItemList,
//                    adapter,
//                    listType,
//                    idHeader
//            ).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }else{
//            Global.ShowMessageDialog(context,"",context.getString(R.string.errorInInternetConnection));
        }
    }




    public class ParentViewHolder extends RecyclerView.ViewHolder {

        public ParentViewHolder(View itemView) {
            super(itemView);
        }

        public void clearAnimation() {
            itemView.clearAnimation();
        }
    }

    public class BlogItemViewHolder extends ParentViewHolder {

        public TextView textViewTitle;
        public TextView textViewName;
        public TextView textViewStatment;
        public TextView textViewStatment2;

        public BlogItemViewHolder(View itemView) {
            super(itemView);
            textViewName              = (TextView) itemView.findViewById(R.id.textViewName);
            textViewTitle                 = (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewStatment              = (TextView) itemView.findViewById(R.id.textViewStatment);
            textViewStatment2             = (TextView) itemView.findViewById(R.id.textViewStatment2);
        }
    }


    @Override
    public void onViewDetachedFromWindow(final BlogItemViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
        ((ParentViewHolder)holder).clearAnimation();
    }


    @Override
    public int getItemCount() {
        return SearchResultActivity.searchResponse.size();
    }

    @Override
    public BlogItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout._row_of_search_result_item, parent, false);
        BlogItemViewHolder yafteItemViewHolder = new BlogItemViewHolder(view);
        return yafteItemViewHolder;
    }


    @Override
    public void onBindViewHolder(final BlogItemViewHolder holder, final int position) {

        SearchResult searchResult = new SearchResult();
        //searchResult.prepareBlogItem(mContext,mRootView,SearchResultActivity.searchResponse,holder, position); //blog
        setAnimation(holder.itemView, position);
    }



    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
//        if (position > lastPosition)
//        {
            //Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
//            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.slide_in_left_timeline);
//            viewToAnimate.startAnimation(animation);
        lastPosition = position;
//        }
    }


}