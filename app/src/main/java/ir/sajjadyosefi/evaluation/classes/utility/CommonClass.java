package ir.sajjadyosefi.evaluation.classes.utility;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import ir.sajjadyosefi.evaluation.R;

/**
 * Created by sajjad on 10/06/2016.
 */
public class CommonClass {

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }

    public static float convertPixelsToDp(float px, Context context) {
        return px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
    public static int convertPixelsToDp(int px, Context context){
        return px / ((int) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

//    public static void ShowMenuPromp(final Context context ){
//
//        // get prompts.xml view
//        LayoutInflater li = LayoutInflater.from(context);
//        View promptsView = li.inflate(R.layout.menu_prompts, null);
//
//        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
//
//
//        // set prompts.xml to alertdialog builder
//        alertDialogBuilder.setView(promptsView);
//
//
//
//        ///////////////////////////////////////////////////////////////////////////////////////
//        Button buttonAddManualTransaction,buttonclose,buttonViewStatusAndReports,buttonAddCardOrAcount,buttonEditCardOrAcount,buttonAuto;
//
//        IconFontView iconFontView ;
//        Button buttonSetting,btnCharts;
//        buttonViewStatusAndReports = (Button) promptsView.findViewById(R.id.buttonViewStatusAndReports);
//        buttonAddCardOrAcount = (Button) promptsView.findViewById(R.id.buttonAddCardOrAcount);
//        buttonEditCardOrAcount = (Button) promptsView.findViewById(R.id.buttonEditCardOrAcount);
//        buttonAddManualTransaction = (Button) promptsView.findViewById(R.id.buttonAddManualTransaction);
//        buttonclose = (Button) promptsView.findViewById(R.id.btn_close);
//        buttonAuto = (Button) promptsView.findViewById(R.id.buttonAuto);
//
//        buttonAuto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String phoneNumber = "\"بانك سامان\n" +
//                        "واريز مبلغ  18,096,952\n" +
//                        "به \u202A878-700-1895083-1\u202C\n" +
//                        "مانده 23,634,277\n" +
//                        "1394/12/18\n" +
//                        "11:49\"" ;
////                String phoneNumber = "\"بانك سامان\n" +
////                        "برداشت مبلغ 420,000 خريدکالا\n" +
////                        "از \u202A878-700-1895083-1\u202C\n" +
////                        "مانده 5,714,277\n" +
////                        "1395/1/21\n" +
////                        "20:26:02\"";
//                String message = "+9820000" ;
//
//                Intent autoActivityIntent =  new Intent(context,TransactionActivity.class);
//                Bundle bundleAuto = new Bundle();
//                bundleAuto.putString("type","NEW_Auto");
//                bundleAuto.putString("BankNumber" , phoneNumber );
//                bundleAuto.putString("Message" , message );
//                autoActivityIntent.putExtras(bundleAuto);
//                context.startActivity(autoActivityIntent);
//            }
//        });
//
//
//
//
//        buttonSetting = (Button)promptsView. findViewById(R.id.buttonSetting);
//        btnCharts = (Button) promptsView.findViewById(R.id.btnCharts);
//        btnCharts.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                context.startActivity( new Intent(context,chartsActivity.class));
//            }
//        });
//        buttonSetting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(context,SettingActivity.class);
//                intent.putExtra("TYPE","EDIT");
//                context.startActivity(intent);
//                ((Activity)context).finish();
//            }
//        });
//
//
//        iconFontView = (IconFontView)promptsView.findViewById(R.id.notif_icon);
//        iconFontView.setText(R.string.icon_users);
//
//        buttonAddCardOrAcount.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =  new Intent(context,EditcardActivity.class);
//                intent.putExtra("type","EDIT");
//                context.startActivity(intent);
//            }
//        });
//        buttonEditCardOrAcount.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =  new Intent(context,EditcardActivity.class);
//                intent.putExtra("type","NEW");
//
//                context.startActivity(intent);
//            }
//        });
//
//
//
//
//        buttonAddManualTransaction.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =  new Intent(context,TransactionActivity.class);
//                intent.putExtra("type","NEW_Manual");
//
//                context.startActivity(intent);
//            }
//        });
//
//
//        ///////////////////////////////////////////////////////////////////////////////////////
//
//        // set dialog message
//        alertDialogBuilder
//                .setCancelable(false)
//                .setPositiveButton("OK",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog,int id) {
//                                // get user input and set it to result
//                                // edit text
//
//
//                            }
//                        })
//
//                .setNegativeButton("Cancel",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                dialog.cancel();
//                            }
//                        });
//
//        // create alert dialog
//        AlertDialog alertDialog = alertDialogBuilder.create();
//
//
//        alertDialogBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() {
//            @Override
//            public void onDismiss(DialogInterface dialog) {
//
//            }
//        });
//
//        // show it
//        //alertDialog.show();
//
//        final AlertDialog dialog = alertDialogBuilder.show();
//        //dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setEnabled(true);
//        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setVisibility(View.GONE);
//        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setVisibility(View.GONE);
//
//        dialog.getWindow().setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_main_menu_body) );
//
//        buttonclose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//    }

    public static void getBalanse(final Context context, final String ownerOrTitle){

        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.prompts, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView  .findViewById(R.id.editTextDialogUserInput);
        final TextView textView = (TextView) promptsView.findViewById(R.id.textViewTitle);
//        textView.setText(context.getString(R.string.app_price));

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OaaaK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        })
                .setNegativeButton("Caaaaaaaaaancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        alertDialog.show();


        alertDialogBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

            }
        });

    }


    public static void ShowPardakht(final Context context){
//
//        // get prompts.xml view
//        LayoutInflater li = LayoutInflater.from(context);
//        View promptsView = li.inflate(R.layout.prompts, null);
//
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
//
//        // set prompts.xml to alertdialog builder
//        alertDialogBuilder.setView(promptsView);
//
////        final EditText userInput = (EditText) promptsView  .findViewById(R.id.editTextDialogUserInput);
//        final TextView textView = (TextView) promptsView.findViewById(R.id.textViewTitle);
//        String text = String.format(
//                context.getString(R.string.app_pardakht_text),
//                context.getString(R.string.app_price),
//                context.getString(R.string.app_web_address));
//        textView.setText(text);
//
//        // set dialog message
//        alertDialogBuilder
//                .setCancelable(false)
//                .setPositiveButton(context.getString(R.string.pardakht),
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                Intent intent = new Intent(context, PaymentActivity.class);
//                                ((Activity)context).startActivity(intent);
//                                ((Activity)context).overridePendingTransition(R.anim.fadeout, R.anim.fadein);
//                                ((Activity)context).finish();
//                            }
//                        })
//                .setNegativeButton(R.string.cancelAndExit,
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                dialog.cancel();
//                                ((Activity)context).finish();
//                            }
//                        });
//        // create alert dialog
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        // show it
//        alertDialog.show();
//        alertDialogBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() {
//            @Override
//            public void onDismiss(DialogInterface dialog) {
//
//            }
//        });
    }

    public static int FIRST_TIME = 0;
    //public static int MUST_COONNECT_TO_PAYMENT = 1;
    public static int NOT_CONNECT = 2;
    public static int MUST_COONNECT_TO_COUNTINUE = 3;
    public static int SHOW_PEYMENT_REF_ID = 4;
    public static int CONTACT_WITH_US = 5;


    public static void ShowInternetConnection(final Context context, int type){
        ShowInternetConnection(context,type,null);
    }
    public static void ShowInternetConnection(final Context context, int type, String arg){
//
//        // get prompts.xml view
//        LayoutInflater li = LayoutInflater.from(context);
//        View promptsView = li.inflate(R.layout.prompts, null);
//
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
//
//        // set prompts.xml to alertdialog builder
//        alertDialogBuilder.setView(promptsView);
//
////        final EditText userInput = (EditText) promptsView  .findViewById(R.id.editTextDialogUserInput);
//        final TextView textView = (TextView) promptsView.findViewById(R.id.textViewTitle);
//
//        if (type == FIRST_TIME) {
//            textView.setText(context.getString(R.string.internetConnectionErrorTextFirstTime));
//
//            // set dialog message
//            alertDialogBuilder
//                    .setCancelable(false)
//                    .setPositiveButton(context.getString(R.string.internetConnectTryAgain),
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//
//
//                                    dialog.dismiss();
//                                    Intent intent = ((Activity)context).getIntent();
//                                    ((Activity)context).finish();
//                                    ((Activity)context).startActivity(intent);
//                                    ((Activity)context).overridePendingTransition(R.anim.fadeout, R.anim.fadein);
//                                }
//                            }
//                    )
//                    .setNegativeButton(R.string.cancelAndExit,
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    dialog.cancel();
//                                    ((Activity)context).finish();
//                                }
//                            });
////        }else if (type == MUST_COONNECT_TO_PAYMENT) {
////            textView.setText(context.getString(R.string.internetConnectionForPaymentErrorText));
////
////            // set dialog message
////            alertDialogBuilder
////                    .setCancelable(false)
////                    .setPositiveButton(context.getString(R.string.ok),
////                            new DialogInterface.OnClickListener() {
////                                public void onClick(DialogInterface dialog,int id) {
////                                    dialog.dismiss();
////                                }
////                            })
////                    .setNegativeButton(R.string.cancelAndExit,
////                            new DialogInterface.OnClickListener() {
////                                public void onClick(DialogInterface dialog, int id) {
////                                    dialog.cancel();
////                                    ((Activity)context).finish();
////                                }
////                            });
//        }else if (type == NOT_CONNECT) {
//            textView.setText(context.getString(R.string.errorInInternetConnection));
//
//            // set dialog message
//            alertDialogBuilder
//                    .setCancelable(false)
//                    .setPositiveButton(context.getString(R.string.ok),
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    dialog.dismiss();
//                                }
//                            })
//                    .setNegativeButton(R.string.cancelAndExit,
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    dialog.cancel();
//                                    ((Activity)context).finish();
//                                }
//                            });
//        }else if (type == SHOW_PEYMENT_REF_ID) {
//            textView.setText(String.format(context.getString(R.string.peymentOkResponseMessage),arg));
//            // set dialog message
//            alertDialogBuilder
//                    .setCancelable(false)
//                    .setPositiveButton(context.getString(R.string.ok),
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    dialog.dismiss();
//                                }
//                            });
//        }else if (type == CONTACT_WITH_US) {
//            textView.setText(String.format(
//                    context.getString(R.string.ErrorOnConfermPayment),
//                    context.getString(R.string.SupportNumber),
//                    arg));
//            // set dialog message
//            alertDialogBuilder
//                    .setCancelable(false)
//                    .setPositiveButton(context.getString(R.string.ok),
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    dialog.dismiss();
//                                }
//                            });
//        }
//        else if (type == MUST_COONNECT_TO_COUNTINUE) {
//            textView.setText(context.getString(R.string.errorInInternetConnectionforCountinue));
//
//            // set dialog message
//            alertDialogBuilder
//                    .setCancelable(false)
//                    .setPositiveButton(context.getString(R.string.internetConnectTryAgain),
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    dialog.dismiss();
//                                    Intent intent = ((Activity)context).getIntent();
//                                    ((Activity)context).finish();
//                                    ((Activity)context).startActivity(intent);
//                                    ((Activity)context).overridePendingTransition(R.anim.fadeout, R.anim.fadein);
//                                }
//                            }
//                    )
//                    .setNegativeButton(R.string.cancelAndExit,
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    dialog.cancel();
//                                    ((Activity)context).finish();
//                                }
//                            });
//        }
//
//
//
//        // create alert dialog
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        // show it
//        alertDialog.show();
//        alertDialogBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() {
//            @Override
//            public void onDismiss(DialogInterface dialog) {
//
//            }
//        });
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info != null)
            return info.isAvailable();
        else
            return false;
    }
    public static boolean isAppAvailable(Context context, String appName)
    {
        PackageManager pm = context.getPackageManager();
        try
        {
            pm.getPackageInfo(appName, PackageManager.GET_ACTIVITIES);
            return true;
        }
        catch (PackageManager.NameNotFoundException e)
        {
            return false;
        }
    }


    public static boolean isLimitValid() {
//        AppStatus appStatus = null;
//        List<AppStatus> appStatusList = AppStatus.listAll(AppStatus.class);
//        if (appStatusList.size() == 1) {
//            appStatus = appStatusList.get(0);
//        }
//
//
//        if (appStatus != null && appStatus.InstallDate != null) {
//            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//
//            Date d1 = null;
//            Date d2 = null;
//            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//            String currentDateandTime = sdf.format(new Date());
//
//            try {
//                d1 = format.parse(appStatus.InstallDate);
//                d2 = format.parse(currentDateandTime);
//
//                //in milliseconds
//                long diff = d2.getTime() - d1.getTime();
//
//                long diffSeconds = diff / 1000 % 60;
//                long diffMinutes = diff / (60 * 1000) % 60;
//                long diffHours = diff / (60 * 60 * 1000) % 24;
//                long diffDays = diff / (24 * 60 * 60 * 1000);
//
//                System.out.print(diffDays + " days, ");
//                System.out.print(diffHours + " hours, ");
//                System.out.print(diffMinutes + " minutes, ");
//                System.out.print(diffSeconds + " seconds.");
//
//                if(diffDays <= 2) {
//                    return true;
//                }
//                else {
//                    //Save
//                    appStatus.buyStatus = "Null";
//                    //appStatus.buyStatus = "Limit";
//                    appStatus.save();
//                    //End Save
//                    return false;
//
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        return  true;
    }

//    public static void runApplication(final Context context, Boolean withBundle, final ServerResponseConfig serverResponseConfig) {
//        if(!withBundle) {
//            final Handler handler = new Handler();
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    context.startActivity(new Intent(context, MainActivity.class));
//                    ((Activity)context).overridePendingTransition(R.anim.fadeout, R.anim.fadein);
//                    ((Activity)context).finish();
//                }
//            }, 500);
//        }else {
////            final Handler handler = new Handler();
////            handler.postDelayed(new Runnable() {
////                @Override
////                public void run() {
////                    Intent intent = new Intent(context, MainActivity.class);
////                    Bundle bundle = new Bundle();
////                    bundle.putString("MoarefStatus",((ServerResponseConfig) serverResponseConfig).details.MoarefStatus);
////                    intent.putExtras(bundle);
////                    context.startActivity(intent);
////                    ((Activity)context).finish();
////                }
////            }, 500);
//        }
//    }





    public static String GetAppVersion(Context context) {
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return pInfo.versionName;
        }catch (Exception ex){
            return "0";
        }
    }


    public static boolean IsNumber(String string){
        if (string.matches("\\d+(?:\\.\\d+)?")){
            return true;
        }else {
            return false;
        }
    }
}
