package bd.com.letsride.user.models;

public class RouteModel {

    private String PickZoneName;
    private String DropZoneName;
    private String ViaZoneName;
    private String ZoneDescription;

    public RouteModel(String pickZoneName, String dropZoneName, String viaZoneName, String zoneDescription) {
        PickZoneName = pickZoneName;
        DropZoneName = dropZoneName;
        ViaZoneName = viaZoneName;
        ZoneDescription = zoneDescription;
    }

    public String getPickZoneName() {
        return PickZoneName;
    }

    public void setPickZoneName(String pickZoneName) {
        PickZoneName = pickZoneName;
    }

    public String getDropZoneName() {
        return DropZoneName;
    }

    public void setDropZoneName(String dropZoneName) {
        DropZoneName = dropZoneName;
    }

    public String getViaZoneName() {
        return ViaZoneName;
    }

    public void setViaZoneName(String viaZoneName) {
        ViaZoneName = viaZoneName;
    }

    public String getZoneDescription() {
        return ZoneDescription;
    }

    public void setZoneDescription(String zoneDescription) {
        ZoneDescription = zoneDescription;
    }
}
