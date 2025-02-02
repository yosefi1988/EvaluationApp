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
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

import cn.refactor.kmpautotextview.ItemData;
import cn.refactor.kmpautotextview.KMPAutoComplTextView;
import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.NetworkAndBranch.OldSubscribe;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.SUBSCRIPTIONS;


public class SubscriptionsActivity extends TubelessActivity {


    private static final String TAG = "sssssssssssssss";
    private int RC_SIGN_IN = 1000;



    KMPAutoComplTextView complTextView;

    RecyclerView                    mRecyclerViewTimeline;
    EndlessList_Adapter             adapter_Posts;
    LinearLayoutManager             mLayoutManager;
    List<TubelessObject>            subscribeItemList = new ArrayList<TubelessObject>();


    Button ButtonSms,ButtonCall,buttonk,buttonBack,buttonNext;
    TextView textViewNameFamily1,TextViewSerial,textViewDate,textViewNameFamily2,textViewMobile,TextViewCodePosti,TextViewAddress;

    Activity activity ;
    String LastFileSelected = null;
    ArrayList<ItemData> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_subscriptions);
        setRootActivity((ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));

        buttonNext = findViewById(R.id.buttonNext);
        buttonBack = findViewById(R.id.buttonBack);
        complTextView = (KMPAutoComplTextView) findViewById(R.id.tvAutoCompl);


        //type موقت
        if (Global.CurrentTask == null ){

        }else {

            ItemData sss = new ItemData("- موقت",  "1","");
            list.add(sss);

            ItemData sss1 = new ItemData("- دائم",  "2","");
            list.add(sss1);

            ItemData sss2 = new ItemData("- موقت به دائم" , "3","");
            list.add(sss2);

            complTextView.setDatas(list);

            complTextView.setOnPopupItemClickListener(new KMPAutoComplTextView.OnPopupItemClickListener() {
                @Override
                public void onPopupItemClick(ItemData itemData) {
                    Toast.makeText(getBaseContext(), itemData.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }






        for (OldSubscribe subscribeItem : Global.CurrentTask.getOldSubscribeList()) {
            subscribeItem.type = SUBSCRIPTIONS;
            subscribeItemList.add(subscribeItem);
        }

        prepareList(getRootActivity());




        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //RequestCountActivity





                boolean valid = true;
                boolean innerValid = false;

                for (ItemData item : list) {
                    if (item.getText().equals(complTextView.getText().toString())){
                        innerValid = true;
                        Global.CurrentTask.typeOfAssignment = item;
                    }
                }
                if (innerValid == false){
                    valid = false;
                }

                if (complTextView.getText().length() < 5){
                    Toast.makeText(getContext(),"نوع واگذاری را انتخاب کنید" ,Toast.LENGTH_LONG).show();
                    valid = false;
                }


                if (valid){
                    Global.CurrentTask.getOldSubscribeList().clear();
                    for (TubelessObject item : subscribeItemList) {
                        Global.CurrentTask.getOldSubscribeList().add((OldSubscribe) item);
                    }


                    activity.startActivity(new Intent(getContext(), RequestCountActivity.class));
                    finish();
                }
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(getContext(), StepOneActivity.class));
                finish();
            }
        });

    }



    private void prepareList(View rootview) {
        mRecyclerViewTimeline           = (RecyclerView) rootview.findViewById(R.id.recyclerView);
        mRecyclerViewTimeline.setHasFixedSize(true);
        mRecyclerViewTimeline.setItemAnimator(new DefaultItemAnimator());
        mLayoutManager = new LinearLayoutManager(getContext());
        adapter_Posts = new EndlessList_Adapter(
                getContext(),
                mLayoutManager,
                rootview,
                true,
                subscribeItemList);
        adapter_Posts.listType = SUBSCRIPTIONS;
        mRecyclerViewTimeline.setLayoutManager(mLayoutManager);
        mRecyclerViewTimeline.setAdapter(adapter_Posts);

    }

    @Override
    protected void onStart() {
        super.onStart();


        if (Global.CurrentTask.typeOfAssignment != null){
            complTextView.edit = true;
            complTextView.setText(Global.CurrentTask.typeOfAssignment.getText().toString());
            complTextView.edit = false;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
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
