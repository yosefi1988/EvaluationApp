package ir.sajjadyosefi.evaluation.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.OldSubscribeListItem;

import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.SUBSCRIPTIONS;

public class CustomDialogClass extends Dialog implements View.OnClickListener {

    public Activity c;
    public Dialog d;
    public EditText editTextCode, editTextValue;
    public Button buttonSave,buttonCancel;
    public static OldSubscribeListItem subscribeItem = null;

    public CustomDialogClass(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        editTextCode = (EditText) findViewById(R.id.editTextCode);
        editTextValue = (EditText) findViewById(R.id.editTextValue);
        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(this);
        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSave:
                subscribeItem = new OldSubscribeListItem();
                subscribeItem.setSubscriberCode(Integer.parseInt(editTextCode.getText().toString()));
                subscribeItem.setTblRequestSubscriberId(Integer.parseInt(editTextValue.getText().toString()));
                subscribeItem.setType(SUBSCRIPTIONS);
                dismiss();
                break;
            case R.id.buttonCancel:
                subscribeItem = null;
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }

}
