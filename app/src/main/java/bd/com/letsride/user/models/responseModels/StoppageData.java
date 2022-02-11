package bd.com.letsride.user.models.responseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StoppageData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("lattitude")
    @Expose
    private String lattitude;
    @SerializedName("sortOrder")
    @Expose
    private Integer sortOrder;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLattitude() {
        return lattitude;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }
}
