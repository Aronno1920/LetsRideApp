package bd.com.letsride.user.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import bd.com.letsride.user.R;
import bd.com.letsride.user.utilities.SessionManager;

public class SplashActivity extends AppCompatActivity {

    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_splash);
        session = new SessionManager(getApplicationContext());

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

//                    if(session.IsSetLanguage()==false){
//                        Intent login = new Intent(SplashActivity.this, LanguageActivity.class);
//                        startActivity(login);
//                    }
//                    else if (CheckUserLoginStatus()) {
//                        Intent login = new Intent(SplashActivity.this, LoginActivity.class);
//                        startActivity(login);
//                    } else {
//                        Intent login = new Intent(SplashActivity.this, LanguageActivity.class);
//                        startActivity(login);
//                    }

                    Intent login = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(login);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    private boolean CheckUserLoginStatus() {
        //return session.isLoggedIn();
        return false;
    }
}
