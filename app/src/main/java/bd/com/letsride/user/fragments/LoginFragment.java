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
import bd.com.letsride.user.responses.VerificationRequestResponse;
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

            ApiInterface apiService = ApiClient.getClient(getActivity().getApplicationContext()).create(ApiInterface.class);

            Call<VerificationRequestResponse> call = apiService.requestVerificatinCode("Mobile","Registration","+88","01711148432");
            call.enqueue(new Callback<VerificationRequestResponse>() {
                @Override
                public void onResponse(Call<VerificationRequestResponse> call, retrofit2.Response<VerificationRequestResponse> response) {
                    if (response.code() == 200) {
                        Log.d("A1920",response.toString());
                    }

                    Log.d("A1920", String.valueOf(response.code()));
                }

                @Override
                public void onFailure(Call<VerificationRequestResponse> call, Throwable t) {
                    Log.d("A1920:Error",t.getMessage());
                }
            });
        }
    }
}