package bd.com.letsride.user.fragments;

import android.content.Intent;
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
import bd.com.letsride.user.activities.HomeActivity;
import bd.com.letsride.user.apiClasses.ApiClient;
import bd.com.letsride.user.apiClasses.ApiInterface;
import bd.com.letsride.user.apiModels.ResponseOfRequest;
import bd.com.letsride.user.apiModels.VerificationRequest;
import bd.com.letsride.user.utilities.BaseFragment;
import bd.com.letsride.user.utilities.UtilityClass;
import retrofit2.Call;
import retrofit2.Callback;

public class VerificationFragment extends BaseFragment {

    TextView tvPrefix;
    EditText etVerificationNumber;
    Button btnVerify;
    Boolean isValid;

    public VerificationFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getActivity().getIntent();
        if (intent.getExtras() != null) {
            String prefix = intent.getStringExtra("prefix");
            tvPrefix.setText(prefix);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_verification, container, false);

        tvPrefix = (TextView) view.findViewById(R.id.TextView_Prefix);
        etVerificationNumber = (EditText) view.findViewById(R.id.EditText_Verification_Number);
        btnVerify = (Button) view.findViewById(R.id.Button_Verify);

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etVerificationNumber.getText().length() != 6) {
                    requestVerificatinSuccess();

                    if (isValid) {
                        Intent intent = new Intent(getActivity(), HomeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        getActivity().finish();
                    }
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Verifaiction number must be 6 digit", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }


    private void requestVerificatinSuccess() {
        if(UtilityClass.isNetworkAvailable(getActivity().getApplicationContext())) {

            VerificationRequest otpRequest = new VerificationRequest("Mobile","Login","+88","",tvPrefix.getText().toString(),etVerificationNumber.getText().toString());

            ApiInterface apiService = ApiClient.getClient(getActivity().getApplicationContext()).create(ApiInterface.class);
            Call<ResponseOfRequest> call = apiService.requestVerificatinSuccess(otpRequest);
            call.enqueue(new Callback<ResponseOfRequest>() {
                @Override
                public void onResponse(Call<ResponseOfRequest> call, retrofit2.Response<ResponseOfRequest> response) {
                    if (response.code() == 200) {
                        ResponseOfRequest result = (ResponseOfRequest) response.body();
                        if(result.getSucceeded())
                        {
                            isValid=result.getSucceeded();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseOfRequest> call, Throwable t) {
                    Log.d("A1920:Error",t.getMessage());
                }
            });
        }
    }
}