package bd.com.letsride.user.fragments;

import static android.content.ContentValues.TAG;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Duration;

import bd.com.letsride.user.R;
import bd.com.letsride.user.apiClasses.ApiClient;
import bd.com.letsride.user.apiClasses.ApiInterface;
import bd.com.letsride.user.models.VerificatinCodeResponse;
import bd.com.letsride.user.utilities.BaseFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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


                VerificatinCodeResponse movie;
                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

                Call<VerificatinCodeResponse> call = apiService.requestVerificatinCode("mobile","login","+88","01912875657");
                call.enqueue(new Callback<VerificatinCodeResponse>() {
                    @Override
                    public void onResponse(Call<VerificatinCodeResponse>call, Response<VerificatinCodeResponse> response) {
                        int statusCode = response.code();

                        Toast.makeText(getActivity().getApplicationContext(),String.valueOf(statusCode),Toast.LENGTH_SHORT).show();

                        Log.d("asdfadsfasdf", "Number of movies received: " + response);
                    }

                    @Override
                    public void onFailure(Call<VerificatinCodeResponse>call, Throwable t) {
                        // Log error here since request failed
                        //Log.e(TAG, t.toString());
                    }
                });
//
//                FragmentManager fm = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fm.beginTransaction();
//                fragmentTransaction.replace(R.id.your_placeholder, new VerificationFragment());
//                fragmentTransaction.commit();
            }
        });
        return view;
    }
}