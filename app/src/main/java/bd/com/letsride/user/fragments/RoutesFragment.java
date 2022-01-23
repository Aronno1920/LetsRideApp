package bd.com.letsride.user.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Fragment;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import bd.com.letsride.user.R;
import bd.com.letsride.user.adapters.AvailableRouteAdapter;
import bd.com.letsride.user.adapters.RideUpcomingAdapter;
import bd.com.letsride.user.models.RouteModel;
import bd.com.letsride.user.utilities.BaseFragment;

public class RoutesFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private List<RouteModel> routeList;
    private AvailableRouteAdapter routeAdapter;

    public RoutesFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_routes, container, false);

        routeList = GetAllRoutes();
        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView_Available_Route);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), 0));
        recyclerView.setLayoutManager(mLayoutManager);
        routeAdapter = new AvailableRouteAdapter(container.getContext(), routeList);
        recyclerView.setAdapter(routeAdapter);
        routeAdapter.notifyDataSetChanged();

        return view;
    }

    public List<RouteModel> GetAllRoutes() {
        List<RouteModel> aRoute = new ArrayList<RouteModel>();
        aRoute.add(new RouteModel("Mirpur 1", "Motijheeel", "Via Kalshi", "Pickup 1, Pickup 2, Pickup 3, Pickup 4..."));
        aRoute.add(new RouteModel("Mirpur 1", "Matijheel", "Via Agargaon", "Pickup 1, Pickup 2, Pickup 3, Pickup 4..."));
        aRoute.add(new RouteModel("Mirpur 130", "Dhanmondi 32", "Via ha", "Pickup 1, Pickup 2, Pickup 3, Pickup 4..."));
        aRoute.add(new RouteModel("Mirpur 140", "Dhanmondi 01", "Via adsf", "Pickup 1, Pickup 2, Pickup 3, Pickup 4..."));
        aRoute.add(new RouteModel("Mirpur 150", "Dhanmondi 05", "Via 3ere", "Pickup 1, Pickup 2, Pickup 3, Pickup 4..."));
        aRoute.add(new RouteModel("Mirpur 260", "Dhanmondi 89", "Via twert", "Pickup 1, Pickup 2, Pickup 3, Pickup 4..."));
        aRoute.add(new RouteModel("Gulshan 500", "Uttara", "Via ywtr", "Pickup 1, Pickup 2, Pickup 3, Pickup 4..."));
        aRoute.add(new RouteModel("Uttara 1000", "Badda", "Via wert", "Pickup 1, Pickup 2, Pickup 3, Pickup 4..."));
        aRoute.add(new RouteModel("Uttara 1500", "Badda", "Via wert", "Pickup 1, Pickup 2, Pickup 3, Pickup 4..."));
        aRoute.add(new RouteModel("Uttara 2000", "Dhanmondi 25", "Via zxv", "Pickup 1, Pickup 2, Pickup 3, Pickup 4..."));
        aRoute.add(new RouteModel("Uttara 2500", "Dhanmondi 12", "Via asdf", "Pickup 1, Pickup 2, Pickup 3, Pickup 4..."));
        aRoute.add(new RouteModel("Uttara 3000", "Dhanmondi 20", "Via rfadf", "Pickup 1, Pickup 2, Pickup 3, Pickup 4..."));

        return aRoute;
    }
}