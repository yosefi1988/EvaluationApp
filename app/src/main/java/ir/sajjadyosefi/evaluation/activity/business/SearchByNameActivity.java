package ir.sajjadyosefi.evaluation.activity.business;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.*;
import com.bluehomestudio.progresswindow.ProgressWindow;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.model.exception.TubelessException;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.Global;
import ir.sajjadyosefi.evaluation.networkLayout.retrofit.PostRetrofitCallback;
import ir.sajjadyosefi.evaluation.classes.model.request.SearchRequest;
import ir.sajjadyosefi.evaluation.classes.model.responses.post.ServerResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchByNameActivity extends TubelessActivity {


    //val
    EditText editTextName,editTextFamily,editTextFather;
    String searchType = "-1";


    private static ProgressWindow instance = null;

    private WindowManager windowManager;
    private WindowManager.LayoutParams layoutParams;
    private View progressLayout;
    private boolean isAttached ;
    private View mainProgress;
    private LinearLayout mainLayout;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_name);
        setRootActivity((ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0));

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextFamily = (EditText) findViewById(R.id.editTextFamily);
        editTextFather = (EditText) findViewById(R.id.editTextFather);


        ((TextView)findViewById(R.id.textViewSearchByNationalCode)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getContext(),SearchByNationalCodeActivity.class));
                getActivity().finish();
            }
        });


        ((Button)findViewById(R.id.button_search)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (editTextName.getText().toString().length() < 3){
                        throw new TubelessException(TubelessException.NAME_NOT_TRUE);
                    }else if (editTextFamily.getText().toString().length() < 3){
                        throw new TubelessException(TubelessException.FAMILY_NOT_TRUE);
                    }else {
                        SearchRequest requestSearchRequest = new SearchRequest(
                                editTextName.getText().toString(),
                                editTextFamily.getText().toString(),
                                editTextFather.getText().toString()
                                ,searchType);


//                        Global.apiManagerPost.createUser(requestSearchRequest, new PostRetrofitCallback<Object>(getContext(), null, true, null, new Callback<Object>() {
//                            @Override
//                            public void onResponse(Call<Object> call, Response<Object> response) {
//
//
//                                Gson gson = new Gson();
//                                JsonElement jsonElement = gson.toJsonTree(response.body());
//                                ServerResponse responseX = gson.fromJson(jsonElement, ServerResponse.class);
//
//
//                                if (responseX.getType().equals("NoResult")) {
//                                    showNotAnyResultDialog(responseX);
//                                }else if (responseX.getType().equals("SearchResult")) {
//                                    if (responseX.getData() != null) {
//                                        if (responseX.getData().size() == 1) {
//                                            goToResult(responseX);
//                                        } else if (responseX.getData().size() >= 2) {
//                                            showManyResultDialog(responseX);
//                                        } else {
//                                            Toast.makeText(getActivity(), responseX.getMessage(), Toast.LENGTH_LONG).show();
//                                        }
//                                    }
//                                }
//                            }
//
//                            @Override
//                            public void onFailure(Call<Object> call, Throwable t) {}
//                        }));

                    }
                }catch (TubelessException e){
                    e.printStackTrace();
                    if (true)
                        TubelessException.handleClientMessage(getContext(),getRootActivity(),e.getCode());
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void showNotAnyResultDialog(final ServerResponse responseX) {
        //before inflating the custom alert dialog layout, we will get the current activity viewgroup
        ViewGroup viewGroup = findViewById(android.R.id.content);

        //then we will inflate the custom alert dialog xml that we created
        final View dialogView = LayoutInflater.from(this).inflate(R.layout.my_dialog, viewGroup, false);
        TextView textViewStatment = dialogView.findViewById(R.id.textViewStatment);
        Button buttonOk = dialogView.findViewById(R.id.buttonOk);
        Button buttonCancel = dialogView.findViewById(R.id.buttonCancel);
        textViewStatment.setText(responseX.getMessage());

        //Now we need an AlertDialog.Builder object
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //setting the view of the builder to our custom view that we already inflated
        builder.setView(dialogView);

        //finally creating the alert dialog and displaying it
        final AlertDialog alertDialog = builder.create();
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                goToResult(responseX);
            }
        });
        alertDialog.show();
    }




    private void showManyResultDialog(final ServerResponse responseX) {
        //before inflating the custom alert dialog layout, we will get the current activity viewgroup
        ViewGroup viewGroup = findViewById(android.R.id.content);

        //then we will inflate the custom alert dialog xml that we created
        final View dialogView = LayoutInflater.from(this).inflate(R.layout.my_dialog, viewGroup, false);
        TextView textViewStatment = dialogView.findViewById(R.id.textViewStatment);
        Button buttonOk = dialogView.findViewById(R.id.buttonOk);
        Button buttonCancel = dialogView.findViewById(R.id.buttonCancel);
        textViewStatment.setText(responseX.getMessage());



        //Now we need an AlertDialog.Builder object
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //setting the view of the builder to our custom view that we already inflated
        builder.setView(dialogView);

        //finally creating the alert dialog and displaying it
        final AlertDialog alertDialog = builder.create();
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                goToResult(responseX);
            }
        });
        alertDialog.show();
    }

    private void goToResult(ServerResponse responseX) {
//        SearchResultActivity.searchResponse = responseX.getData());
        Intent intent = new Intent(getContext(), SearchResultActivity.class);
        Bundle bundle = new Bundle();
        //                                    bundle.putInt(ContactUsActivity.Type, 16);
        intent.putExtras(bundle);
        startActivity(intent);
        //                                    getActivity().overridePendingTransition(R.anim.fadeout, R.anim.fadein);
    }
}
