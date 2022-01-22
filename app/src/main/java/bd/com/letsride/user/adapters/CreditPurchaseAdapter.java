package bd.com.letsride.user.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import bd.com.letsride.user.R;
import bd.com.letsride.user.activities.HomeActivity;
import bd.com.letsride.user.bottomSheet.CreditPurchaseButtomSheet;
import bd.com.letsride.user.models.CreditPurchaseModel;


public class CreditPurchaseAdapter extends RecyclerView.Adapter<CreditPurchaseAdapter.MyViewHolder> {

    private Context mContext;
    private List<CreditPurchaseModel> creditList = new ArrayList<CreditPurchaseModel>();

    public CreditPurchaseAdapter(Context mContext, List<CreditPurchaseModel> allCreditList) {
        this.mContext = mContext;
        this.creditList = allCreditList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtAmount, txtBonus;
        LinearLayout layoutContainerCredit;

        public MyViewHolder(View view) {
            super(view);
            txtAmount = (TextView) view.findViewById(R.id.TextView_CreditAmount);
            txtBonus = (TextView) view.findViewById(R.id.TextView_BonusAmount);
            layoutContainerCredit = (LinearLayout) view.findViewById(R.id.layoutContainerCredit);
        }
    }

    @Override
    public CreditPurchaseAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_credit_purchase, parent, false);
        return new CreditPurchaseAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CreditPurchaseAdapter.MyViewHolder holder, int position) {
        CreditPurchaseModel aCredit = creditList.get(position);
        holder.txtAmount.setText(aCredit.getAmount());
        if(Integer.parseInt(aCredit.getBonusAmount())>0)
        {
            holder.txtBonus.setText("Bonus BDT. "+aCredit.getBonusAmount());
        }

        holder.layoutContainerCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreditPurchaseButtomSheet bottomSheet = new CreditPurchaseButtomSheet();

                CreditPurchaseModel credit = creditList.get(holder.getAdapterPosition());

                Bundle bundle = new Bundle();
                bundle.putString("price", credit.getAmount());
                bottomSheet.setArguments(bundle);

                bottomSheet.show(((HomeActivity)mContext).getSupportFragmentManager(), "ModalBottomSheet");
            }
        });
    }

    @Override
    public int getItemCount() {
        return creditList.size();
    }
}
