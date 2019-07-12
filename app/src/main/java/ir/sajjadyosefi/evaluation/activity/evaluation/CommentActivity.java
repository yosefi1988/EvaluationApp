package ir.sajjadyosefi.evaluation.activity.evaluation;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.libraries.tofiraImagePicker.PickerBuilder;
import ir.sajjadyosefi.evaluation.classes.model.request.SendTaskToServerObject;
import ir.sajjadyosefi.evaluation.classes.model.request.account.DeviceRequest;
import ir.sajjadyosefi.evaluation.classes.model.request.account.LoginRequest;
import ir.sajjadyosefi.evaluation.classes.model.responses.Abfax.AbfaxSelects;
import ir.sajjadyosefi.evaluation.classes.model.responses.basic.ServerResponseBase;
import ir.sajjadyosefi.evaluation.model.business.File;
import ir.sajjadyosefi.evaluation.model.db.Config;
import ir.sajjadyosefi.evaluation.model.main.TubelessObject;
import ir.sajjadyosefi.evaluation.networkLayout.retrofit.TubelessRetrofitCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

import static ir.sajjadyosefi.evaluation.adapter.EndlessList_Adapter.FILES;
import static ir.sajjadyosefi.evaluation.model.business.File.MAP_1;
import static ir.sajjadyosefi.evaluation.model.business.File.MAP_K;


public class CommentActivity extends TubelessActivity {


    //take an integer variable for SPEECH and intiate as 1
    protected static final int RESULT_SPEECH = 1;
    //take two Image Buttons
    private Button btnSpeak22 , buttonSend;
    Button buttonCamera , buttonGallery;


    //take one textview
    private TextView txtText;
    private EditText editTextComment;
    TextToSpeech t1;
    RecyclerView                    mRecyclerViewTimeline;
    LinearLayoutManager             mLayoutManager;
    EndlessList_Adapter             adapter_Posts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_comment);
        setRootActivity(((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));
        activity = this;

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
        buttonSend = (Button) findViewById(R.id.buttonSend);
        buttonCamera = (Button) findViewById(R.id.buttonCamera);
        buttonGallery = (Button) findViewById(R.id.buttonGallery);
        editTextComment = (EditText) findViewById(R.id.editTextComment);
//        btnRecord = (ImageButton) findViewById(R.id.btnRecord);
        // set the listener setOnClickListener for button “btnSpeak”
        btnSpeak22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startVoiceRecognitionActivity();
            }
        });

        buttonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectFromCamera();
            }
        });

        buttonGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectFromGallery();
            }
        });

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SendTaskToServerObject ss = new SendTaskToServerObject();
                ss.setTask(Global.CurrentTask);

                Gson gson = new Gson();
                String json = gson.toJson(ss);

                //get from server
                Global.apiManagerTubeless.sendData(ss, new TubelessRetrofitCallback<Object>(getContext(), getRootActivity(), true, null, new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        Gson gson = new Gson();
                        JsonElement jsonElement = gson.toJsonTree(response.body());


                        finish();
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {

                        int a = 5 ;
                        a++;
                    }
                }));
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


        //file
        filltestFile(getRootActivity());
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

