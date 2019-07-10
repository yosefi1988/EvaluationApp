package ir.sajjadyosefi.evaluation.activity.business;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

import java.util.List;

public class SearchResultActivity extends TubelessActivity {

    public Context context;
    public static List<TubelessObject> searchResponse;

    RecyclerView recyclerView;
    private LinearLayoutManager mLinearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout._activity_search_result);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mLinearLayoutManager = new LinearLayoutManager(getContext());

        setRootActivity((ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));
        if (searchResponse != null) {

//            RecyclerView.Adapter searchResultAdapter = new SearchResultAdapter(context,getRootActivity());
            RecyclerView.Adapter adapter_Posts = new EndlessList_Adapter(
                    getContext(),
                    mLinearLayoutManager,
                    getRootActivity(),
                    true,
                    searchResponse);

            recyclerView.setLayoutManager(mLinearLayoutManager);
            recyclerView.setAdapter(adapter_Posts);
            adapter_Posts.notifyDataSetChanged();
        }



    }
}
