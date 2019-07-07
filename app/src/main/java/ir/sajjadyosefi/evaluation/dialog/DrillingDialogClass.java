package ir.sajjadyosefi.evaluation.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.refactor.kmpautotextview.ItemData;
import cn.refactor.kmpautotextview.KMPAutoComplTextView;
import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.AbfaxSelectsObject;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.DrillingListItem;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;

public class DrillingDialogClass extends Dialog implements View.OnClickListener {

    private int DRILLING_TYPE = 0;
    private final View rootActivity;
    public Activity c;
    public Dialog d;
//    public EditText editTextCode, editTextValue;
    public Button buttonSave,buttonCancel;
    public static DrillingListItem newItem = null;
    public EditText editTextValue;

    List<TubelessObject> requestCountItemList = new ArrayList<TubelessObject>();
    KMPAutoComplTextView complTextView;

    public DrillingDialogClass(Activity a, View rootActivity, int drilling) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
        this.rootActivity = rootActivity ;
        this.DRILLING_TYPE = drilling;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.drilling_dialog);

//        editTextCode = (EditText) findViewById(R.id.editTextCode);
//        editTextValue = (EditText) findViewById(R.id.editTextValue);

        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(this);
        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        editTextValue = (EditText) findViewById(R.id.editTextValue);
        buttonCancel.setOnClickListener(this);


        complTextView = (KMPAutoComplTextView) findViewById(R.id.tvAutoCompl);

        //type 7
        ArrayList<ItemData> list3 = new ArrayList<>();

        for (AbfaxSelectsObject item: Global.allSelects.getObject()) {
            if (item.getType() == 7) {
                ItemData sss = new ItemData("- " + item.getTextValue(), item.getKeyValue() + "", item.getType() + "");
                list3.add(sss);
            }
        }
        complTextView.setDatas(list3);
        complTextView.setOnPopupItemClickListener(new KMPAutoComplTextView.OnPopupItemClickListener() {
            @Override
            public void onPopupItemClick(ItemData itemData) {
                Toast.makeText(getContext(), itemData.getText(), Toast.LENGTH_SHORT).show();

                for (ItemData item : list3) {
                    if (item.getText().equals(itemData.getText())){
                        newItem = new DrillingListItem();
                        newItem.setId(item.getMeta());
                        newItem.setText(item.getText());
                    }
                }

            }
        });


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSave:
                if (editTextValue.getText().toString().length() == 0) {
                    Toast.makeText(getContext(), "مقداری وارد نکرده اید", Toast.LENGTH_LONG).show();
                } else {
                    newItem.setValue(editTextValue.getText().toString());
                    //newItem.setType(DRILLING_TYPE);
                    dismiss();
                }
                break;
            case R.id.buttonCancel:

                newItem = null;

                dismiss();
                break;
            default:
                break;
        }
        //dismiss();
    }

}
