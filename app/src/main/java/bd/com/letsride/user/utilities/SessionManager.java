package bd.com.letsride.user.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.HashMap;


public class SessionManager {
    SharedPreferences pref;
    Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "OrionPMH_Pref";
    private static final String IS_SET_LANGUAGE = "false";
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String USER_TOKEN = "user_token";

//User Information as Session
//    public static final String KEY_REGID = "id";
//    public static final String KEY_LOGIN_ID = "emp_id";
//    public static final String KEY_NAME = "name";
//    public static final String KEY_DESIGNATION = "designation";
    public static final String KEY_DEFAULT_LANGUAGE="en";


    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

//    public void createLoginSession(String regID, String empid, String name, String desig, String location, String company, String photopath, String versionCode, String versionName) {
//        editor.putBoolean(IS_LOGIN, true);
//        editor.putString(KEY_REGID, regID);
//        editor.putString(KEY_LOGIN_ID, empid);
//        editor.putString(KEY_NAME, name);
//        editor.putString(KEY_DESIGNATION, desig);
//        editor.putString(KEY_LOCATION, location);
//        editor.putString(KEY_COMPANY, company);
//        editor.putString(KEY_PHOTOPATH, photopath);
//        editor.putString(KEY_VERSION_CODE, versionCode);
//        editor.putString(KEY_VERSION_NAME, versionName);
//        editor.commit();
//    }



//    public void checkLogin() {
//        if (!this.isLoggedIn()) {
//            Intent i = new Intent(_context, LoginActivity.class);
//            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            _context.startActivity(i);
//        }
//    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
//        user.put(KEY_REGID, pref.getString(KEY_REGID, null));
//        user.put(KEY_LOGIN_ID, pref.getString(KEY_LOGIN_ID, null));
//        user.put(KEY_NAME, pref.getString(KEY_NAME, null));
//        user.put(KEY_DESIGNATION, pref.getString(KEY_DESIGNATION, null));
//        user.put(KEY_LOCATION, pref.getString(KEY_LOCATION, null));
//        user.put(KEY_COMPANY, pref.getString(KEY_COMPANY, null));
//        user.put(KEY_PHOTOPATH, pref.getString(KEY_PHOTOPATH, null));
//        user.put(KEY_VERSION_CODE, pref.getString(KEY_VERSION_CODE, null));
//        user.put(KEY_VERSION_NAME, pref.getString(KEY_VERSION_NAME, null));
        return user;
    }

//    public void logoutUser() {
//        editor.clear();
//        editor.commit();
//        Intent i = new Intent(_context, LoginActivity.class);
//        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        _context.startActivity(i);
//    }
//
//    public boolean isLoggedIn() {
//        return pref.getBoolean(IS_LOGIN, false);
//    }

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