//    private void DeviceRegister(DeviceRequest deviceRequest) {
//        Global.apiManagerTubeless.getSelects(deviceRequest,new TubelessRetrofitCallback<Object>(getContext(), getRootActivity(), true, null, new Callback<Object>() {
//            @Override
//            public void onResponse(Call<Object> call, Response<Object> response) {
//                Gson gson = new Gson();
//                JsonElement jsonElement = gson.toJsonTree(response.body());
//                ServerResponseBase responseX = gson.fromJson(jsonElement.getAsString(), ServerResponseBase.class);
//
//                Intent autoActivityIntent =  new Intent(getContext(), CommentActivity.class);
////                Bundle bundleAuto = new Bundle();
////                bundleAuto.putString("type","NEW_Auto");
////                bundleAuto.putString("BankNumber" , phoneNumber );
////                bundleAuto.putString("Message" , message );
////                autoActivityIntent.putExtras(bundleAuto);
//                getContext().startActivity(autoActivityIntent);
//                finish();
//            }
//
//            @Override
//            public void onFailure(Call<Object> call, Throwable t) {
//
//            }
//        }));
//    }

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

    private void filltestFile(View rootview) {
        //Global.CurrentTask.files

//        File kroki = new File();
//        kroki.setTitle("کروکی");
//        kroki.setName("asdasd.jpg");
//        kroki.setUrl("www.lsdfsdf.com/asdasd.jpg");
//        kroki.setFileType(MAP_K);
//        kroki.setType(FILES);
//        Global.CurrentTask.setFileKrocki(kroki);
//
//
//        File map1 = new File();
//        map1.setTitle("نقشه 1");
//        map1.setName("asdasd.jpg");
//        map1.setUrl("www.lsdfsdf.com/asdasd.jpg");
//        map1.setFileType(MAP_1);
//        map1.setType(FILES);
//        Global.CurrentTask.setFileList(new ArrayList<>());
//        Global.CurrentTask.getFileList().add(map1);
//        Global.CurrentTask.getFileList().add(map1);
//        Global.CurrentTask.getFileList().add(map1);
//        Global.CurrentTask.getFileList().add(map1);

//        taskItemList.add(map1);
//        taskItemList.add(map1);
//        taskItemList.add(map1);
//        taskItemList.add(map1);
//        taskItemList.add(map1);




        mRecyclerViewTimeline           = (RecyclerView) rootview.findViewById(R.id.recyclerView);
        mRecyclerViewTimeline.setHasFixedSize(true);
        mRecyclerViewTimeline.setItemAnimator(new DefaultItemAnimator());
        mLayoutManager = new LinearLayoutManager(getContext());
        adapter_Posts = new EndlessList_Adapter(
                getContext(),
                mLayoutManager,
                rootview,
                Global.CurrentTask.sendToServerfileList ,
                FILES,
                true);
        adapter_Posts.listType = FILES;
        mRecyclerViewTimeline.setLayoutManager(mLayoutManager);
        mRecyclerViewTimeline.setAdapter(adapter_Posts);


    }



    Activity activity ;
    String LastFileSelected = null;
    //ImageView imageViewAvatar,imageViewMedal;

    private void selectFromCamera() {
        new PickerBuilder(activity, PickerBuilder.SELECT_FROM_CAMERA)
                .setOnImageReceivedListener(new PickerBuilder.onImageReceivedListener() {
                    @Override
                    public void onImageReceived(Uri imageUri) {
                        //Toast.makeText(EditProfileActivity.this,"Got image - " + imageUri,Toast.LENGTH_LONG).show();
                        LastFileSelected = imageUri + "";
                        //imageViewAvatar.setImageURI(imageUri);

                        File map1 = new File();
                        map1.setTitle(LastFileSelected.substring(LastFileSelected.lastIndexOf("/")+1));

                        map1.setRequestContentId(1);
                        map1.setFrame(1);
                        map1.setFileType(MAP_1);
                        map1.setUri(LastFileSelected);
                        map1.setType(FILES);
                        Global.CurrentTask.sendToServerfileList.add(map1);
                        adapter_Posts.notifyDataSetChanged();
                    }
                })
                .setImageName("avatar")
                .start();
    }
    private void selectFromGallery() {
        new PickerBuilder(activity, PickerBuilder.SELECT_FROM_GALLERY)
                .setOnImageReceivedListener(new PickerBuilder.onImageReceivedListener() {
                    @Override
                    public void onImageReceived(Uri imageUri) {
//                        Toast.makeText(EditProfileActivity.this,"Got image - " + imageUri,Toast.LENGTH_LONG).show();
                        LastFileSelected = imageUri + "";
                        //imageViewAvatar.setImageURI(imageUri);

                        File map1 = new File();
                        map1.setTitle(LastFileSelected.substring(LastFileSelected.lastIndexOf("/")+1));
                        map1.setRequestContentId(1);
                        map1.setFrame(1);
                        map1.setFileType(MAP_1);
                        map1.setUri(LastFileSelected);
                        map1.setType(FILES);
                        Global.CurrentTask.sendToServerfileList.add(map1);
                        adapter_Posts.notifyDataSetChanged();

                    }
                })
                .setImageName("avatar")
                .start();
    }

    private static final int PERMISSION_REQUEST_CODE = 1;


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    LoginRequest loginRequest = new LoginRequest();
//                    UserName = getPhone();
//                    loginRequest.setAndroidId(DeviceUtil.GetAndroidId(getContext()));
//                    LoginOrRegister(loginRequest);
                } else {
                    Toast.makeText(getActivity(),"Permission Denied. We can't get phone number.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    private void requestPermission(String permission){
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), permission)){
            Toast.makeText(getActivity(), "Phone state permission allows us to get phone number. Please allow it for additional functionality.", Toast.LENGTH_LONG).show();
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{permission},PERMISSION_REQUEST_CODE);
    }

    private boolean checkPermission(String permission){
        if (Build.VERSION.SDK_INT >= 23) {
            int result = ContextCompat.checkSelfPermission(getActivity(), permission);
            if (result == PackageManager.PERMISSION_GRANTED){
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

}
