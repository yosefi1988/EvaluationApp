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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
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
import ir.sajjadyosefi.evaluation.activity.evaluation.CommentActivity;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.AbfaxSelectsObject;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.UsageListItem;
import ir.sajjadyosefi.evaluation.model.business.File;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.TODO;


public class StepOneActivity extends TubelessActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {


    private static final String TAG = "sssssssssssssss";
    private int RC_SIGN_IN = 1000;



    RecyclerView                    mRecyclerViewTimeline;
    EndlessList_Adapter             adapter_Posts;
    LinearLayoutManager             mLayoutManager;
    List<TubelessObject>            requestCountItemList = new ArrayList<TubelessObject>();


    Button ButtonSms,ButtonCall,buttonk,buttonBack,buttonNext;
    TextView textView4,textView3,textView2,textView1;

    Activity activity ;
    String LastFileSelected = null;

    RadioButton radioButton1,radioButton2,radioButton3,radioButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_step_one);
        setRootActivity((ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));

        buttonNext = findViewById(R.id.buttonNext);
        buttonBack = findViewById(R.id.buttonBack);

        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);


        radioButton1.setOnCheckedChangeListener(this);
        radioButton2.setOnCheckedChangeListener(this);
        radioButton3.setOnCheckedChangeListener(this);
        radioButton4.setOnCheckedChangeListener(this);

        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);



        //type 5
        if (Global.allSelects != null) {
            for (AbfaxSelectsObject item : Global.allSelects.getObject()) {
                if (item.getType() == 5) {
                    AbfaxSelectsObject sss = new AbfaxSelectsObject("- " + item.getTextValue(), item.getKeyValue());
                    sss.setType(TODO);
                    requestCountItemList.add(sss);
                }
            }
            prepareList(getRootActivity());
        }






//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build();




//        final GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

//        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
//        updateUI(account);

// Set the dimensions of the sign-in button.
//        SignInButton signInButton = findViewById(R.id.sign_in_button);
//        signInButton.setSize(SignInButton.SIZE_STANDARD);
//
//        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
//                startActivityForResult(signInIntent, RC_SIGN_IN);
//            }
//        });


//
//        intent.putExtra(AccountManager.KEY_ACCOUNT_TYPE, accountType);
//        intent.putExtra(ADD_ACCOUNT, true);
//        intent.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response);
//                bundle.putParcelable(AccountManager.KEY_INTENT, intent);



        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SubscriptionsActivity

                if (radioButton4.isChecked() == true || radioButton2.isChecked() == true || radioButton3.isChecked() == true ){
                    //اخرین صفحه
                    Intent intent = new Intent(getContext(), CommentActivity.class);
                    intent.putExtra("backType" , "stepOne");
                    activity.startActivity(intent);
                    finish();
                }else if (radioButton1.isChecked() == true ) {
                    activity.startActivity(new Intent(getContext(), SubscriptionsActivity.class));
                    finish();
                }else {
                    Toast.makeText(getContext(),"یکی از موارد را انتخاب کنید",Toast.LENGTH_LONG).show();
                }
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(getContext(),DetailsActivity.class));
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

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b == true) {
            if (compoundButton == radioButton1) {
                radioButton1.setChecked(b);
                radioButton2.setChecked(!b);
                radioButton3.setChecked(!b);
                radioButton4.setChecked(!b);
                adapter_Posts.enable = false;
            } else if (compoundButton == radioButton2) {
                radioButton1.setChecked(!b);
                radioButton2.setChecked(b);
                radioButton3.setChecked(!b);
                radioButton4.setChecked(!b);
                adapter_Posts.enable = false;
            }else if (compoundButton == radioButton3) {
                radioButton1.setChecked(!b);
                radioButton2.setChecked(!b);
                radioButton3.setChecked(b);
                radioButton4.setChecked(!b);
                adapter_Posts.enable = true;
            }else if (compoundButton == radioButton4) {
                radioButton1.setChecked(!b);
                radioButton2.setChecked(!b);
                radioButton3.setChecked(!b);
                radioButton4.setChecked(b);
                adapter_Posts.enable = false;
            }
        }
        adapter_Posts.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        if (view == textView1) {
            radioButton1.setChecked(true);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
            radioButton4.setChecked(false);
            adapter_Posts.enable = false;

        } else if (view == textView2) {
            radioButton1.setChecked(false);
            radioButton2.setChecked(true);
            radioButton3.setChecked(false);
            radioButton4.setChecked(false);
            adapter_Posts.enable = false;

        }else if (view == textView3) {
            radioButton1.setChecked(false);
            radioButton2.setChecked(false);
            radioButton3.setChecked(true);
            radioButton4.setChecked(false);
            adapter_Posts.enable = true;
        }else if (view == textView4) {
            radioButton1.setChecked(false);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
            radioButton4.setChecked(true);
            adapter_Posts.enable = false;
        }
        adapter_Posts.notifyDataSetChanged();
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
                requestCountItemList);
        adapter_Posts.listType = TODO;
        adapter_Posts.enable = false;
        mRecyclerViewTimeline.setLayoutManager(mLayoutManager);
        mRecyclerViewTimeline.setAdapter(adapter_Posts);

    }

}
