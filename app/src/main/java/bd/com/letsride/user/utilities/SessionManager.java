package bd.com.letsride.user.utilities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.HashMap;

import bd.com.letsride.user.presentation.activities.LoginActivity;


public class SessionManager {
    SharedPreferences pref;
    Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "LetsRide_Pref";
    private static final String IS_SET_LANGUAGE = "false";
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String USER_TOKEN = "user_token";
    private static final String KEY_DEFAULT_LANGUAGE="en";
    private static final String KEY_VERSION_CODE="en";
    private static final String KEY_VERSION_NAME="en";


    private static final String KEY_UserID = "user_id";
    private static final String KEY_CountryCode = "country_code";
    private static final String KEY_MobileNumber = "mobile_number";
    private static final String KEY_FirstName = "first_name";
    private static final String KEY_LastName = "last_name";
    private static final String KEY_CurrentBalance = "current_balance";
    private static final String KEY_ReferCode = "refer_code";


    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String userID, String countryCode, String mobileNumber, String firstName, String lastName, String currentBalance, String referCode, String versionCode, String versionName) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_UserID, userID);
        editor.putString(KEY_CountryCode, countryCode);
        editor.putString(KEY_MobileNumber, mobileNumber);
        editor.putString(KEY_FirstName, firstName);
        editor.putString(KEY_LastName, lastName);
        editor.putString(KEY_CurrentBalance, currentBalance);
        editor.putString(KEY_ReferCode, referCode);
        editor.putString(KEY_VERSION_CODE, versionCode);
        editor.putString(KEY_VERSION_NAME, versionName);
        editor.commit();
    }


    public void checkLogin() {
        if (!this.IsLoggedIn()) {
            Intent i = new Intent(_context, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);
        }
    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_UserID, pref.getString(KEY_UserID, null));
        user.put(KEY_CountryCode, pref.getString(KEY_CountryCode, null));
        user.put(KEY_MobileNumber, pref.getString(KEY_MobileNumber, null));
        user.put(KEY_FirstName, pref.getString(KEY_FirstName, null));
        user.put(KEY_LastName, pref.getString(KEY_LastName, null));
        user.put(KEY_CurrentBalance, pref.getString(KEY_CurrentBalance, null));
        user.put(KEY_ReferCode, pref.getString(KEY_ReferCode, null));
        user.put(KEY_VERSION_CODE, pref.getString(KEY_VERSION_CODE, null));
        user.put(KEY_VERSION_NAME, pref.getString(KEY_VERSION_NAME, null));
        return user;
    }

    public void LogoutUser() {
        editor.clear();
        editor.commit();
        Intent i = new Intent(_context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);
    }

    public boolean IsLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }

    public void SetAppsDefaultLanguage(String locate) {
        editor.putString(KEY_DEFAULT_LANGUAGE, locate);
        editor.putBoolean(IS_SET_LANGUAGE, true);
        editor.commit();
    }

    public String GetAppsDefaultLanguage(){
        return pref.getString(KEY_DEFAULT_LANGUAGE, "bn");
    }

    public boolean IsSetLanguage() {
        return pref.getBoolean(IS_SET_LANGUAGE, false);
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void saveAuthToken(String token) {
        editor.putString(USER_TOKEN, token);
        editor.commit();
    }

    public String fetchAuthToken()
    {
        return pref.getString(USER_TOKEN, null);
    }
}
