package bd.com.letsride.user.presentation.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import bd.com.letsride.user.R;
import bd.com.letsride.user.adapters.RideUpcomingAdapter;
import bd.com.letsride.user.apiClasses.ApiClient;
import bd.com.letsride.user.apiClasses.ApiInterface;
import bd.com.letsride.user.models.RideUpcomingModel;
import bd.com.letsride.user.models.responseModels.BalanceData;
import bd.com.letsride.user.models.responseModels.BalanceResponse;
import bd.com.letsride.user.models.responseModels.SendOTPData;
import bd.com.letsride.user.models.responseModels.UserProfileData;
import bd.com.letsride.user.models.responseModels.UserProfileResponse;
import bd.com.letsride.user.utilities.BaseFragment;
import bd.com.letsride.user.utilities.ProgressDialogHelper;
import bd.com.letsride.user.utilities.ResponseModelDAO;
import bd.com.letsride.user.utilities.SessionManager;
import bd.com.letsride.user.utilities.UtilityClass;
import retrofit2.Call;
import retrofit2.Callback;


public class DashboardFragment extends BaseFragment {

    View view;
    ViewGroup container;
    TextView tvUserName, tvReferCode, tvGreeting, tvBalance, tvExpireDate;
    Button btnShareCode;
    private RecyclerView recyclerView;
    private List<RideUpcomingModel> rideDetailsList;
    private RideUpcomingAdapter rideAdapter;
    SessionManager session;

    public DashboardFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        session = new SessionManager(getActivity().getApplicationContext());
        this.container = container;

        tvGreeting = view.findViewById(R.id.TextView_Greeting);
        tvUserName = view.findViewById(R.id.TextView_UserName);
        tvReferCode = view.findViewById(R.id.TextView_ReferralCode);
        tvBalance = view.findViewById(R.id.TextView_Current_Balance);
        tvExpireDate = view.findViewById(R.id.TextView_Expired_Date);
        btnShareCode = view.findViewById(R.id.Button_Share_Refer_Code);

        btnShareCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Get 100% off on your first move at Let's Ride. To accept, register and use the refer code: " + tvReferCode.getText() + "\n\nDownload now: https://developer.android.com/training/sharing/");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvGreeting.setText(setGreetingMessage());

