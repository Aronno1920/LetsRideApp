package bd.com.letsride.user.presentation.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import bd.com.letsride.user.R;
import bd.com.letsride.user.adapters.AvailableRouteAdapter;
import bd.com.letsride.user.apiClasses.ApiClient;
import bd.com.letsride.user.apiClasses.ApiInterface;
import bd.com.letsride.user.models.responseModels.AvailableRouteData;
import bd.com.letsride.user.models.responseModels.AvailableRouteResponse;
import bd.com.letsride.user.models.responseModels.SendOTPData;
import bd.com.letsride.user.utilities.BaseFragment;
import bd.com.letsride.user.utilities.ProgressDialogHelper;
import bd.com.letsride.user.utilities.ResponseModelDAO;
import bd.com.letsride.user.utilities.SessionManager;
import bd.com.letsride.user.utilities.UtilityClass;
import retrofit2.Call;
import retrofit2.Callback;

public class RoutesFragment extends BaseFragment {

    View view;
    ViewGroup container;
    private RecyclerView recyclerView;
    private List<AvailableRouteData> routeList;
    private AvailableRouteAdapter routeAdapter;
    SessionManager session;

    public RoutesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_routes, container, false);
        session = new SessionManager(getActivity().getApplicationContext());
        this.container = container;

        GetAllAvailableRoutes();

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LoadUpcomingRide(container);
    }

    private void LoadUpcomingRide(ViewGroup container) {
        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView_Available_Route);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), 0));
        recyclerView.setLayoutManager(mLayoutManager);
        routeAdapter = new AvailableRouteAdapter(container.getContext(), routeList);
        recyclerView.setAdapter(routeAdapter);
        routeAdapter.notifyDataSetChanged();
    }

    private void GetAllAvailableRoutes() {
        if (UtilityClass.isNetworkAvailable(getActivity().getApplicationContext())) {

            ProgressDialogHelper.ShowDialog(getActivity(), "", "Route loading...");

            routeList = new ArrayList<AvailableRouteData>();
            SendOTPData sendOTPData = new ResponseModelDAO().getSendOTPResponse();

            ApiInterface apiService = ApiClient.getClient(getActivity().getApplicationContext()).create(ApiInterface.class);
            Call<AvailableRouteResponse> call = apiService.requestAllAvailableRoutes("Bearer" + " " + session.fetchAuthToken());
            call.enqueue(new Callback<AvailableRouteResponse>() {
                @Override
                public void onResponse(@NonNull Call<AvailableRouteResponse> call, @NonNull retrofit2.Response<AvailableRouteResponse> response) {
                    try {
                        if (response.body() != null) {
                            if (response.body().getSucceeded()) {

                                routeList = response.body().getAvailableRoutesData();

                                //new ResponseModelDAO().addBalanceResponseToDAO(balance);
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
                public void onFailure(Call<AvailableRouteResponse> call, Throwable t) {
                    Log.d("A1920:Error", t.getMessage());
                    ProgressDialogHelper.DismissDialog();
                }
            });
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRouteFragmentInteraction) {
            mListener = (OnRouteFragmentInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnRouteFragmentInteraction");
        }
    }

    OnRouteFragmentInteraction mListener;
    public interface OnRouteFragmentInteraction {
        void onRouteButtonClicked(int whereToGo);
    }
}