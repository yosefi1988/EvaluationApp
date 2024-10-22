package ir.sajjadyosefi.evaluation.activity.business;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import cn.refactor.kmpautotextview.ItemData;
import cn.refactor.kmpautotextview.KMPAutoComplTextView;
import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.activity.MainActivity;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.Content;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.UsageListItem;
import ir.sajjadyosefi.evaluation.model.business.File;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.FILES;
import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.TASKS;
import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.TODO;
import static ir.sajjadyosefi.evaluation.model.business.File.MAP_1;
import static ir.sajjadyosefi.evaluation.model.business.File.MAP_K;

public class DetailsActivity extends TubelessActivity {


    private static final String TAG = "sssssssssssssss";
    private int RC_SIGN_IN = 1000;


    RecyclerView                    mRecyclerViewTimeline;
    EndlessList_Adapter             adapter_Posts;
    LinearLayoutManager             mLayoutManager;
    List<TubelessObject>            taskItemList = new ArrayList<TubelessObject>();


    Button ButtonSms,ButtonCall,buttonk,buttonBack,buttonStart;
    TextView textViewNameFamily1,TextViewSerial,textViewDate,textViewNameFamily2,textViewMobile,TextViewCodePosti,TextViewAddress;

    Activity activity ;
    String LastFileSelected = null;

    public static ImageView ImageView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_details);
        setRootActivity((ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));


        buttonStart = findViewById(R.id.buttonStart);
        buttonBack = findViewById(R.id.buttonBack);
        textViewNameFamily1 = findViewById(R.id.textViewNameFamily1);
        TextViewSerial = findViewById(R.id.TextViewSerial);
        textViewDate = findViewById(R.id.textViewDate);
        textViewNameFamily2 = findViewById(R.id.textViewNameFamily2);
        textViewMobile = findViewById(R.id.textViewMobile);
        TextViewCodePosti = findViewById(R.id.TextViewCodePosti);
        TextViewAddress = findViewById(R.id.TextViewAddress);
        ImageView = findViewById(R.id.ImageView);
        ButtonSms = findViewById(R.id.ButtonSms);
        ButtonCall = findViewById(R.id.ButtonCall);
        buttonk = findViewById(R.id.buttonk);

        fillWigets();


        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(getContext(),StepOneActivity.class));
                finish();
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //activity.startActivity(new Intent(getContext(),MainActivity.class));
                finish();
            }
        });
    }

    private void fillWigets() {
        textViewNameFamily1.setText(Global.CurrentTask.getLastName());
        TextViewSerial.setText(Global.CurrentTask.getSerialRequestCode());
        textViewDate.setText(Global.CurrentTask.getTaskDate());
        textViewNameFamily2.setText(Global.CurrentTask.getLastName());
        textViewMobile.setText(Global.CurrentTask.getCellPhone());
        TextViewCodePosti.setText(Global.CurrentTask.getPostalCode());
        TextViewAddress.setText(Global.CurrentTask.getAddress());

        buttonk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //xxxxxxxxxxxxxx
            }
        });

        ButtonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + Global.CurrentTask.getCellPhone()));
                (getContext()).startActivity(intent);
            }
        });
        ButtonSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = Global.CurrentTask.getCellPhone();  // The number on which you want to send SMS
                (getContext()).startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));
            }
        });

        //file
        filltestFile(getRootActivity());
    }

    private void filltestFile(View rootview) {
        //Global.CurrentTask.files



        for (Content file: Global.CurrentTask.getContentList()) {
//            if (file.getDownloadEarly()==1){
//                File kroki = new File();
//                kroki.setTitle(file.getDescription());
//                kroki.setRequestContentId(file.getRequestContentId());
//                kroki.setFrame(file.getFrame());
//                kroki.setFileType(MAP_K);
//                kroki.setType(FILES);
//                Global.CurrentTask.setFileKrocki(kroki);
//            }else {
                File map1 = new File();
                map1.setTitle(file.getDescription());
                map1.setRequestContentId(file.getRequestContentId());
                map1.setFrame(file.getFrame());
                map1.setFileType(MAP_1);
                map1.setType(FILES);
                taskItemList.add(map1);
//            }
        }


        mRecyclerViewTimeline           = (RecyclerView) rootview.findViewById(R.id.recyclerView);
        mRecyclerViewTimeline.setHasFixedSize(true);
        mRecyclerViewTimeline.setItemAnimator(new DefaultItemAnimator());
        mLayoutManager = new LinearLayoutManager(getContext());
        adapter_Posts = new EndlessList_Adapter(
                getContext(),
                mLayoutManager,
                rootview,
                taskItemList,
                FILES,
                false);
        adapter_Posts.listType = FILES;
        mRecyclerViewTimeline.setLayoutManager(mLayoutManager);
        mRecyclerViewTimeline.setAdapter(adapter_Posts);


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
