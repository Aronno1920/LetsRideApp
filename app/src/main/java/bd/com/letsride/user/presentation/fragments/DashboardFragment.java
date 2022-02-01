package bd.com.letsride.user.presentation.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import bd.com.letsride.user.R;
import bd.com.letsride.user.adapters.RideUpcomingAdapter;
import bd.com.letsride.user.apiClasses.ApiClient;
import bd.com.letsride.user.apiClasses.ApiInterface;
import bd.com.letsride.user.models.RideUpcomingModel;
import bd.com.letsride.user.models.responseModels.UserProfileData;
import bd.com.letsride.user.models.responseModels.UserProfileResponse;
import bd.com.letsride.user.utilities.BaseFragment;
import bd.com.letsride.user.utilities.UtilityClass;
import retrofit2.Call;
import retrofit2.Callback;

public class DashboardFragment extends BaseFragment {

    View view;
    TextView tvUserName, tvReferCode;
    private RecyclerView recyclerView;
    private List<RideUpcomingModel> rideDetailsList;
    private RideUpcomingAdapter rideAdapter;

    public DashboardFragment()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        tvUserName = view.findViewById(R.id.TextVew_UserName);
        tvReferCode =view.findViewById(R.id.TextVew_ReferalCode);

        LoadUpcomingRide(container);
        LoadUserProfile();

        return view;
    }

    private void LoadUserProfile() {
        if (UtilityClass.isNetworkAvailable(getActivity().getApplicationContext())) {

            //SendOTPData sendOTPData = new ResponseModelDAO().getSendOTPResponse();

            ApiInterface apiService = ApiClient.getClient(getActivity().getApplicationContext()).create(ApiInterface.class);
            Call<UserProfileResponse> call = apiService.requestUserProfile("Rider","01912875657"); //sendOTPData.getMobileNumber().toString());
            call.enqueue(new Callback<UserProfileResponse>() {
                @Override
                public void onResponse(Call<UserProfileResponse> call, retrofit2.Response<UserProfileResponse> response) {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                    }
                    if (response.body().getSucceeded()) {


                        //Store API Response to Temporary memory
                        UserProfileData info = response.body().getUserProfileData();
                        tvUserName.setText(info.getFirstName()+" "+info.getLastName());
                        tvReferCode.setText(info.getReferralCode().toString());

                        //new ResponseModelDAO().addSendOTPResponseToDAO(myOTP);
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<UserProfileResponse> call, Throwable t) {
                    Log.d("A1920:Error", t.getMessage());
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

    public List<RideUpcomingModel> GetAllRideDetails(){
        List<RideUpcomingModel> rModel = new ArrayList<RideUpcomingModel>();
        rModel.add(new RideUpcomingModel("Mirpur 1 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideUpcomingModel("Mirpur 2 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideUpcomingModel("Mirpur 3 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideUpcomingModel("Mirpur 4 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideUpcomingModel("Mirpur 5 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideUpcomingModel("Mirpur 6 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideUpcomingModel("Mirpur 7 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideUpcomingModel("Mirpur 8 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideUpcomingModel("Mirpur 9 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideUpcomingModel("Mirpur 10 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideUpcomingModel("Mirpur 11 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideUpcomingModel("Mirpur 12 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideUpcomingModel("Mirpur 13 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideUpcomingModel("Mirpur 14 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));

        return rModel;
    }
}
