package bd.com.letsride.user.adapters;

//
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Typeface;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import net.orion_group.oriongrouppmd.R;
//import net.orion_group.oriongrouppmd.activity.ActionDetailsActivity;
//import net.orion_group.oriongrouppmd.fragment.TerminologyFragment;
//import net.orion_group.oriongrouppmd.model.TerminologyModel;
//
//import java.util.List;
//
//public class TerminologyAdapter extends RecyclerView.Adapter<TerminologyAdapter.MyViewHolder> {
//
//    private Context context;
//    private List<TerminologyModel> terminologyList;
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        public TextView lblName, lblBrand;
//
//        public MyViewHolder(View view) {
//            super(view);
//            lblName = (TextView) view.findViewById(R.id.lblProductName);
//            lblBrand = (TextView) view.findViewById(R.id.lblProductDetails);
//        }
//    }
//
//    public TerminologyAdapter(List<TerminologyModel> terminologyList, Context context) {
//        this.context = context;
//        this.terminologyList = terminologyList;
//    }
//
//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_brand, parent, false);
//
//        return new MyViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position) {
//        Typeface custom_font = Typeface.createFromAsset(context.getAssets(), "fonts/CANDARA.TTF");
//
//        TerminologyModel product = terminologyList.get(position);
//        holder.lblName.setText(product.getTermName());
//        holder.lblBrand.setText(product.getTermDescription());
//
//        holder.lblName.setTypeface(custom_font);
//        holder.lblBrand.setTypeface(custom_font);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return terminologyList.size();
//    }
//
//}