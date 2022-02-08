package bd.com.letsride.user.utilities;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;

import bd.com.letsride.user.R;

public class ProgressDialogHelper {
    private static ProgressDialog progressDialog;
    Context context;

    public ProgressDialogHelper(Context context) {
        this.context = context;
        progressDialog = new ProgressDialog(context, R.style.Theme_AppCompat_Dialog_Alert);
    }

    public static void ShowDialog(Context context, String title, String message) {
        try {
            if (progressDialog == null) {
                progressDialog = ProgressDialog.show(context, title, message, true);
                progressDialog.setCancelable(true);
//                progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            }
        } catch (Exception e) {

        }
    }

    public static void DismissDialog() {
        if ((progressDialog != null) && progressDialog.isShowing())
            progressDialog.dismiss();
        progressDialog = null;
    }
}
