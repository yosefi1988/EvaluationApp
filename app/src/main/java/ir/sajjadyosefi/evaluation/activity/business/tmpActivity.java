package ir.sajjadyosefi.evaluation.activity.business;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import com.bluehomestudio.progresswindow.ProgressWindow;
import com.bluehomestudio.progresswindow.ProgressWindowConfiguration;
import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.TopWindowService;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.model.request.SearchRequest;
import ir.sajjadyosefi.evaluation.classes.utility.CommonClass;

public class tmpActivity extends TubelessActivity {


    //val
    EditText editTextNationalCode;
    private ProgressWindow progressWindow ;
    String searchType = "-1";




    private static ProgressWindow instance = null;
    private Context mContext;

    private WindowManager windowManager;
    private WindowManager.LayoutParams layoutParams;
    private View progressLayout;
    private boolean isAttached ;
    private View mainProgress;
    private LinearLayout mainLayout;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search_by_national_code);
//        progressConfigurations();
//        progressWindow.showProgress();


        editTextNationalCode = (EditText) findViewById(R.id.editTextNationalCode);

        /////////////////////////////////////////////////////////////////////////////////////

//        DisplayMetrics metrics = new DisplayMetrics();
//        windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
//        windowManager.getDefaultDisplay().getMetrics(metrics);
//        progressLayout = LayoutInflater.from(getContext()).inflate(com.bluehomestudio.progresswindow.R.layout.view_progress_window, null);
//
//        progressLayout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
//            @Override
//            public void onViewAttachedToWindow(View v) {
//                isAttached = true ;
//            }
//
//            @Override
//            public void onViewDetachedFromWindow(View v) {
//                isAttached = false ;
//            }
//        });
//
//        mainProgress = progressLayout.findViewById(com.bluehomestudio.progresswindow.R.id.pb_main_progress);
//        mainProgress.getIndeterminateDrawable().setColorFilter(Color.WHITE, android.graphics.PorterDuff.Mode.MULTIPLY);
//
//        mainLayout = progressLayout.findViewById(com.bluehomestudio.progresswindow.R.id.ll_main_layout);
//        mainLayout.setBackgroundColor(Color.TRANSPARENT);
//
//        layoutParams = new WindowManager.LayoutParams(
//                metrics.widthPixels, metrics.heightPixels,
//                WindowManager.LayoutParams.TYPE_TOAST,
//                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
//                PixelFormat.TRANSLUCENT
//        );
//        layoutParams.gravity = Gravity.CENTER;
//
//        windowManager.addView(progressLayout, layoutParams);




        //overlayer 1
        Intent show = new Intent(this, TopWindowService.class);
        show.putExtra(TopWindowService.OPERATION,
                TopWindowService.OPERATION_SHOW);
        startService(show);


        //over layer 2

        CommonClass.getBalanse(getContext(),"ssss");



        ///over layoer 3

        //set up dialog
        setProgressDialog();


        //////////////////////////////////////////////////////////////////////////////////

        ((Button)findViewById(R.id.button_search)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editTextNationalCode.getText().toString().length() == 10){
                    SearchRequest searchRequest = new SearchRequest(editTextNationalCode.getText().toString(),searchType);
//                    dilatingDotsProgressBar.setVisibility(View.VISIBLE);

//                    Global.apiManagerPost.createUser(searchRequest, new Callback<SearchResponse>() {
//                        @Override
//                        public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
////                            dilatingDotsProgressBar.setVisibility(View.GONE);
//                            SearchResponse responseUser = response.body();
//                            if (response.isSuccessful() && responseUser != null) {
//                                if (response.body().getType().equals("NoResult")){
//                                    //showDialogNotfound();
//                                }else {
//
//                                    SearchResultActivity.searchResponse = response.body().getData();
//                                    Intent intent = new Intent(getContext(), SearchResultActivity.class);
//                                    Bundle bundle = new Bundle();
////                                    bundle.putInt(ContactUsActivity.Type, 16);
//                                    intent.putExtras(bundle);
//                                    startActivity(intent);
////                                    getActivity().overridePendingTransition(R.anim.fadeout, R.anim.fadein);
//                                }
//                            } else {
//                                Toast.makeText(getActivity(),
//                                        String.format("Response is %s", String.valueOf(response.message()))
//                                        , Toast.LENGTH_LONG).show();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<SearchResponse> call, Throwable t) {
//                            Toast.makeText(getActivity(),
//                                    String.format("Response is %s",t.getMessage().toString())
//                                    , Toast.LENGTH_LONG).show();
//                        }
//                    });
                }else {
                    Toast.makeText(getContext(),getContext().getResources().getString(R.string.inputError),Toast.LENGTH_SHORT).show();

                }



