package bd.com.letsride.user.models.responseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AvailableRouteData {

    @SerializedName("routePathId")
    @Expose
    private Integer routePathId;
    @SerializedName("routePathCode")
    @Expose
    private String routePathCode;
    @SerializedName("zoneFrom")
    @Expose
    private String zoneFrom;
    @SerializedName("zoneTo")
    @Expose
    private String zoneTo;
    @SerializedName("pickupLocation")
    @Expose
    private String pickupLocation;
    @SerializedName("pickupLocationLattitude")
    @Expose
    private String pickupLocationLattitude;
    @SerializedName("pickupLocationLongitude")
    @Expose
    private String pickupLocationLongitude;
    @SerializedName("dropOffLocation")
    @Expose
    private String dropOffLocation;
    @SerializedName("dropOffLocationLattitude")
    @Expose
    private String dropOffLocationLattitude;
    @SerializedName("dropOffLocationLongitude")
    @Expose
    private String dropOffLocationLongitude;
    @SerializedName("routePathName")
    @Expose
    private String routePathName;
    @SerializedName("routePathDescription")
    @Expose
    private String routePathDescription;
    @SerializedName("routePathDistance")
    @Expose
    private Double routePathDistance;
    @SerializedName("routePathDistanceMetric")
    @Expose
    private String routePathDistanceMetric;
    @SerializedName("stoppages")
    @Expose
    private List<StoppageData> stoppages = null;

    public Integer getRoutePathId() {
        return routePathId;
    }

    public String getRoutePathCode() {
        return routePathCode;
    }

    public String getZoneFrom() {
        return zoneFrom;
    }

    public String getZoneTo() {
        return zoneTo;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getPickupLocationLattitude() {
        return pickupLocationLattitude;
    }

    public String getPickupLocationLongitude() {
        return pickupLocationLongitude;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public String getDropOffLocationLattitude() {
        return dropOffLocationLattitude;
    }

    public String getDropOffLocationLongitude() {
        return dropOffLocationLongitude;
    }

    public String getRoutePathName() {
        return routePathName;
    }

    public String getRoutePathDescription() {
        return routePathDescription;
    }

    public Double getRoutePathDistance() {
        return routePathDistance;
    }

    public String getRoutePathDistanceMetric() {
        return routePathDistanceMetric;
    }

    public List<StoppageData> getStoppages() {
        return stoppages;
    }
}
