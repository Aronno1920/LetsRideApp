package bd.com.letsride.user.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bd.com.letsride.user.R;
import androidx.recyclerview.widget.RecyclerView;
import bd.com.letsride.user.presentation.activities.HomeActivity;
import bd.com.letsride.user.models.responseModels.DepositConfigData;
import bd.com.letsride.user.presentation.bottomSheet.CreditPurchaseButtomSheet;

public class CreditPurchaseAdapter extends RecyclerView.Adapter<CreditPurchaseAdapter.MyViewHolder> {

    private Context mContext;
    private List<DepositConfigData> creditList = new ArrayList<DepositConfigData>();

    public CreditPurchaseAdapter(Context mContext, List<DepositConfigData> allCreditList) {
        this.mContext = mContext;
        this.creditList = allCreditList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtAmount, txtBonus;
        LinearLayout layoutCredit;

        public MyViewHolder(View view) {
            super(view);
            txtAmount = (TextView) view.findViewById(R.id.TextView_CreditAmount);
            txtBonus = (TextView) view.findViewById(R.id.TextView_BonusAmount);
            layoutCredit = (LinearLayout) view.findViewById(R.id.linearlayout_credit_package);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_credit_purchase, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Typeface font_bold = Typeface.createFromAsset(mContext.getAssets(), "fonts/candara_bold.ttf");
        Typeface font_normal = Typeface.createFromAsset(mContext.getAssets(), "fonts/candara.ttf");

        DepositConfigData aCredit = creditList.get(position);
        holder.txtAmount.setText(String.valueOf(aCredit.getAmount()));
        if (aCredit.getBonus() > 0) {
            holder.txtBonus.setText("Bonus amount :" + String.valueOf(aCredit.getBonus()));
        }

        holder.txtAmount.setTypeface(font_bold);
        holder.txtBonus.setTypeface(font_normal);

        holder.layoutCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreditPurchaseButtomSheet bottomSheet = new CreditPurchaseButtomSheet();

                DepositConfigData credit = creditList.get(holder.getAdapterPosition());

                Bundle bundle = new Bundle();
                bundle.putInt("current_balance", 20);
                bundle.putInt("recharge_balance", credit.getAmount());
                bottomSheet.setArguments(bundle);

                bottomSheet.show(((HomeActivity) mContext).getSupportFragmentManager(), "ModalBottomSheet");
            }
        });
    }

    @Override
    public int getItemCount() {
        return creditList.size();
    }
}