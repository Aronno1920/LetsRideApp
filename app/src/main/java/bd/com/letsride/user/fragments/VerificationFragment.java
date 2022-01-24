package bd.com.letsride.user.fragments;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import bd.com.letsride.user.R;
import bd.com.letsride.user.activities.HomeActivity;
import bd.com.letsride.user.utilities.BaseFragment;

public class VerificationFragment extends BaseFragment {

    Button btnVerify;

    public VerificationFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_verification, container, false);
        btnVerify = (Button) view.findViewById(R.id.Button_Verify);

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }

    @Override
    public void setHeaderSection(String strPageTitle, boolean isBackButtonVisiable, boolean isHistoryButtonVisiable) {

    }
}