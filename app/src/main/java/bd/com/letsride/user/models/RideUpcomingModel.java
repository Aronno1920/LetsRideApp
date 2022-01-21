package bd.com.letsride.user.models;

public class RideUpcomingModel {

    private String ZoneName;
    private String RideDate;
    private String RideTime;
    private String RidePrice;
    private String DriverName;

    public RideUpcomingModel(String zoneName, String rideDate, String rideTime, String ridePrice, String driverName) {
        ZoneName = zoneName;
        RideDate = rideDate;
        RideTime = rideTime;
        RidePrice = ridePrice;
        DriverName = driverName;
    }

    public String getZoneName() {
        return ZoneName;
    }

    public void setZoneName(String zoneName) {
        ZoneName = zoneName;
    }

    public String getRideDate() {
        return RideDate;
    }

    public void setRideDate(String rideDate) {
        RideDate = rideDate;
    }

    public String getRideTime() {
        return RideTime;
    }

    public void setRideTime(String rideTime) {
        RideTime = rideTime;
    }

    public String getRidePrice() {
        return RidePrice;
    }

    public void setRidePrice(String ridePrice) {
        RidePrice = ridePrice;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }
}
