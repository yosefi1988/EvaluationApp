package ir.sajjadyosefi.evaluation.activity.account;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.activity.MainActivity;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.classes.SAccounts;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.model.request.account.LoginRequest;
import ir.sajjadyosefi.evaluation.classes.model.responses.accounting.LoginResponse;
import ir.sajjadyosefi.evaluation.networkLayout.retrofit.TubelessRetrofitCallback;
import ir.sajjadyosefi.evaluation.classes.utility.DeviceUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends TubelessActivity {


    //val
    private static final String TAG = "sssssssssssssss";
    private int RC_SIGN_IN = 1000;
    String wantPermission = Manifest.permission.READ_PHONE_STATE;
    private static final int PERMISSION_REQUEST_CODE = 1;

    //var

    //widget
    Button submitButton, submitBySimCard;
    SignInButton submitByGoogle;

    EditText editTextPass, editTextPhone;

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    LoginRequest loginRequest = new LoginRequest(getPhone());
                    UserName = getPhone();
                    loginRequest.setAndroidID(DeviceUtil.GetAndroidId(getContext()));
                    LoginOrRegister(loginRequest);
                } else {
                    Toast.makeText(getActivity(),"Permission Denied. We can't get phone number.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        setRootActivity(((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));



        submitButton = findViewById(R.id.submit);
        editTextPass = findViewById(R.id.editTextPass);
        editTextPhone = findViewById(R.id.editTextPhone);


        submitBySimCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!checkPermission(wantPermission)) {
                    requestPermission(wantPermission);
                } else {
                    LoginRequest loginRequest = new LoginRequest(getPhone());
                    loginRequest.setAndroidID(DeviceUtil.GetAndroidId(getContext()));
                    UserName = getPhone();
                    LoginOrRegister(loginRequest);
                }
            }
        });


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                LoginRequest loginRequest = new LoginRequest("09123678522");
                LoginRequest loginRequest = new LoginRequest(editTextPhone.getText().toString(), editTextPass.getText().toString(), DeviceUtil.GetAndroidId(getContext()));
                UserName = editTextPhone.getText().toString();
                LoginOrRegister(loginRequest);
            }
        });




        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();


        final GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

//        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
//        updateUI(account);

        submitByGoogle.setSize(SignInButton.SIZE_STANDARD);
        submitByGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });
//        PackageManager p = getPackageManager();
//        p.setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
    }



    String UserName;
    private void LoginOrRegister(LoginRequest loginRequest) {
        Global.apiManagerTubeless.loginOrRregister(loginRequest,new TubelessRetrofitCallback<Object>(getContext(), getRootActivity(), true, null, new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Gson gson = new Gson();
                JsonElement jsonElement = gson.toJsonTree(response.body());
                LoginResponse responseX = gson.fromJson(jsonElement.getAsString(), LoginResponse.class);

//                        for (TimelineItem item : responseX.getBlogItem()) {
//                            mTimelineItemList.add(item);
//                        }
//                        adapter.notifyDataSetChanged();

                Global.user = responseX;
                accounts(UserName , (int) responseX.getUserId());

                Toast.makeText(getContext(),getContext().getString(R.string.welcome) ,Toast.LENGTH_LONG).show();

                Intent autoActivityIntent =  new Intent(getContext(), MainActivity.class);
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


    private void accounts(String name , int UserID) {
        SAccounts sAccounts = new SAccounts(getContext());
        if (!sAccounts.hasUserAccount()){
            sAccounts.createAccount(name,UserID);
        }else {
            int Userid = sAccounts.getUserAccountID();

        }

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

//            Toast.makeText(getContext(),"Id:" +account.getId(),Toast.LENGTH_LONG).show();
//            Toast.makeText(getContext(),"DisplayName:" + account.getDisplayName(),Toast.LENGTH_LONG).show();
//            Toast.makeText(getContext(),account.getEmail(),Toast.LENGTH_LONG).show();
//            Toast.makeText(getContext(),account.getFamilyName(),Toast.LENGTH_LONG).show();
//            Toast.makeText(getContext(),account.getGivenName(),Toast.LENGTH_LONG).show();
//            Toast.makeText(getContext(),account.getAccount().name,Toast.LENGTH_LONG).show();
//            Toast.makeText(getContext(),account.getAccount().type,Toast.LENGTH_LONG).show();
//            if (account.getPhotoUrl() != null)
//                Toast.makeText(getContext(),"hotoUrl" + account.getPhotoUrl().toString(),Toast.LENGTH_LONG).show();

//            accounts(account.getEmail());
//            int a = 5 ;
//            a++;
            // Signed in successfully, show authenticated UI.
//            updateUI(account);


            LoginRequest loginRequest = new LoginRequest(account.getEmail(),account.getPhotoUrl().toString());
            loginRequest.setAndroidID(DeviceUtil.GetAndroidId(getContext()));
            UserName = account.getEmail();
            LoginOrRegister(loginRequest);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
//            updateUI(null);
        }
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

    private void requestPermission(String permission){
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), permission)){
            Toast.makeText(getActivity(), "Phone state permission allows us to get phone number. Please allow it for additional functionality.", Toast.LENGTH_LONG).show();
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{permission},PERMISSION_REQUEST_CODE);
    }

    private String getPhone() {
        TelephonyManager phoneMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(getActivity(), wantPermission) != PackageManager.PERMISSION_GRANTED) {
            return "";
        }
        if(phoneMgr.getLine1Number().equals("")){
            return phoneMgr.getSubscriberId();
        }else {
            return phoneMgr.getLine1Number();
        }
    }


}
