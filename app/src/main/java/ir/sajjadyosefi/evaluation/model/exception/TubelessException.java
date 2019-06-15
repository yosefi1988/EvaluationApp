package ir.sajjadyosefi.evaluation.model.exception;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.classes.model.responses.basic.ServerResponseBase;

public class TubelessException extends Exception{

    public static final int NATIONAL_CODE_NOT_TRUE = 1001;
    public static final int NAME_NOT_TRUE = 1002;
    public static final int FAMILY_NOT_TRUE = 1003;
    public static final int FATHER_NOT_TRUE = 1004;


    private String message;
    private int code;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    // Overrides Exception's getMessage()
    @Override
    public String getMessage(){
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public TubelessException() {

    }

    @Override
    public void printStackTrace() {
//        super.printStackTrace();
//        System.out.println(getMessage());
//        Log.w("myApp", getMessage());
        Log.e("tYafte", getMessage());
    }



    public TubelessException(int errorCode) {
        switch (errorCode){
            case 0:{
                message = "ssssssssssssssss";
                //log

                break;
            }
            case NATIONAL_CODE_NOT_TRUE:{
                message = "sajjad Error : National Code Not true.";
                break;
            }

            default:{
                message = "sajjad Error";
            }
        }
        code = errorCode;
    }

    public void handleServerMessage(Context mContext, View view, ServerResponseBase responseX) {
        try {
            assert view == null;
            assert mContext == null;

            int resID = mContext.getResources().getIdentifier("error_message_" + responseX.getTubelessException().getCode(), "string", mContext.getPackageName());
            if (resID == 0) {
                Snackbar.make(view, responseX.getTubelessException().message , Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(view, resID, Snackbar.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        if (responseX != null) {
            handleServerMessage(mContext,view,responseX.getTubelessException().getCode());
        }else {
//            Toast.makeText(context, context.getResources().getString(R.string.server_not_response), Toast.LENGTH_SHORT).show();

            if (view != null) {
                Snackbar.make(view, mContext.getResources().getString(R.string.server_not_response), Snackbar.LENGTH_SHORT).show();
            }
        }

    }

    public static void handleServerMessage(Context mContext, View view, int code) {
        try {
            int resID = mContext.getResources().getIdentifier("error_message_" + code, "string", mContext.getPackageName());
            Snackbar.make(view, resID, Snackbar.LENGTH_SHORT).show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void handleClientMessage(Context mContext, View view, int code) {
//        if (mContext != null) {
//            SamanToast samanToast = null;
//            samanToast = new SamanToast(mContext,mContext.getString(R.string.error_text_entered_valuse_not_valid), SamanToast.ERROR);
//            samanToast.show();
//        }

        try {
            int resID = mContext.getResources().getIdentifier("error_message_" + code, "string", mContext.getPackageName());
            Snackbar.make(view, resID, Snackbar.LENGTH_SHORT).show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void ShowSheetDialog(Context context, BottomSheetDialog dialog, View.OnClickListener onClickListener) {
        try {
            View view = ((Activity) context).getLayoutInflater().inflate(R.layout.bottom_sheet_dialog_connection_lost, null);
            dialog.setContentView(view);
            Button buttonTryAgain = view.findViewById(R.id.buttonTryAgain);
            buttonTryAgain.setOnClickListener(onClickListener);
            dialog.show();
        }catch (Exception ex){

        }
    }


}