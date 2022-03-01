package bd.com.letsride.user.presentation.activities;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import bd.com.letsride.user.R;
import bd.com.letsride.user.models.SettingMenuModel;
import bd.com.letsride.user.presentation.fragments.CreditFragment;
import bd.com.letsride.user.presentation.fragments.DashboardFragment;
import bd.com.letsride.user.presentation.fragments.RouteSelectorFragment;
import bd.com.letsride.user.presentation.fragments.RoutesFragment;
import bd.com.letsride.user.presentation.fragments.SettingFragment;
import bd.com.letsride.user.utilities.BaseActivity;
import bd.com.letsride.user.utilities.FragmentRouting;

public class HomeActivity extends BaseActivity implements SettingFragment.OnSettingsFragmentInteraction, RoutesFragment.OnRouteFragmentInteraction {

    int whereToGo;
    SettingMenuModel settingMenuModel;
    BottomNavigationView bottomNavigationView;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        registerActions();

        loadFragment(new DashboardFragment());
    }

//    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
//            new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    switch (item.getItemId()) {
//                        case R.id.home:
//                            loadFragment(new DashboardFragment());
//                            break;
//                        case R.id.credit:
//                            loadFragment(new CreditFragment());
//                            break;
//                        case R.id.routes:
//                            loadFragment(new RoutesFragment());
//                            break;
//                        case R.id.settings:
//                            loadFragment(new SettingFragment());
//                            break;
//                    }
//                    return false;
//                }
//            };

    private void registerActions() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        loadFragment(new DashboardFragment());
                        break;
                    case R.id.credit:
                        loadFragment(new CreditFragment());
                        break;
                    case R.id.bookride:
                        loadFragment(new RouteSelectorFragment());
                        break;
                    case R.id.routes:
                        loadFragment(new RoutesFragment());
                        break;
                    case R.id.settings:
                        loadFragment(new SettingFragment());
                        break;
                }
                return false;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.linLayoutContainer, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    @Override
    public void onSettingsButtonClicked(SettingMenuModel settingMenuModel) {
        this.settingMenuModel = settingMenuModel;

        Integer selectedMenuId = settingMenuModel.getMenuId();

        switch (selectedMenuId) {
            case 1: // Home
                loadFragment(new DashboardFragment());
                break;
            case 2: // Profile
                //showToast("TUESDAY");
                break;
            case 3: // My Offers
                //showToast("WEDNESDAY");
                break;
            case 4: // Purchase Credit
                loadFragment(new CreditFragment());
                break;
            case 5: // Monthly Package
                //showToast("FRIDAY");
                break;
            case 6: // Available Routes
                loadFragment(new RoutesFragment());
                break;
            case 7: // My Rides
                //showToast("SUNDAY");
                break;
            case 8: // My Upcoming Rides
                //showToast("SUNDAY");
                break;
            case 9: // My Transctions
                //showToast("SUNDAY");
                break;
            case 10: // Customer Support
                callCustomerCare();
                break;
            case 11: // Calll 999
                callEmergencyNumber();
                break;
            case 12: // Policies
                //showToast("SUNDAY");
                break;
            case 13: // Log out
                //showToast("SUNDAY");
                break;
        }
    }

    private void callCustomerCare() {
        String phone = "01821644177";
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + phone));
        startActivity(callIntent);
    }

    private void callEmergencyNumber() {
        String phone = "999";
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + phone));
        startActivity(callIntent);
    }

    @Override
    public void onRouteButtonClicked(int whereToGo) {
        if (whereToGo == FragmentRouting.DashboardFragment) {
            loadFragment(new DashboardFragment());
        }
    }
}