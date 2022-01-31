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
import bd.com.letsride.user.apiRequestModels.SendOTPRequest;
import bd.com.letsride.user.apiResponseModels.SendOTPData;
import bd.com.letsride.user.apiResponseModels.SendOTPResponse;
import bd.com.letsride.user.utilities.BaseFragment;
import bd.com.letsride.user.utilities.ResponseModelDAO;
import bd.com.letsride.user.utilities.UtilityClass;
import retrofit2.Call;
import retrofit2.Callback;

public class LoginFragment extends BaseFragment {

    TextView tvSignUp;
    Button btnLogin;
    EditText txtMobileNumber;

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
                        try {
                            requestVerificationCode();

                            Thread.sleep(2000);
                            FragmentManager fm = getFragmentManager();
                            FragmentTransaction fragmentTransaction = fm.beginTransaction();
                            fragmentTransaction.replace(R.id.your_placeholder, new VerificationFragment());
                            fragmentTransaction.commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
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
            Call<SendOTPResponse> call = apiService.requestVerificatinCode(otpRequest);
            call.enqueue(new Callback<SendOTPResponse>() {
                @Override
                public void onResponse(Call<SendOTPResponse> call, retrofit2.Response<SendOTPResponse> response) {
                    if (response.code() == 200) {
                        SendOTPResponse result = (SendOTPResponse) response.body();

                        if (result.getSucceeded()) {
                            SendOTPData myOTP = result.getData();
                            new ResponseModelDAO().addSendOTPResponseToDAO(myOTP);
                        } else {
                            Toast.makeText(getActivity().getApplicationContext(), "Hoynai", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Hoitona", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<SendOTPResponse> call, Throwable t) {
                    Log.d("A1920:Error", t.getMessage());
                }
            });
        }
    }
}