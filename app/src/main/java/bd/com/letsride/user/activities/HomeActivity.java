package bd.com.letsride.user.activities;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.widget.Toast;

import bd.com.letsride.user.R;
import bd.com.letsride.user.fragments.CreditFragment;
import bd.com.letsride.user.fragments.DashboardFragment;
import bd.com.letsride.user.fragments.RoutesFragment;
import bd.com.letsride.user.utilities.BaseActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends BaseActivity {

    BottomNavigationView bottomNavigationView;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initializeUI();
        registerActions();

        loadFragment(DashboardFragment.newInstance("", ""));
    }

    private void registerActions() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        loadFragment(DashboardFragment.newInstance("", ""));
                        break;
                    case R.id.credit:
                        loadFragment(CreditFragment.newInstance("", ""));
                        break;
                    case R.id.routes:
                        loadFragment(RoutesFragment.newInstance("", ""));
                        break;
                }
                return true;
            }
        });

    }

    private void loadFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.linLayoutContainer, fragment).commit();
    }

    private void initializeUI() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
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
}