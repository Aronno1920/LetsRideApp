package bd.com.letsride.user.fragments;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bd.com.letsride.user.R;
import bd.com.letsride.user.adapters.SettingMenuAdapter;
import bd.com.letsride.user.models.SettingMenuModel;
import bd.com.letsride.user.utilities.BaseFragment;

public class SettingFragment extends BaseFragment {

    private ListView mainListView;
    private ArrayAdapter<SettingMenuModel> listAdapter;
    List<SettingMenuModel> arrayOfUsers;
    OnSettingsFragmentInteraction mListener;

    public SettingFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_setting, container, false);

        arrayOfUsers = GetAllSettingMenu();
        mainListView = (ListView) view.findViewById(R.id.ListView_Settings_Menu);
        listAdapter = new SettingMenuAdapter(container.getContext(), arrayOfUsers);
        mainListView.setAdapter(listAdapter);
        register();

        return view;
    }

    private void register() {
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onSettingsButtonClicked(arrayOfUsers.get(position));
            }
        });
    }

    public List<SettingMenuModel> GetAllSettingMenu() {
        List<SettingMenuModel> aMenu = new ArrayList<SettingMenuModel>();
        aMenu.add(new SettingMenuModel(1,"Home", "There is nothing like HOME", "ic_mlogo_home", false));
        aMenu.add(new SettingMenuModel(2,"Profile", "Update your profile", "ic_mlogo_profile", true));
        aMenu.add(new SettingMenuModel(3, "My Offers", "View your offers", "", true));
        aMenu.add(new SettingMenuModel(4,"Purchase Credit", "Rechagge your wallet", "ic_mlogo_home", false));
        aMenu.add(new SettingMenuModel(5,"Monthly Package", "Monthly tension free package", "ic_mlogo_monthly", true));
        aMenu.add(new SettingMenuModel(6,"Available Routes", "Choose your nearest route", "ic_mlogo_home", false));
        aMenu.add(new SettingMenuModel(7,"My Rides", "View your previous ride", "ic_mlogo_home", true));
        aMenu.add(new SettingMenuModel(8,"My Upcoming Rides", "View your upcoming ride plan", "ic_mlogo_home", true));
        aMenu.add(new SettingMenuModel(9,"My Transactions", "View your clear transaction histry", "ic_mlogo_transaction", true));
        aMenu.add(new SettingMenuModel(10,"Customer Support", "Face any problem or want to ask", "ic_mlogo_support", false));
        aMenu.add(new SettingMenuModel(11,"Call 999", "Call 999 In-case of emergency", "ic_mlogo_emergency", false));
        aMenu.add(new SettingMenuModel(12,"Policies", "View trams and policy", "ic_mlogo_policies", true));
        aMenu.add(new SettingMenuModel(13,"Log Out", "", "ic_mlogo_logout", false));

        return aMenu;
    }

    //Start callback function for fragment redirection
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSettingsFragmentInteraction) {
            mListener = (OnSettingsFragmentInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSettingsFragmentInteraction");
        }
    }

    public interface OnSettingsFragmentInteraction {
        void onSettingsButtonClicked(SettingMenuModel settingMenuModel);
    }
    //End callback
}