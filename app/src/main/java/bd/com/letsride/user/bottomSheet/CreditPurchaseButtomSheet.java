package bd.com.letsride.user.bottomSheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import bd.com.letsride.user.R;
import bd.com.letsride.user.utilities.BaseButtomSheetFragment;

public class CreditPurchaseButtomSheet extends BaseButtomSheetFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.buttom_sheet_credit_purchase, container, false);

        Bundle bundle = getArguments();
        Integer current = bundle.getInt("current_balance");
        Integer recharge = bundle.getInt("recharge_balance");

        Button algo_button = v.findViewById(R.id.algo_button);
        Button course_button = v.findViewById(R.id.course_button);
        TextView lblCurrent = v.findViewById(R.id.button_sheet_current_balance);
        TextView lblRecharge = v.findViewById(R.id.button_sheet_recharge_balance);
        TextView lblNew = v.findViewById(R.id.button_sheet_new_balance);

        int newMyBalance = current + recharge;
        lblCurrent.setText(String.valueOf(current));
        lblRecharge.setText(String.valueOf(recharge));
        lblNew.setText(String.valueOf(newMyBalance));

        algo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),
                        "Payment Successfull. Thanks for support us.", Toast.LENGTH_SHORT)
                        .show();
                dismiss();
            }
        });

        course_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),
                        "Sorry! You can process your request.", Toast.LENGTH_SHORT)
                        .show();
                dismiss();
            }
        });
        return v;
    }
}