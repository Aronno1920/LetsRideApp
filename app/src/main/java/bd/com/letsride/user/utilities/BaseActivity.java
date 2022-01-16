package bd.com.letsride.user.utilities;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public abstract class BaseActivity extends AppCompatActivity {

    SessionManager session;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        session = new SessionManager(getApplicationContext());

        setApplicationFonts();
        setApplicationLocale();
    }

    private void setApplicationFonts(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            FontManager fontManager = FontManager.getInstance(this);
            fontManager.replaceFonts((ViewGroup) this.findViewById(android.R.id.content));
        }
    }

    private void setApplicationLocale() {
        String locale = session.GetAppsDefaultLanguage();

        Toast.makeText(getApplicationContext(),locale, Toast.LENGTH_SHORT);

        Resources resources = getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(new Locale(locale.toLowerCase()));
        } else {
            config.locale = new Locale(locale.toLowerCase());
        }
        resources.updateConfiguration(config, dm);
    }
}