//                if (editTextNationalCode.getText().toString().length() >= 3 ){
//                    SearchRequest search = new SearchRequest(editText_name.getText().toString(), editText_family.getText().toString(), editText_father_name.getText().toString(),searchType);
//                    dilatingDotsProgressBar.setVisibility(View.VISIBLE);
//
//                    Global.apiManagerPost.createUser(search, new Callback<SearchResponse>() {
//                        @Override
//                        public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
//                            dilatingDotsProgressBar.setVisibility(View.GONE);
//                            SearchResponse responseUser = response.body();
//                            if (response.isSuccessful() && responseUser != null) {
//                                if (response.body().getType().equals("NoResult")){
//                                    showDialogNotfound();
//                                }else {
//                                    SearchResultActivity.searchResponse = response.body().getData();
//                                    Intent intent = new Intent(context, SearchResultActivity.class);
//                                    Bundle bundle = new Bundle();
//                                    bundle.putInt(ContactUsActivity.Type, 16);
//                                    intent.putExtras(bundle);
//                                    startActivity(intent);
//                                    ((Activity) context).overridePendingTransition(R.anim.fadeout, R.anim.fadein);
//                                }
//                            } else {
//                                Toast.makeText(SearchActivity.this,
//                                        String.format("Response is %s", String.valueOf(response.message()))
//                                        , Toast.LENGTH_LONG).show();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<SearchResponse> call, Throwable t) {
//                            Toast.makeText(SearchActivity.this,
//                                    String.format("Response is %s",t.getMessage().toString())
//                                    , Toast.LENGTH_LONG).show();
//                        }
//                    });
//
//
//                }else {
//                    Toast.makeText(context,context.getResources().getString(R.string.inputError),Toast.LENGTH_SHORT).show();
//                }



            }
        });


    }

    private void setUpDialog() {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.maindialog);
        dialog.setTitle("This is my custom dialog box");
        dialog.setCancelable(true);
        //there are a lot of settings, for dialog, check them all out!

        //set up text
        TextView text = (TextView) dialog.findViewById(R.id.TextView01);
        text.setText(R.string.searchText);

        //set up image view
        ImageView img = (ImageView) dialog.findViewById(R.id.ImageView01);
        img.setImageResource(R.drawable.eyyarth);

        //set up button
        Button button = (Button) dialog.findViewById(R.id.Button01);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //now that the dialog is set up, it's time to show it
        dialog.show();
    }
    private void setProgressDialog() {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.main_progress);
        dialog.setCancelable(true);
        //there are a lot of settings, for dialog, check them all out!

//        dialog.getWindow().getDecorView().getBackground().setColorFilter(new LightingColorFilter(0x00000000, 0x00ffffff));

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        dialog.show();
    }


    private void progressConfigurations(){
        progressWindow = ProgressWindow.getInstance(this);
        ProgressWindowConfiguration progressWindowConfiguration = new ProgressWindowConfiguration();
        progressWindowConfiguration.backgroundColor = Color.parseColor("#32000000") ;
        progressWindowConfiguration.progressColor = Color.WHITE ;
        progressWindow.setConfiguration(progressWindowConfiguration);
    }

