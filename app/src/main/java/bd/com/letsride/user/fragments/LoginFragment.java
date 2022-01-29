package bd.com.letsride.user.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import bd.com.letsride.user.R;
import bd.com.letsride.user.apiClasses.ApiClient;
import bd.com.letsride.user.apiClasses.ApiInterface;
import bd.com.letsride.user.apiModels.ResponseStatus;
import bd.com.letsride.user.apiModels.SendOTPRequest;
import bd.com.letsride.user.apiModels.VerificationResponse;
import bd.com.letsride.user.utilities.BaseFragment;
import bd.com.letsride.user.utilities.UtilityClass;
import retrofit2.Call;
import retrofit2.Callback;

public class LoginFragment extends BaseFragment {

    TextView tvSignUp;
    Button btnLogin;

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

                requestVerificationCode();

//                FragmentManager fm = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fm.beginTransaction();
//                fragmentTransaction.replace(R.id.your_placeholder, new VerificationFragment());
//                fragmentTransaction.commit();
            }
        });
        return view;
    }

    private void requestVerificationCode() {
       if(UtilityClass.isNetworkAvailable(getActivity().getApplicationContext())) {

           SendOTPRequest otpRequest = new SendOTPRequest("Mobile","Login","+88","01912875657");

            ApiInterface apiService = ApiClient.getClient(getActivity().getApplicationContext()).create(ApiInterface.class);
            Call<ResponseStatus> call = apiService.requestVerificatinCode(otpRequest);
            call.enqueue(new Callback<ResponseStatus>() {
                @Override
                public void onResponse(Call<ResponseStatus> call, retrofit2.Response<ResponseStatus> response) {
                    if (response.code() == 200) {

                        ResponseStatus rstatus = (ResponseStatus) response.body();
                        VerificationResponse data = new VerificationResponse(rstatus.getData().);
                        Log.d("A1920",data.toString());
                    }
                }

                @Override
                public void onFailure(Call<ResponseStatus> call, Throwable t) {
                    Log.d("A1920:Error",t.getMessage());
                }
            });
        }
    }
}