package bd.com.letsride.user.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import bd.com.letsride.user.R;
import bd.com.letsride.user.models.RideUpcomingModel;

public class RideUpcomingAdapter extends RecyclerView.Adapter<RideUpcomingAdapter.MyViewHolder> {

    private Context mContext;
    private List<RideUpcomingModel> myRideList = new ArrayList<RideUpcomingModel>();

    public RideUpcomingAdapter(Context mContext, List<RideUpcomingModel> rideList) {
        this.mContext = mContext;
        this.myRideList = rideList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtZoneName, txtRideDate, txtRideTime, txtRidePrice, txtDriverName;

        public MyViewHolder(View view) {
            super(view);
            txtZoneName = (TextView) view.findViewById(R.id.TextView_ZoneName);
            txtRideDate = (TextView) view.findViewById(R.id.TextView_RideDate);
            txtRideTime = (TextView) view.findViewById(R.id.TextView_RideTime);
            txtRidePrice = (TextView) view.findViewById(R.id.TextView_RidePrice);
            txtDriverName = (TextView) view.findViewById(R.id.TextView_DriverName);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_ride_details, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        //Typeface custom_font = Typeface.createFromAsset(mContext.getAssets(), "fonts/Ubuntu-Regular.TTF");
        RideUpcomingModel myRide = myRideList.get(position);

        holder.txtZoneName.setText(myRide.getZoneName());
        holder.txtRideDate.setText(myRide.getRideDate());
        holder.txtRideTime.setText(myRide.getRideTime());
        holder.txtRidePrice.setText(myRide.getRidePrice());
        holder.txtDriverName.setText(myRide.getDriverName());

//        holder.txtZoneName.setTypeface(custom_font);
//        holder.txtRideDate.setTypeface(custom_font);
//        holder.txtRideTime.setTypeface(custom_font);
//        holder.txtRidePrice.setTypeface(custom_font);
//        holder.txtDriverName.setTypeface(custom_font);
    }

    @Override
    public int getItemCount() {
        return myRideList.size();
    }
}