package bd.com.letsride.user.models;

public class RoutePathModel {
    private Integer PathSerial;
    private String PathName;

    public RoutePathModel(Integer pathSerial, String pathName) {
        PathSerial = pathSerial;
        PathName = pathName;
    }

    public Integer getPathSerial() {
        return PathSerial;
    }

    public void setPathSerial(Integer pathSerial) {
        PathSerial = pathSerial;
    }

    public String getPathName() {
        return PathName;
    }

    public void setPathName(String pathName) {
        PathName = pathName;
    }
}