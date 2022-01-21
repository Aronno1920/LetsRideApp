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
import bd.com.letsride.user.models.RouteModel;

public class AvailableRouteAdapter extends RecyclerView.Adapter<AvailableRouteAdapter.MyViewHolder> {

    private Context mContext;
    private List<RouteModel> routeList = new ArrayList<RouteModel>();

    public AvailableRouteAdapter(Context mContext, List<RouteModel> allCreditList) {
        this.mContext = mContext;
        this.routeList = allCreditList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtPickup, txtDropOff, txtViaZone, txtDescription;

        public MyViewHolder(View view) {
            super(view);
            txtPickup = (TextView) view.findViewById(R.id.TextView_Pickup_Zone);
            txtDropOff = (TextView) view.findViewById(R.id.TextView_DropOff_Zone);
            txtViaZone = (TextView) view.findViewById(R.id.TextView_Via_Zone);
            txtDescription = (TextView) view.findViewById(R.id.TextView_Zone_Description);
        }
    }

    @Override
    public AvailableRouteAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_available_route, parent, false);
        return new AvailableRouteAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AvailableRouteAdapter.MyViewHolder holder, int position) {
        RouteModel aRoute = routeList.get(position);

        holder.txtPickup.setText(aRoute.getPickZoneName());
        holder.txtDropOff.setText(aRoute.getDropZoneName());
        if (aRoute.getViaZoneName() != null && !aRoute.getViaZoneName().trim().isEmpty()) {
            holder.txtViaZone.setText(aRoute.getViaZoneName());
        }
        holder.txtDescription.setText(aRoute.getZoneDescription());
    }

    @Override
    public int getItemCount() {
        return routeList.size();
    }
}
