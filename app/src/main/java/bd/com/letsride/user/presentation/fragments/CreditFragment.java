package bd.com.letsride.user.presentation.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bd.com.letsride.user.R;
import bd.com.letsride.user.adapters.CreditPurchaseAdapter;
import bd.com.letsride.user.apiClasses.ApiClient;
import bd.com.letsride.user.apiClasses.ApiInterface;
import bd.com.letsride.user.models.responseModels.DepositConfigData;
import bd.com.letsride.user.models.responseModels.DepositConfigResponse;
import bd.com.letsride.user.utilities.AutoFitGridLayoutManager;
import bd.com.letsride.user.utilities.BaseFragment;
import bd.com.letsride.user.utilities.SessionManager;
import bd.com.letsride.user.utilities.UtilityClass;
import retrofit2.Call;
import retrofit2.Callback;

public class CreditFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private List<DepositConfigData> depositList;
    private CreditPurchaseAdapter creditAdapter;
    SessionManager session;

    public CreditFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    View view;
    ViewGroup container;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_credit, container, false);
        session = new SessionManager(getActivity().getApplicationContext());
        this.container = container;

        requestAllDepositConfig();

        return view;
    }

    private void buildRecyclerView(ViewGroup container) {
        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView_Credit_Purchase);
        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(getActivity().getApplicationContext(), 400);
        recyclerView.setLayoutManager(layoutManager);
        creditAdapter = new CreditPurchaseAdapter(container.getContext(), depositList);
        recyclerView.setAdapter(creditAdapter);
        creditAdapter.notifyDataSetChanged();
    }

    private void requestAllDepositConfig() {
        if (UtilityClass.isNetworkAvailable(getActivity().getApplicationContext())) {

            ApiInterface apiService = ApiClient.getClient(getActivity().getApplicationContext()).create(ApiInterface.class);
            Call<DepositConfigResponse> call = apiService.requestAllDepositConfig("Bearer" + " " + session.fetchAuthToken());
            call.enqueue(new Callback<DepositConfigResponse>() {
                @Override
                public void onResponse(Call<DepositConfigResponse> call, retrofit2.Response<DepositConfigResponse> response) {
                    if (response.code() == 200) {
                        DepositConfigResponse result = (DepositConfigResponse) response.body();

                        if (result.getSucceeded()) {

                            depositList = result.getDepositConfigData();
                            buildRecyclerView(container);
                            //new ResponseModelDAO().addSendOTPResponseToDAO(myOTP);
                        } else {
                            Toast.makeText(getActivity().getApplicationContext(), "Hoynai", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Hoitona", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<DepositConfigResponse> call, Throwable t) {
                    Log.d("A1920:Error", t.getMessage());
                }
            });
        }
    }
}