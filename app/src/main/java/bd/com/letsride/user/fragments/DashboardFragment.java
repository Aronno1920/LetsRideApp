package bd.com.letsride.user.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import bd.com.letsride.user.R;
import bd.com.letsride.user.adapters.RideDetailsAdapter;
import bd.com.letsride.user.models.RideDetailsModel;
import bd.com.letsride.user.utilities.BaseFragment;

public class DashboardFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private List<RideDetailsModel> rideDetailsList;
    private RideDetailsAdapter rideAdapter;

    public DashboardFragment()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        rideDetailsList = GetAllRideDetails();
        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView_UpcomingRide);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(container.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), 0));
        recyclerView.setLayoutManager(mLayoutManager);
        rideAdapter = new RideDetailsAdapter(container.getContext(), rideDetailsList);
        recyclerView.setAdapter(rideAdapter);
        rideAdapter.notifyDataSetChanged();

        return view;
    }

    public List<RideDetailsModel> GetAllRideDetails(){
        List<RideDetailsModel> rModel = new ArrayList<RideDetailsModel>();
        rModel.add(new RideDetailsModel("Mirpur 1 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideDetailsModel("Mirpur 2 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideDetailsModel("Mirpur 3 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideDetailsModel("Mirpur 4 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideDetailsModel("Mirpur 5 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideDetailsModel("Mirpur 6 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideDetailsModel("Mirpur 7 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideDetailsModel("Mirpur 8 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideDetailsModel("Mirpur 9 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideDetailsModel("Mirpur 10 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideDetailsModel("Mirpur 11 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideDetailsModel("Mirpur 12 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideDetailsModel("Mirpur 13 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));
        rModel.add(new RideDetailsModel("Mirpur 14 >> Gulshan", "19 January, 2022", "6:08 AM", "120 BDT.", "Niyaj Ahmed Firoz"));

        return rModel;
    }
}
