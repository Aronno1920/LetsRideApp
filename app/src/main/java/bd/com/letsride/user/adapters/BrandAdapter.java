package bd.com.letsride.user.adapters;

//
//import android.content.Context;
//import android.graphics.Typeface;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import net.orion_group.oriongrouppmd.R;
//import net.orion_group.oriongrouppmd.model.ProductModel;
//
//import java.util.List;
//
//public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.MyViewHolder> {
//
//    private Context context;
//    private List<ProductModel> productList;
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
//    public BrandAdapter(List<ProductModel> productsList, Context context) {
//        this.context = context;
//        this.productList = productsList;
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
//        ProductModel product = productList.get(position);
//        if (product.getBrand().toString() != null) {
//            holder.lblName.setText(product.getProductName());
//            holder.lblBrand.setText(product.getBrand().toString().replace("*", "\u25CF"));
//
//            holder.lblName.setTypeface(custom_font);
//            holder.lblBrand.setTypeface(custom_font);
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return productList.size();
//    }
//}