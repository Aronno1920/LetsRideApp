package bd.com.letsride.user.presentation.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bd.com.letsride.user.R;
import bd.com.letsride.user.apiClasses.ApiClient;
import bd.com.letsride.user.apiClasses.ApiInterface;
import bd.com.letsride.user.models.requestModels.SaveUserRequest;
import bd.com.letsride.user.models.responseModels.SaveUserPesponse;
import bd.com.letsride.user.models.responseModels.SendOTPData;
import bd.com.letsride.user.presentation.activities.HomeActivity;
import bd.com.letsride.user.utilities.BaseFragment;
import bd.com.letsride.user.utilities.ResponseModelDAO;
import bd.com.letsride.user.utilities.UtilityClass;
import retrofit2.Call;
import retrofit2.Callback;

public class RegistrationFragment extends BaseFragment {

    View view;
    Button btnButton;
    EditText txtFirstName, txtLastName, txtEmail, txtPassword;

    public RegistrationFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_registration, container, false);

        txtFirstName = view.findViewById(R.id.EditText_First_Name);
        txtLastName= view.findViewById(R.id.EditText_Last_Name);
        txtEmail=view.findViewById(R.id.EditText_Email_Address);
        txtPassword=view.findViewById(R.id.EditText_Web_Password);

        btnButton = view.findViewById(R.id.Button_UpdateProfile);

        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestSaveUserProfile();
            }
        });


        return view;
    }


    private void requestSaveUserProfile() {
        if (UtilityClass.isNetworkAvailable(getActivity().getApplicationContext())) {

            SendOTPData sendOTPData = new ResponseModelDAO().getSendOTPResponse();
            SaveUserRequest saveRequest = new SaveUserRequest(txtFirstName.getText().toString(),txtLastName.getText().toString(),txtEmail.getText().toString(),sendOTPData.getMobileNumber(),txtPassword.getText().toString(),"ProfilePhoto");

            ApiInterface apiService = ApiClient.getClient(getActivity().getApplicationContext()).create(ApiInterface.class);
            Call<SaveUserPesponse> call = apiService.requestSaveUserProfile(saveRequest);
            call.enqueue(new Callback<SaveUserPesponse>() {
                @Override
                public void onResponse(Call<SaveUserPesponse> call, retrofit2.Response<SaveUserPesponse> response) {
                    if (response.body().getSucceeded()) {

                        //Store API Response to Temporary memory
                        SaveUserPesponse myOTP = response.body();
                        //new ResponseModelDAO().addSendOTPResponseToDAO(myOTP);

                        redirectedToHomePage();
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<SaveUserPesponse> call, Throwable t) {
                    Log.d("A1920:Error", t.getMessage());
                }
            });
        }
    }

    private void redirectedToHomePage() {
            Intent intent = new Intent(getActivity(), HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            getActivity().finish();
    }
}