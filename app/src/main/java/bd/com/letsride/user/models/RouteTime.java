package bd.com.letsride.user.models;

public class RouteTime {

    private String StartTime;

    public RouteTime(String startTime) {
        StartTime = startTime;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }
}