//    private void pay(){
//        /* Prepare a Payment object with custom data.
//            The standard form we recommend is you create a constant value including your merchantID, and for
//            anything you want to sell create a unique payment object (instead of editing your current object times and times)
//            and pass the variable holding merchantID, this helps you edit your merchantID safe and easy anytime you wanted.
//        */
//
//
//
//
//        Payment payment = new PaymentBuilder()
//                .setMerchantID("e8a913e8-f089-11e6-8dec-005056a205be")  //  This is an example, put your own merchantID here.
//                .setAmount(Integer.parseInt(context.getString(R.string.app_price))   )                                     //  In Toman
//                .setDescription(discription.getText().toString() +
//                        "+app_id:" + context.getString(R.string.app_id)+
//                        "+androidID" + CommonClass.GetAndroidId(context))
//                .setEmail(email.getText().toString())                     //  This field is not necessary.
//                .setMobile(phone.getText().toString())                               //  This field is not necessary.
//                .create();
//
//        /* Call pay method and pass your considered payment object.
//            Don't call a payment before the last one is finished, if you do the first payment will be destroyed
//            and you may even not receive any callbacks (onSuccess or onFailure)
//        */
//        ZarinPal.pay(this, payment, new OnPaymentListener() {
//            @Override
//            public void onSuccess(String refID) {
//                Toast.makeText(PaymentActivity.this, refID, Toast.LENGTH_LONG).show();
//
//
//                //Log.wtf("TAG", "::ZarinPal::  RefId: " + refID);
//
//                RequestConfirmPayment requestConfirmPayment = new RequestConfirmPayment();
//                requestConfirmPayment.setAndroidID(CommonClass.GetAndroidId(context));
//                requestConfirmPayment.setAppID(context.getString(R.string.app_id));
//                requestConfirmPayment.setRefId(refID);
//                requestConfirmPayment.setPrice(context.getString(R.string.app_price));
//                requestConfirmPayment.setEmail(email.getText().toString());
//                requestConfirmPayment.setPhone(phone.getText().toString());
//
//
//                new AsyncPeymentResult(context, requestConfirmPayment).execute();
//                CommonClass.ShowInternetConnection(context,CommonClass.SHOW_PEYMENT_REF_ID,refID);
//
//
//                textView.setText("پرداخت با موفقیت انجام شد\nکد پیگیری: " + refID);
//
//                //Save
//                AppStatus appStatus;
//                List<AppStatus> appStatusList = AppStatus.listAll(AppStatus.class);
//                if (appStatusList.size() == 0) {
//
//                } else {
//                    appStatus = appStatusList.get(0);
//                    appStatus.buyStatus = "OK";
//                    appStatus.save();
//                }
//                //End Save
//
//
//
//
//                textView.setTextColor(Color.GREEN);
//                btn.setVisibility(View.GONE);
//                btnContiniue.setVisibility(View.VISIBLE);
//                btnContiniue.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        context.startActivity(new Intent(context,Splash_Screen.class));
//                        overridePendingTransition(R.anim.fadeout, R.anim.fadein);
//                        finish();
//                    }
//                });
//            }
//
//            @Override
//            public void onFailure(ZarinPalError error) {
//                String errorMessage = "";
//                switch (error){
//                    case INVALID_PAYMENT: errorMessage = "پرداخت تایید نشد";           break;
//                    case USER_CANCELED:   errorMessage = "پرداخت توسط کاربر متوقف شد"; break;
//                    case NOT_ENOUGH_DATA: errorMessage = "اطلاعات پرداخت کافی نیست";    break;
//                    case UNKNOWN:         errorMessage = "-1اتصال اینترنت خود را بررسی کنید\n2-مقادیر را به درستی وارد کنید";              break;
//                }
//                Log.wtf("TAG", "::ZarinPal::  ERROR: " + errorMessage);
//                textView.setText("خطا!!!" + "\n" + errorMessage);
//                textView.setTextColor(Color.RED);
//
//                btnContiniue.setVisibility(View.VISIBLE);
//                btnContiniue.setText(context.getString(R.string.cancelAndExit));
//                btnContiniue.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        finish();
//                    }
//                });
//            }
//        });
//    }





}