        LoadUserProfile();
        LoadUserBalance();
        LoadUpcomingRide(container);
    }

    private void StoreUserDataToSharedPref()
    {
        UserProfileData info = new ResponseModelDAO().getUserProfileResponse();
        session.createLoginSession("1",info.getCountryCode(),info.getPhoneNumber(),info.getFirstName(),info.getLastName(),"0",info.getReferralCode(),"1920","00124");
    }

    private String setGreetingMessage() {
        int timeNow = Calendar.getInstance().getTime().getHours();
        if ((timeNow >= 5) && (timeNow <= 12)) {
            return "Good Morning";
        } else if ((timeNow > 12) && (timeNow <= 16)) {
            return "Good Afternoon";
        } else if ((timeNow > 16) && (timeNow < 20)) {
            return "Good Evening";
        } else {
            return "Good Night";
        }
    }

    private void LoadUserProfile() {
        if (UtilityClass.isNetworkAvailable(getActivity().getApplicationContext())) {

            SendOTPData sendOTPData = new ResponseModelDAO().getSendOTPResponse();
            ProgressDialogHelper.ShowDialog(getActivity(), "", "Profile loading...");

            ApiInterface apiService = ApiClient.getClient(getActivity().getApplicationContext()).create(ApiInterface.class);
            Call<UserProfileResponse> call = apiService.requestGetUserByName("Bearer" + " " + session.fetchAuthToken(), "Rider", sendOTPData.getMobileNumber());
            call.enqueue(new Callback<UserProfileResponse>() {
                @Override
                public void onResponse(@NonNull Call<UserProfileResponse> call, @NonNull retrofit2.Response<UserProfileResponse> response) {
                    try {
                        if (response.body() != null) {
                            if (response.body().getSucceeded()) {
                                UserProfileData info = response.body().getUserProfileData();
                                new ResponseModelDAO().addUserProfileResponseToDAO(info);
                                //StoreUserDataToSharedPref();

                                tvUserName.setText(info.getFirstName() + " " + info.getLastName());
                                tvReferCode.setText(info.getReferralCode().toString());
                            } else {
                                Toast.makeText(getActivity().getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getActivity().getApplicationContext(), "Response not found", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        ProgressDialogHelper.DismissDialog();
                    }
                }

                @Override
                public void onFailure(Call<UserProfileResponse> call, Throwable t) {
                    Log.d("A1920:Error", t.getMessage());
                    ProgressDialogHelper.DismissDialog();
                }
            });
        }
    }

    private void LoadUserBalance() {
        if (UtilityClass.isNetworkAvailable(getActivity().getApplicationContext())) {

            SendOTPData sendOTPData = new ResponseModelDAO().getSendOTPResponse();

            ApiInterface apiService = ApiClient.getClient(getActivity().getApplicationContext()).create(ApiInterface.class);
            Call<BalanceResponse> call = apiService.requestGetBalance("Bearer" + " " + session.fetchAuthToken(), "Rider", sendOTPData.getMobileNumber());
            call.enqueue(new Callback<BalanceResponse>() {
                @Override
                public void onResponse(@NonNull Call<BalanceResponse> call, @NonNull retrofit2.Response<BalanceResponse> response) {
                    try {
                        if (response.body() != null) {
                            if (response.body().getSucceeded()) {

                                BalanceData balance = response.body().getBalanceData();
                                tvBalance.setText(balance.getCurrency() + " " + balance.getCurrentBalance());
                                tvExpireDate.setText("Expired on " + balance.getBalanceExpiryDate());

                                new ResponseModelDAO().addBalanceResponseToDAO(balance);
                            } else {
                                Toast.makeText(getActivity().getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getActivity().getApplicationContext(), "Response not found", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        ProgressDialogHelper.DismissDialog();
                    }
                }

                @Override
                public void onFailure(Call<BalanceResponse> call, Throwable t) {
                    Log.d("A1920:Error", t.getMessage());
                    ProgressDialogHelper.DismissDialog();
                }
            });
        }
    }

    private void LoadUpcomingRide(ViewGroup container) {
        rideDetailsList = GetAllRideDetails();
        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView_Ride_Upcoming);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(container.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), 0));
        recyclerView.setLayoutManager(mLayoutManager);
        rideAdapter = new RideUpcomingAdapter(container.getContext(), rideDetailsList);
        recyclerView.setAdapter(rideAdapter);
        rideAdapter.notifyDataSetChanged();
    }

    public List<RideUpcomingModel> GetAllRideDetails() {
        List<RideUpcomingModel> rModel = new ArrayList<RideUpcomingModel>();
        rModel.add(new RideUpcomingModel("Mirpur 12 Bus Stand >> Gulshan Police Plaza", "19 January, 2022", "6:08 AM", "120 BDT.", "Habibur Miya"));
        rModel.add(new RideUpcomingModel("Gulshan Police Plaza >> Mirpur 12 Bus Stand", "20 January, 2022", "6:08 AM", "120 BDT.", "Habibur Miya"));
        rModel.add(new RideUpcomingModel("Mirpur 12 Bus Stand >> Gulshan Police Plaza", "21 January, 2022", "6:08 AM", "120 BDT.", "Habibur Miya"));
        rModel.add(new RideUpcomingModel("Gulshan Police Plaza >> Mirpur 12 Bus Stand", "22 January, 2022", "6:08 AM", "120 BDT.", "Habibur Miya"));
        rModel.add(new RideUpcomingModel("Mirpur 12 Bus Stand >> Gulshan Police Plaza", "23 January, 2022", "6:08 AM", "120 BDT.", "Habibur Miya"));
        rModel.add(new RideUpcomingModel("Gulshan Police Plaza >> Mirpur 12 Bus Stand", "24 January, 2022", "6:08 AM", "120 BDT.", "Habibur Miya"));
        rModel.add(new RideUpcomingModel("Mirpur 12 Bus Stand >> Gulshan Police Plaza", "25 January, 2022", "6:08 AM", "120 BDT.", "Habibur Miya"));
        rModel.add(new RideUpcomingModel("Gulshan Police Plaza >> Mirpur 12 Bus Stand", "26 January, 2022", "6:08 AM", "120 BDT.", "Habibur Miya"));
        rModel.add(new RideUpcomingModel("Mirpur 12 Bus Stand >> Gulshan Police Plaza", "27 January, 2022", "6:08 AM", "120 BDT.", "Habibur Miya"));
        rModel.add(new RideUpcomingModel("Gulshan Police Plaza >> Mirpur 12 Bus Stand", "28 January, 2022", "6:08 AM", "120 BDT.", "Habibur Miya"));
        rModel.add(new RideUpcomingModel("Mirpur 12 Bus Stand >> Gulshan Police Plaza", "29 January, 2022", "6:08 AM", "120 BDT.", "Habibur Miya"));
        rModel.add(new RideUpcomingModel("Gulshan Police Plaza >> Mirpur 12 Bus Stand", "30 January, 2022", "6:08 AM", "120 BDT.", "Habibur Miya"));
        rModel.add(new RideUpcomingModel("MMirpur 12 Bus Stand >> Gulshan Police Plaza", "01 February, 2022", "6:08 AM", "120 BDT.", "Habibur Miya"));
        rModel.add(new RideUpcomingModel("Gulshan Police Plaza >> Mirpur 12 Bus Stand", "02 February, 2022", "6:08 AM", "120 BDT.", "Habibur Miya"));

        return rModel;
    }
}
