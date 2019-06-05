package ir.sajjadyosefi.evaluation.activity.evaluation;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.model.request.account.DeviceRequest;
import ir.sajjadyosefi.evaluation.classes.model.responses.basic.ServerResponseBase;
import ir.sajjadyosefi.evaluation.networkLayout.retrofit.TubelessRetrofitCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.Locale;



public class CommentActivity extends TubelessActivity {


    //take an integer variable for SPEECH and intiate as 1
    protected static final int RESULT_SPEECH = 1;
    //take two Image Buttons
    private Button btnSpeak22;


    //take one textview
    private TextView txtText;
    private EditText editTextComment;
    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_comment);
//        setRootActivity(((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));
//
//        init(getContext());
//
//
//
//        DeviceRequest loginRequest = new DeviceRequest(
//                DeviceUtil.GetAndroidId(getContext()),
//                Build.SERIAL,
//                Build.MODEL,
//                Build.ID,
//                Build.VERSION.RELEASE,
//                Build.VERSION.SDK_INT,
//                Build.MANUFACTURER,
//                Build.BRAND,
//                Build.BOARD,
//                Build.DISPLAY);
//        DeviceRegister(loginRequest);




        //Intialize the TextView and two ImageButton’s
//        txtText = (TextView) findViewById(R.id.textView);
//        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);
        btnSpeak22 = (Button) findViewById(R.id.ButtonGetVoice);
        editTextComment = (EditText) findViewById(R.id.editTextComment);
//        btnRecord = (ImageButton) findViewById(R.id.btnRecord);
        // set the listener setOnClickListener for button “btnSpeak”
        btnSpeak22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startVoiceRecognitionActivity();
            }
        });



//        btnSpeak.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(
//                        RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//                //Get the value using Intent from Speech
////                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
////                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "fa-IR");
//                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "fa-IR");
//
//
//                try {
//                    startActivityForResult(intent, RESULT_SPEECH);
//                    //Set the Text as Empty
//                    txtText.setText("");
//                } catch (ActivityNotFoundException a) {
//                    //Show a Toast if the device is not supported
//                    Toast t = Toast.makeText(getApplicationContext(),
//                            "Opps! Your device doesn't support Speech to Text",
//                            Toast.LENGTH_SHORT);
//                    t.show();
//                }
//            }
//        });



    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        //check the requestCode as a case
//        switch (requestCode) {
//            case RESULT_SPEECH: {
//                if (resultCode == RESULT_OK && null != data) {
//                    final ArrayList<String> text = data.getStringArrayListExtra(
//                            RecognizerIntent.EXTRA_RESULTS);
//                    txtText.setText(text.get(0));
////set the Button’s OnClick method for converting Text to Speech
//                    btnRecord.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            String toSpeak = text.toString();
//                            Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
////use the TextToSpeech class for converting the Text to Speech
//                            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
//                        }
//                    });
//                }
//                break;
//            }
//        }
///** Interface definition of a callback to be invoked indicating the completion of the TextToSpeech engine initialization. */
//        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int status) {
//                if(status != TextToSpeech.ERROR) {
//                    t1.setLanguage(Locale.UK);
//                    t1.isLanguageAvailable(new Locale("fa"));
//
//                }
//            }
//        });
//    }

//    private void init(Context context) {
//        SAccounts sAccounts = new SAccounts(context);
//        Global.IDUser = sAccounts.getUserAccountID();
//    }


//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

//    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_SPEECH:
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    // use text.get(0)
                    editTextComment.setText(editTextComment.getText()  + text.get(0) + "\n");
                }
                break;
        }

    }

    private void DeviceRegister(DeviceRequest deviceRequest) {
        Global.apiManagerTubeless.deviceRregister(deviceRequest,new TubelessRetrofitCallback<Object>(getContext(), getRootActivity(), true, null, new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Gson gson = new Gson();
                JsonElement jsonElement = gson.toJsonTree(response.body());
                ServerResponseBase responseX = gson.fromJson(jsonElement.getAsString(), ServerResponseBase.class);

                Intent autoActivityIntent =  new Intent(getContext(), CommentActivity.class);
//                Bundle bundleAuto = new Bundle();
//                bundleAuto.putString("type","NEW_Auto");
//                bundleAuto.putString("BankNumber" , phoneNumber );
//                bundleAuto.putString("Message" , message );
//                autoActivityIntent.putExtras(bundleAuto);
                getContext().startActivity(autoActivityIntent);
                finish();
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        }));
    }

    @Override
    protected void onStop() {
        super.onStop();
        dialog.dismiss();
    }


    private void startVoiceRecognitionActivity() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        // Specify the calling package to identify the application
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getClass().getPackage().getName());

        // Display an hint to the user about what (s)he should say.
        if (true) {
        //if (getPreferencedLanguage().equals("fa-IR")) {
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "سعی کنید واضح صحبت کنید تا بتوانیم آن را به متن تبدیل کنیم.");
        } else {
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "getString(R.string.prompt_activity_voice_recognition_en)");
        }

        // Given an hint to the recognizer about what the useris going to say
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        // Specify how many results you want to receive. the results will be sorted
        // where the first result is the one with higher confidence.
        // We set the number to 1 here.
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
        // Specify the recognition language. This parameter has to specified only if the
        // recognition has to be done in a specific language and not the default one (i.e., the
        // system locale). Most of the applications do not have to set this parameter.
        // We store user preference in the SharedPreferences and retrieve it. Any way our prefer
        // is Persian (fa-IR).
//        String speechLanguage = getPreferencedLanguage();
        String speechLanguage = "fa-IR";
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, speechLanguage);

        try {
            startActivityForResult(intent, RESULT_SPEECH);
        } catch (ActivityNotFoundException anfe) {
            Toast.makeText(getApplicationContext(),"getString(R.string.voice_search_not_support)", Toast.LENGTH_SHORT).show();
        }

    }


}
