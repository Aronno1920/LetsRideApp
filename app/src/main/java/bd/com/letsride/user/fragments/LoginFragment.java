package bd.com.letsride.user.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import bd.com.letsride.user.R;
import bd.com.letsride.user.apiClasses.ApiClient;
import bd.com.letsride.user.apiClasses.ApiInterface;
import bd.com.letsride.user.apiModels.ResponseOfRequest;
import bd.com.letsride.user.apiModels.SendOTPRequest;
import bd.com.letsride.user.apiModels.SendOTPResponse;
import bd.com.letsride.user.utilities.BaseFragment;
import bd.com.letsride.user.utilities.UtilityClass;
import retrofit2.Call;
import retrofit2.Callback;

public class LoginFragment extends BaseFragment {

    TextView tvSignUp;
    Button btnLogin;
    EditText txtMobileNumber;
    SendOTPResponse otpResponse;

    public LoginFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        tvSignUp = (TextView) view.findViewById(R.id.TextView_SignUp);
        btnLogin = view.findViewById(R.id.Button_Login);
        txtMobileNumber = view.findViewById(R.id.EditText_MobileNumber);

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.your_placeholder, new RegistrationFragment());
                fragmentTransaction.commit();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtMobileNumber.getText().length() >= 10) {
                    if (txtMobileNumber.getText().toString().matches("^(?:\\+88|88)?(01[3-9]\\d{8})$")) {
                        requestVerificationCode();

                        Bundle i = new Bundle();
                        i.putString("prefix", otpResponse.getPrefix());
                        VerificationFragment verificationFragment = new VerificationFragment();
                        verificationFragment.setArguments(i);

                        FragmentManager fm = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.your_placeholder, verificationFragment);
                        fragmentTransaction.commit();

                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Mobile Number is not valid", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Mobile Number must be atleast 10 digit", Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }

    private void requestVerificationCode() {
        if (UtilityClass.isNetworkAvailable(getActivity().getApplicationContext())) {

            SendOTPRequest otpRequest = new SendOTPRequest("Mobile", "Login", "+88", txtMobileNumber.getText().toString());

            ApiInterface apiService = ApiClient.getClient(getActivity().getApplicationContext()).create(ApiInterface.class);
            Call<ResponseOfRequest> call = apiService.requestVerificatinCode(otpRequest);
            call.enqueue(new Callback<ResponseOfRequest>() {
                @Override
                public void onResponse(Call<ResponseOfRequest> call, retrofit2.Response<ResponseOfRequest> response) {
                    if (response.code() == 200) {
                        ResponseOfRequest result = (ResponseOfRequest) response.body();
                        if (result.getSucceeded()) {
                            otpResponse = result.getSendOTPResponse();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseOfRequest> call, Throwable t) {
                    Log.d("A1920:Error", t.getMessage());
                }
            });
        }
    }
}