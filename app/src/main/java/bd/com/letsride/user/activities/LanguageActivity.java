package bd.com.letsride.user.activities;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import bd.com.letsride.user.R;
import bd.com.letsride.user.utilities.BaseActivity;
import bd.com.letsride.user.utilities.SessionManager;

public class LanguageActivity extends BaseActivity {

    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        session = new SessionManager(getApplicationContext());
        Button btnBangla = findViewById(R.id.btnBangla);
        Button btnEnglish = findViewById(R.id.btnEnglish);

        btnBangla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.SetAppsDefaultLanguage("bn");

                Intent intent = new Intent(LanguageActivity.this, WelcomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.SetAppsDefaultLanguage("en");

                Intent intent = new Intent(LanguageActivity.this, WelcomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}