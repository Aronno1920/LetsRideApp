package bd.com.letsride.user.models;

public class RouteTimeModel {

    private String StartTime;

    public RouteTimeModel(String startTime) {
        StartTime = startTime;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }
}
