package bd.com.letsride.user.presentation.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
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
import bd.com.letsride.user.models.requestModels.VerifyOTPRequest;
import bd.com.letsride.user.models.responseModels.SendOTPData;
import bd.com.letsride.user.models.responseModels.SendOTPResponse;
import bd.com.letsride.user.models.responseModels.VerifyOTPData;
import bd.com.letsride.user.models.responseModels.VerifyOTPResponse;
import bd.com.letsride.user.presentation.activities.HomeActivity;
import bd.com.letsride.user.presentation.activities.RegistrationActivity;
import bd.com.letsride.user.utilities.BaseFragment;
import bd.com.letsride.user.utilities.ProgressDialogHelper;
import bd.com.letsride.user.utilities.ResponseModelDAO;
import bd.com.letsride.user.utilities.SessionManager;
import bd.com.letsride.user.utilities.UtilityClass;
import retrofit2.Call;
import retrofit2.Callback;

public class VerificationFragment extends BaseFragment {

    SessionManager session;
    TextView tvPrefix, tvTimer;
    EditText etVerificationNumber;
    Button btnVerify;
    View view;

    public VerificationFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_verification, container, false);
        session = new SessionManager(getActivity().getApplicationContext());

        InitializationViews();
        StartTimer();

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etVerificationNumber.getText().length() == 6) {

                    ProgressDialogHelper.ShowDialog(getActivity(), "", "Verify OTP code...");
                    requestVerificatinSuccess();
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Verifaiction number must be 6 digit", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

    private void InitializationViews() {
        tvPrefix = (TextView) view.findViewById(R.id.TextView_Prefix);
        tvTimer = (TextView) view.findViewById(R.id.TextView_Countdown_timer);
        etVerificationNumber = (EditText) view.findViewById(R.id.EditText_Verification_Number);
        btnVerify = (Button) view.findViewById(R.id.Button_Verify);

        SendOTPData sendOTPData = new ResponseModelDAO().getSendOTPResponse();
        tvPrefix.setText(sendOTPData.getPrefix() + " - ");
    }

    private void requestVerificatinSuccess() {
        if (UtilityClass.isNetworkAvailable(getActivity().getApplicationContext())) {

            SendOTPData sendOTPData = new ResponseModelDAO().getSendOTPResponse();
            VerifyOTPRequest otpRequest = new VerifyOTPRequest("Mobile", "Authentication", sendOTPData.getCountryCode(), sendOTPData.getMobileNumber(), sendOTPData.getPrefix(), etVerificationNumber.getText().toString());

            ApiInterface apiService = ApiClient.getClient(getActivity().getApplicationContext()).create(ApiInterface.class);
            Call<VerifyOTPResponse> call = apiService.verifyOTPSuccess(otpRequest);
            call.enqueue(new Callback<VerifyOTPResponse>() {
                @Override
                public void onResponse(Call<VerifyOTPResponse> call, retrofit2.Response<VerifyOTPResponse> response) {
                    try {
                        if (response.body().getSucceeded()) {

                            VerifyOTPData myVerify = response.body().getVerifyOTPData();
                            new ResponseModelDAO().addVerifyOTPResponseToDAO(myVerify);

                            session.saveAuthToken(myVerify.getToken());
                            redirectedToHomeOrRegistrionPage(myVerify.getProfileUpdated());
                        } else {
                            Toast.makeText(getActivity().getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        ProgressDialogHelper.DismissDialog();
                    }
                }

                @Override
                public void onFailure(Call<VerifyOTPResponse> call, Throwable t) {
                    Log.d("A1920:Error", t.getMessage());
                    ProgressDialogHelper.DismissDialog();
                }
            });
        }
    }

    private void StartTimer() {
        new CountDownTimer(120000, 1000) {
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("Seconds remaining: " + millisUntilFinished / 1000 + "s");
            }

            public void onFinish() {
                tvTimer.setText("Don't receive? Send again");
            }
        }.start();
    }

    private void redirectedToHomeOrRegistrionPage(Boolean isProfileUpdated) {
        if (isProfileUpdated) {
            Intent intent = new Intent(getActivity(), HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            getActivity().finish();
        } else {
            Intent intent = new Intent(getActivity(), RegistrationActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            getActivity().finish();
        }
    }
}