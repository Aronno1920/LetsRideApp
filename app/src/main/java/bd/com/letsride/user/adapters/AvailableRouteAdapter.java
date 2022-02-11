package bd.com.letsride.user.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import bd.com.letsride.user.R;
import bd.com.letsride.user.models.responseModels.AvailableRouteData;

public class AvailableRouteAdapter extends RecyclerView.Adapter<AvailableRouteAdapter.MyViewHolder> {

    private Context mContext;
    private List<AvailableRouteData> routeList = new ArrayList<AvailableRouteData>();

    public AvailableRouteAdapter(Context mContext, List<AvailableRouteData> allCreditList) {
        this.mContext = mContext;
        this.routeList = allCreditList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtPickupLocation, txtDropOffLocation, txtPickupZone, txtDropOffZone, txtZoneCode, txtViaZone, txtDescription;

        public MyViewHolder(View view) {
            super(view);
            txtPickupLocation = (TextView) view.findViewById(R.id.TextView_PickupLocation);
            txtDropOffLocation = (TextView) view.findViewById(R.id.TextView_DropOffLocation);

            txtPickupZone = (TextView) view.findViewById(R.id.TextView_PickupZone);
            txtDropOffZone = (TextView) view.findViewById(R.id.TextView_DropOffZone);
            txtZoneCode = (TextView) view.findViewById(R.id.TextView_ZoneCode);

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
        Typeface font_normal = Typeface.createFromAsset(mContext.getAssets(), "fonts/candara.ttf");
        Typeface font_italic = Typeface.createFromAsset(mContext.getAssets(), "fonts/candara_italic.ttf");
        Typeface font_bold = Typeface.createFromAsset(mContext.getAssets(), "fonts/candara_bold.ttf");

        AvailableRouteData aRoute = routeList.get(position);

        holder.txtPickupLocation.setText(aRoute.getPickupLocation());
        holder.txtDropOffLocation.setText(aRoute.getDropOffLocation());
        holder.txtPickupZone.setText(aRoute.getPickupLocation());
        holder.txtDropOffZone.setText(aRoute.getDropOffLocation());
        holder.txtZoneCode.setText(aRoute.getPickupLocation());
        holder.txtViaZone.setText(aRoute.getPickupLocation());

        holder.txtPickupLocation.setTypeface(font_bold);
        holder.txtDropOffLocation.setTypeface(font_bold);
        holder.txtPickupZone.setTypeface(font_bold);
        holder.txtDropOffZone.setTypeface(font_bold);
        holder.txtZoneCode.setTypeface(font_bold);
        holder.txtViaZone.setTypeface(font_normal);
        holder.txtDescription.setTypeface(font_italic);
    }

    @Override
    public int getItemCount() {
        return routeList.size();
    }
}
