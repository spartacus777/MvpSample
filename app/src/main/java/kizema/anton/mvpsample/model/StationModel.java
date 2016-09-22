package kizema.anton.mvpsample.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.google.gson.annotations.SerializedName;

import java.util.List;


@Table(name = "StationModel")
public class StationModel extends Model{

    public static final String TITLE = "title";
    public static final String DESCR = "description";

    @SerializedName("id")
    @Column(name = DESCR, unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    private int stationId;

    @SerializedName("display_name")
    @Column(name = TITLE)
    private String title;

    public String getTitle() {
        return title;
    }

    public int getStationId() {
        return stationId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    @Override
    public String toString(){
        StringBuilder builder =  new StringBuilder();
        builder.append("title").append(" : ").append(title).append("\n")
                .append("id : ").append(stationId).append("\n");

        return builder.toString();
    }

    public static List<StationModel> getAll(){
        return new Select().from(StationModel.class).execute();
    }
}
