package bd.com.letsride.user.utilities;

import android.app.Fragment;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;

import java.util.Locale;

public class BaseFragment extends Fragment {

    SessionManager session;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        session = new SessionManager(getActivity());

        //setApplicationFonts();
        setApplicationLocale();
    }

    private void setApplicationFonts() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            FontManager fontManager = FontManager.getInstance(getActivity());
            fontManager.replaceFonts((ViewGroup) this.getView());
        }
    }

    private void setApplicationLocale() {
        String locale = session.GetAppsDefaultLanguage();
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