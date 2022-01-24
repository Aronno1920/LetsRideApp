package bd.com.letsride.user.fragments;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import bd.com.letsride.user.R;
import bd.com.letsride.user.adapters.CreditPurchaseAdapter;
import bd.com.letsride.user.models.CreditPurchaseModel;
import bd.com.letsride.user.utilities.AutoFitGridLayoutManager;
import bd.com.letsride.user.utilities.BaseFragment;

public class CreditFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private List<CreditPurchaseModel> creditList;
    private CreditPurchaseAdapter creditAdapter;

    //Start Header Section
    private View view;
    private TextView txtHeaderTitle;
    public LinearLayout llHeaderBackButton;
    public LinearLayout llHeaderHistoryButton;
    //End Header Section

    public CreditFragment()
    {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_credit, container, false);

        creditList = GetAllCredits();
        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView_Credit_Purchase);

        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(getActivity().getApplicationContext(), 400);
        recyclerView.setLayoutManager(layoutManager);
        creditAdapter = new CreditPurchaseAdapter(container.getContext(), creditList);
        recyclerView.setAdapter(creditAdapter);
        creditAdapter.notifyDataSetChanged();

        setHeaderSection(getString(R.string.fragment_title_purchase_credit), true, true);

        return view;
    }

    //Start Header Section
    @Override
    public void setHeaderSection(String strPageTitle, boolean isBackButtonVisiable, boolean isHistoryButtonVisiable) {
        txtHeaderTitle = (TextView) view.findViewById(R.id.txtTitleInNewHeader);
        llHeaderBackButton = (LinearLayout) view.findViewById(R.id.imageViewBackButtonInNewHeader);
        llHeaderHistoryButton = (LinearLayout) view.findViewById(R.id.imvHistoryButtonInHeader);

        txtHeaderTitle.setText(strPageTitle);
        if(isBackButtonVisiable==false)
        {
            llHeaderBackButton.setVisibility(View.GONE);
        }
        if(isHistoryButtonVisiable==false){
            llHeaderHistoryButton.setVisibility(View.GONE);
        }
    }
    //End Header Section

    public List<CreditPurchaseModel> GetAllCredits(){
        List<CreditPurchaseModel> cModel = new ArrayList<CreditPurchaseModel>();
        cModel.add(new CreditPurchaseModel(100, 0));
        cModel.add(new CreditPurchaseModel(120, 0));
        cModel.add(new CreditPurchaseModel(130, 0));
        cModel.add(new CreditPurchaseModel(140, 0));
        cModel.add(new CreditPurchaseModel(150, 0));
        cModel.add(new CreditPurchaseModel(260, 0));
        cModel.add(new CreditPurchaseModel(500, 0));
        cModel.add(new CreditPurchaseModel(1000, 25));
        cModel.add(new CreditPurchaseModel(1500, 50));
        cModel.add(new CreditPurchaseModel(2000, 100));
        cModel.add(new CreditPurchaseModel(2500, 150));
        cModel.add(new CreditPurchaseModel(3000, 200));

        return cModel;
    }
}