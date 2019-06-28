package ir.sajjadyosefi.evaluation.activity.evaluation;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.DrillingListItem;
import ir.sajjadyosefi.evaluation.dialog.DrillingDialogClass;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.DRILLING;
import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.DRILLING_A;
import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.DRILLING_F;


public class DrillingListActivity extends TubelessActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {


    private static final String TAG = "sssssssssssssss";
    private int RC_SIGN_IN = 1000;


    RecyclerView                    mRecyclerViewTimeline;
    EndlessList_Adapter             adapter_Posts;
    LinearLayoutManager             mLayoutManager;
    List<TubelessObject>            drillingItemList = new ArrayList<TubelessObject>();


    Button button1,button2, buttonBack, buttonNext;
    CheckBox checkBox1 , checkBox2;
    TextView textView1,textView2;

    Activity activity ;
    String LastFileSelected = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_drilling_list);
        setRootActivity((ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));

        buttonNext = findViewById(R.id.buttonNext);
        button1 = findViewById(R.id.button1);
        buttonBack = findViewById(R.id.buttonBack);
        button2 = findViewById(R.id.button2);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);


        TubelessObject usageListItema = new DrillingListItem();
        ((DrillingListItem) usageListItema).setId("10");
        ((DrillingListItem) usageListItema).setValue("10");
        ((DrillingListItem) usageListItema).setText("اسفالت");
        ((DrillingListItem) usageListItema).setType(DRILLING_F);
        drillingItemList.add(usageListItema);

        TubelessObject usageListItem = new DrillingListItem();
        ((DrillingListItem) usageListItem).setId("10");
        ((DrillingListItem) usageListItem).setValue("10");
        ((DrillingListItem) usageListItem).setText("خاکی");
        ((DrillingListItem) usageListItem).setType(DRILLING_A);
        drillingItemList.add(usageListItem);

        prepareList(getRootActivity());


        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DrillingDialogClass cdd = new DrillingDialogClass((Activity) getContext(),getRootActivity(),DRILLING_A);
                cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cdd.show();
                cdd.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (DrillingDialogClass.newItem != null){
                            DrillingDialogClass.newItem.setType(DRILLING_A);
                            drillingItemList.add(DrillingDialogClass.newItem);
                            adapter_Posts.notifyDataSetChanged();
                        }
                    }
                });
            }
        });



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DrillingDialogClass cdd = new DrillingDialogClass((Activity) getContext(),getRootActivity(),DRILLING_F);
                cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cdd.show();
                cdd.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (DrillingDialogClass.newItem != null){
                            DrillingDialogClass.newItem.setType(DRILLING_F);
                            drillingItemList.add(DrillingDialogClass.newItem);
                            adapter_Posts.notifyDataSetChanged();
                        }
                    }
                });
            }
        });


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (drillingItemList.size() == 0){
                    Toast.makeText(getContext(),"موردی برای حفاری وارد نکرده اید",Toast.LENGTH_LONG).show();
                }else {
                    Intent i = new Intent(getContext(), ToDoListActivity.class);
                    (getActivity()).startActivity(i);
                    finish();
                }
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), DrillingActivity.class);
                (getActivity()).startActivity(i);
                finish();
            }
        });

//        if (true){
//            Intent i = new Intent(getContext(), AddNetworkActivity.class);
//            (getActivity()).startActivityForResult(i, 1);
//        }
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
                drillingItemList);
        adapter_Posts.listType = DRILLING;
        mRecyclerViewTimeline.setLayoutManager(mLayoutManager);
        mRecyclerViewTimeline.setAdapter(adapter_Posts);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (compoundButton == checkBox1){
            button1.setEnabled(b);

            if (b == false){
                //remove Ab
                List<TubelessObject> markedList = new ArrayList<>();
                for (TubelessObject item: drillingItemList) {
                    if(item.getType() == DRILLING_A){
                        markedList.add(item);
                    }
                }
                for (TubelessObject item: markedList) {
                    drillingItemList.remove(item);
                }
                adapter_Posts.notifyDataSetChanged();
            }
        }
        if (compoundButton == checkBox2){
            button2.setEnabled(b);
            if (b == false){
                //remove F
                List<TubelessObject> markedList = new ArrayList<>();
                for (TubelessObject item: drillingItemList) {
                    if(item.getType() == DRILLING_F){
                        markedList.add(item);
                    }
                }
                for (TubelessObject item: markedList) {
                    drillingItemList.remove(item);
                }
                adapter_Posts.notifyDataSetChanged();
            }
        }


    }

    @Override
    public void onClick(View view) {
        if (view == textView1){
            checkBox1.toggle();
        }

        if (view == textView2){
            checkBox2.toggle();
        }
    }
}
