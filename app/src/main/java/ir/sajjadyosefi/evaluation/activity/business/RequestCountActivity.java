package ir.sajjadyosefi.evaluation.activity.business;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.UsageListItem;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.COUNT_REQUEST;
import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.COUNT_REQUEST_EDITED;


public class RequestCountActivity extends TubelessActivity {


    private static final String TAG = "sssssssssssssss";
    private int RC_SIGN_IN = 1000;


    RecyclerView                    mRecyclerViewTimeline;
    EndlessList_Adapter             adapter_Posts;
    LinearLayoutManager             mLayoutManager;
    List<TubelessObject>            requestCountItemList = new ArrayList<TubelessObject>();


    Button ButtonSms,ButtonCall,buttonk,buttonBack,buttonNext;
    TextView textViewNameFamily1,TextViewSerial,textViewDate,textViewNameFamily2,textViewMobile,TextViewCodePosti,TextViewAddress;

    Activity activity ;
    String LastFileSelected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_request_count);
        setRootActivity((ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));

        buttonNext = findViewById(R.id.buttonNext);
        buttonBack = findViewById(R.id.buttonBack);







        if (Global.CurrentTask != null) {
            for (UsageListItem usageListItem : Global.CurrentTask.getUsageList()) {
                usageListItem.type = COUNT_REQUEST;
                requestCountItemList.add(usageListItem);
            }
        }
        prepareList(getRootActivity());




        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(getContext(), NetworkActivity.class));
                finish();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(getContext(), SubscriptionsActivity.class));
                finish();
            }
        });
    }



//    private void accounts() {
//        SAccounts sAccounts = new SAccounts(getContext());
////        sAccounts.getAccountManager().addAccount()
//
//        final Account account = new Account("accountName", "ir.sajjadyosefi.evaluation") ;
//        sAccounts.getAccountManager().addAccountExplicitly(account, "accountPassword",null);
//
//        AccountAuthenticator accountAuthenticator = new AccountAuthenticator(getContext());
////        accountAuthenticator.addAccount();
////        accountAuthenticator.
//    }


    private void prepareList(View rootview) {
        mRecyclerViewTimeline           = (RecyclerView) rootview.findViewById(R.id.recyclerView);
        mRecyclerViewTimeline.setHasFixedSize(true);
        mRecyclerViewTimeline.setItemAnimator(new DefaultItemAnimator());
        mLayoutManager = new LinearLayoutManager(getContext());
        adapter_Posts = new EndlessList_Adapter(
                getContext(),
                mLayoutManager,
                rootview,
                requestCountItemList);
        adapter_Posts.listType = COUNT_REQUEST_EDITED;
        mRecyclerViewTimeline.setLayoutManager(mLayoutManager);
        mRecyclerViewTimeline.setAdapter(adapter_Posts);

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("result");
                int indexxx = data.getIntExtra("index", 0);

                Gson gson = new Gson();
                UsageListItem item = gson.fromJson(result, UsageListItem.class);

                ((UsageListItem) requestCountItemList.get(indexxx)).setEdited(true);
                ((UsageListItem) requestCountItemList.get(indexxx)).setNeedSeparationReq2(item.getNeedSeparationReq2());
                ((UsageListItem) requestCountItemList.get(indexxx)).setType(COUNT_REQUEST_EDITED);
                ((UsageListItem) requestCountItemList.get(indexxx)).setWaterMainUnitQtyReq2(item.getWaterMainUnitQtyReq2());

                adapter_Posts.notifyItemChanged(indexxx);
            }
        }
    }


    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
//            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
//            updateUI(null);
        }
    }
}
