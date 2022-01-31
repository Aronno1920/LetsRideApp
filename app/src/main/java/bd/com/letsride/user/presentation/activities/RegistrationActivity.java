package bd.com.letsride.user.presentation.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import bd.com.letsride.user.R;
import bd.com.letsride.user.presentation.fragments.RegistrationFragment;
import bd.com.letsride.user.utilities.BaseActivity;

public class RegistrationActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.your_placeholder, new RegistrationFragment());
        fragmentTransaction.commit();
    }
}